package com.example.jokeapplication.api;

import com.example.jokeapplication.pojo.Joke;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("joke/Any?type=twopart&amount=10")
    Observable<List<Joke>> getJoke();
}
