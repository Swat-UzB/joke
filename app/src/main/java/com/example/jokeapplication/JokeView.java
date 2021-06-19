package com.example.jokeapplication;

import com.example.jokeapplication.pojo.Joke;

public interface JokeView {
    void showData(Joke joke);
    void showError();
}
