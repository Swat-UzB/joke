package com.example.jokeapplication.screens;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.jokeapplication.api.ApiFactory;
import com.example.jokeapplication.api.ApiService;
import com.example.jokeapplication.data.AppDatabase;
import com.example.jokeapplication.pojo.Joke;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class JokeViewModel extends AndroidViewModel {
    private static AppDatabase db;
    private LiveData<Joke> jokes;
    private MutableLiveData<Throwable> errors;

    public LiveData<Throwable> getErrors() {
        return errors;
    }


    public JokeViewModel(@NonNull Application application) {
        super(application);
        db = AppDatabase.getInstance(application);
        jokes = db.jokeDao().getAllJokes();
        errors = new MutableLiveData<>();
    }

    public LiveData<Joke> getJokes() {
        return jokes;
    }

    private void deleteJokes() {
        new DeleteJokeTask().execute();
    }

    private void insertJokes(Joke jokes) {
        new InsertJokeTask().execute(jokes);
    }

    private static class InsertJokeTask extends AsyncTask<Joke, Void, Void> {

        @Override
        protected Void doInBackground(Joke... jokes) {
            if (jokes != null) {
                db.jokeDao().insertJokes(jokes[0]);
            }
            return null;
        }
    }

    private static class DeleteJokeTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            db.jokeDao().deleteAllJokes();
            return null;
        }
    }
    public void clearErrors(){
        errors.setValue(null);
    }

    public void loadData() {
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        apiService.getJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Joke>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Joke jokes) {
                        deleteJokes();
                        insertJokes(jokes);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        errors.setValue(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
