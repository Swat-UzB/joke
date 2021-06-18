package com.example.jokeapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.jokeapplication.adapters.JokeAdapter;
import com.example.jokeapplication.api.ApiFactory;
import com.example.jokeapplication.api.ApiService;
import com.example.jokeapplication.databinding.ActivityMainBinding;
import com.example.jokeapplication.pojo.Joke;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        JokeAdapter jokeAdapter = new JokeAdapter();
        mainBinding.jokeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.jokeRecyclerView.setAdapter(jokeAdapter);
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
                    public void onNext(Joke joke) {
                        Log.d("TTT", "onNext: " + joke.getType());
                        jokeAdapter.setJoke(joke);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "yuklashda xatolik", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}