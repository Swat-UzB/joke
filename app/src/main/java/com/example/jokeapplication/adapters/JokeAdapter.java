package com.example.jokeapplication.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jokeapplication.databinding.JokeItemBinding;
import com.example.jokeapplication.pojo.Joke;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

    private Joke joke;

    public void setJoke(Joke joke) {
        this.joke = joke;
        notifyDataSetChanged();
    }

    public JokeAdapter() {
        joke = new Joke();
    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JokeViewHolder(JokeItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull JokeAdapter.JokeViewHolder holder, int position) {
        holder.jokeItemBinding.categoryTextView.setText(joke.getCategory());
        holder.jokeItemBinding.deliveryTextView.setText(joke.getDelivery());
        holder.jokeItemBinding.setupTextView.setText(joke.getSetup());
    }

    @Override
    public int getItemCount() {
        return joke == null ? 0 : 1;
    }

    public class JokeViewHolder extends RecyclerView.ViewHolder {
        private JokeItemBinding jokeItemBinding;

        public JokeViewHolder(@NonNull JokeItemBinding jokeItemBinding) {
            super(jokeItemBinding.getRoot());
            this.jokeItemBinding = jokeItemBinding;
        }
    }
}
