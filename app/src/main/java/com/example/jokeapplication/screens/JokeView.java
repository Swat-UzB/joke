package com.example.jokeapplication.screens;

import com.example.jokeapplication.pojo.Joke;

import java.util.List;

public interface JokeView {
    void showData(List<Joke> jokes);
    void showError();
}
