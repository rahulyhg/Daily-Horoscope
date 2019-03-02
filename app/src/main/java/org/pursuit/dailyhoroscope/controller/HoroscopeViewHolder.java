package org.pursuit.dailyhoroscope.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.dailyhoroscope.DisplayHoroscope;
import org.pursuit.dailyhoroscope.MainActivity;
import org.pursuit.dailyhoroscope.R;


class HoroscopeViewHolder extends RecyclerView.ViewHolder {
    private CardView cv;
    private TextView signTV;

    public HoroscopeViewHolder(@NonNull View itemView) {
        super(itemView);
        cv = itemView.findViewById(R.id.cv_container);
        signTV = itemView.findViewById(R.id.sunsign);
    }

    protected void onBind(final String sign) {
        signTV.setText(sign);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DisplayHoroscope.class);
                intent.putExtra(MainActivity.INTENT_KEY, sign);
                itemView.getContext().startActivity(intent);
            }
        });
    }

}
