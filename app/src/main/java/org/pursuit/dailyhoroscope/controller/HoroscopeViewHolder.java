package org.pursuit.dailyhoroscope.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.dailyhoroscope.R;


class HoroscopeViewHolder extends RecyclerView.ViewHolder {
    private TextView signTV;

    public HoroscopeViewHolder(@NonNull View itemView) {
        super(itemView);
        signTV = itemView.findViewById(R.id.sunsign);
    }

    protected void onBind(String sign) {
        signTV.setText(sign);
    }

}
