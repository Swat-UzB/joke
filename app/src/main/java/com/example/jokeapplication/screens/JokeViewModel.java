package com.example.jokeapplication.screens;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.jokeapplication.data.AppDatabase;
import com.example.jokeapplication.pojo.Joke;

import java.util.List;

public class JokeViewModel extends AndroidViewModel {
    private AppDatabase db;
    private LiveData<List<Joke>> jokes;

    public JokeViewModel(@NonNull Application application) {
        super(application);
        db = AppDatabase.getInstance(application);
        jokes = db.jokeDao().getAllJokes();
    }

    public LiveData<List<Joke>> getJokes() {
        return jokes;
    }

    public void deleteJokes() {
        db.jokeDao().deleteAllJokes();
    }

    public void insertJokes(List<Joke> jokes) {
        db.jokeDao().insertJokes(jokes);
    }
}
