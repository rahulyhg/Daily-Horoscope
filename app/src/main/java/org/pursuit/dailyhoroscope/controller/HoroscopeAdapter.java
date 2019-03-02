package org.pursuit.dailyhoroscope.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.dailyhoroscope.R;

import java.util.List;

public class HoroscopeAdapter extends RecyclerView.Adapter<HoroscopeViewHolder> {
    private String[] signs;

    public HoroscopeAdapter(String[] signs) {
        this.signs = signs;
    }

    @NonNull
    @Override
    public HoroscopeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.horoscope_itemview, viewGroup, false);
        return new HoroscopeViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull HoroscopeViewHolder horoscopeViewHolder, int i) {
        horoscopeViewHolder.onBind(signs[i]);
    }

    @Override
    public int getItemCount() {
        return signs.length;
    }
}
