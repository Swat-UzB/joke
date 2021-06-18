package com.example.jokeapplication.api;

import com.example.jokeapplication.pojo.Joke;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("joke/Any?type=twopart")
    Observable<Joke> getJoke();
}
