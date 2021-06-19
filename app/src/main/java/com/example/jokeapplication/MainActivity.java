package com.example.jokeapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

public class MainActivity extends AppCompatActivity implements JokeView {
    private JokePresenter presenter;
    private JokeAdapter jokeAdapter;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        presenter = new JokePresenter(this);
        jokeAdapter = new JokeAdapter();
        mainBinding.jokeRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mainBinding.jokeRecyclerView.setAdapter(jokeAdapter);
        presenter.loadData();
    }

    @Override
    public void showData(Joke joke) {
        jokeAdapter.setJoke(joke);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Ma\'lumot yuklashda xatolik", Toast.LENGTH_SHORT).show();
    }

}