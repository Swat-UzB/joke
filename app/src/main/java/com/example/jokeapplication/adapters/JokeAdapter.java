package com.example.jokeapplication.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jokeapplication.databinding.JokeItemBinding;
import com.example.jokeapplication.pojo.Joke;

import java.util.ArrayList;
import java.util.List;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

    private List<Joke> jokes;


    public JokeAdapter() {
        jokes = new ArrayList<>();
    }

    public void setJokes(List<Joke> jokes) {
        this.jokes.clear();
        this.jokes.addAll(jokes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JokeViewHolder(JokeItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull JokeAdapter.JokeViewHolder holder, int position) {
        Joke joke = jokes.get(position);
        holder.jokeItemBinding.categoryTextView.setText(joke.getCategory());
        holder.jokeItemBinding.deliveryTextView.setText(joke.getDelivery());
        holder.jokeItemBinding.setupTextView.setText(joke.getSetup());
    }

    @Override
    public int getItemCount() {
        return jokes == null ? 0 : jokes.size();
    }

    public class JokeViewHolder extends RecyclerView.ViewHolder {
        private JokeItemBinding jokeItemBinding;

        public JokeViewHolder(@NonNull JokeItemBinding jokeItemBinding) {
            super(jokeItemBinding.getRoot());
            this.jokeItemBinding = jokeItemBinding;
        }
    }
}
