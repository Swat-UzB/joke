package com.example.jokeapplication.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.jokeapplication.pojo.Joke;

import java.util.List;

@Dao
public interface JokeDao {
    @Query("SELECT * FROM joke")
    LiveData<List<Joke>> getAllJokes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertJokes(List<Joke> jokes);

    @Query("DELETE FROM joke")
    void deleteAllJokes(); 

}
