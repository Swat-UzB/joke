package com.example.jokeapplication.screens;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.jokeapplication.adapters.JokeAdapter;
import com.example.jokeapplication.databinding.ActivityMainBinding;
import com.example.jokeapplication.pojo.Joke;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private JokeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        JokeAdapter jokeAdapter = new JokeAdapter();
        mainBinding.jokeRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mainBinding.jokeRecyclerView.setAdapter(jokeAdapter);
        viewModel = new ViewModelProvider(this).get(JokeViewModel.class);

        viewModel.getJokes().observe(this, new androidx.lifecycle.Observer<Joke>() {
            @Override
            public void onChanged(Joke joke) {
                jokeAdapter.setJokes(joke);
//                Log.d("TTT", "onChanged: "+joke.getFlags().getExplicit().toString());
            }
        });
        viewModel.getErrors().observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                if (throwable != null) {
                    Toast.makeText(MainActivity.this, "Yuklashda xatolik yuzberdi", Toast.LENGTH_SHORT).show();
                    viewModel.clearErrors();
                }
            }
        });
        viewModel.loadData();
    }
}