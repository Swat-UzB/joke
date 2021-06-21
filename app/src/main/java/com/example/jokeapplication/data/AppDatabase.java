package com.example.jokeapplication.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.jokeapplication.pojo.Joke;

@Database(entities = {Joke.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "joke.db";
    private static AppDatabase appDatabase;
    private static final Object LOCK = new Object();

    public static AppDatabase getInstance(Context context) {
        synchronized (LOCK) {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).fallbackToDestructiveMigration().build();
            }
            return appDatabase;
        }
    }

    public abstract JokeDao jokeDao();
}
