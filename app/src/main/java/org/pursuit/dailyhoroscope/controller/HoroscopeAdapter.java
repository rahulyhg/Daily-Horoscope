package org.pursuit.dailyhoroscope.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.dailyhoroscope.R;

import java.util.ArrayList;
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
        populateColorList();
        return new HoroscopeViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull HoroscopeViewHolder horoscopeViewHolder, int i) {
        horoscopeViewHolder.onBind(signs[i], populateColorList().get(i));
    }

    @Override
    public int getItemCount() {
        return signs.length;
    }


    public List<String> populateColorList() {
        List<String> colors = new ArrayList<>();
        colors.add("#00574B");
        colors.add("#D81B60");
        colors.add("#851BC2D8");
        colors.add("#85CB1BD8");
        colors.add("#85D8CF1B");
        colors.add("#BC1BD83A");
        colors.add("#3949AB");
        colors.add("#FFF4511E");
        colors.add("#FF00897B");
        colors.add("#FF3558B1");
        colors.add("#FF8E24AA");
        colors.add("#FFD81B60");

        return colors;
    }

}