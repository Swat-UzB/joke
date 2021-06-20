package com.example.jokeapplication.screens;

import com.example.jokeapplication.api.ApiFactory;
import com.example.jokeapplication.api.ApiService;
import com.example.jokeapplication.pojo.Joke;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class    JokePresenter {
    private JokeView view;

    public JokePresenter(JokeView view) {
        this.view = view;
    }

    public void loadData() {
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        apiService.getJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Joke>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext( List<Joke> jokes) {
                       view.showData(jokes);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        view.showError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
