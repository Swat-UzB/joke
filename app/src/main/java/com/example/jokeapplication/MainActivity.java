package com.example.jokeapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.jokeapplication.adapters.JokeAdapter;
import com.example.jokeapplication.databinding.ActivityMainBinding;
import com.example.jokeapplication.pojo.Joke;
import com.example.jokeapplication.screens.JokePresenter;
import com.example.jokeapplication.screens.JokeView;

import java.util.List;

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
    public void showData(List<Joke> jokes) {
        jokeAdapter.setJokes(jokes);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Ma\'lumot yuklashda xatolik", Toast.LENGTH_SHORT).show();
    }

}