package com.example.jokeapplication.converters;

import androidx.room.TypeConverter;

import com.example.jokeapplication.pojo.Flags;
import com.google.gson.Gson;

public class Converter {
    @TypeConverter
    public String flagsToString(Flags flags) {
        return new Gson().toJson(flags);
    }

    @TypeConverter
    public Flags stringToFlags(String flagString) {
        Gson gson = new Gson();
        Flags flags = gson.fromJson(flagString, Flags.class);
        return flags;
    }
}
