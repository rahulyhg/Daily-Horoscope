package org.pursuit.dailyhoroscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.pursuit.dailyhoroscope.model.Horoscope;
import org.pursuit.dailyhoroscope.network.HoroscopeService;
import org.pursuit.dailyhoroscope.network.RetrofitSingleton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DisplayHoroscope extends AppCompatActivity {
    public static final String TAG2 = "freeze tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_horoscope);

        setUpRetrofitDisplay(getIntentString());

    }

    private void setUpRetrofitDisplay(String signName) {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        Call<Horoscope> call = retrofit.create(HoroscopeService.class).getHoroscope(signName);
        Log.d(TAG2, "setUpRetrofit: " + call.request());
        call.enqueue(new Callback<Horoscope>() {
            @Override
            public void onResponse(Call<Horoscope> call, Response<Horoscope> response) {
                Log.d(TAG2, "onResponse: " + response.body().getSunsign());
                Log.d(TAG2, "onResponse: " + response.body().getCredit());
                Log.d(TAG2, "onResponse: " + response.body().getDate());
                Log.d(TAG2, "onResponse: " + response.body().getHoroscope());
                inflateStuff(response);
            }

            @Override
            public void onFailure(Call<Horoscope> call, Throwable t) {
                Log.e(TAG2, "onFailure: " + t.getMessage());
            }
        });
    }

    public String getIntentString() {
        Intent intent = getIntent();
        return intent.getStringExtra(MainActivity.INTENT_KEY);
    }

    public void inflateStuff(Response<Horoscope> response) {
        TextView displaysign = findViewById(R.id.sign_name);
        TextView displayHoro = findViewById(R.id.horoscope_text);
        TextView displayDate = findViewById(R.id.horoscope_date);
//substring 59
        displaysign.setText(response.body().getSunsign());
        displayHoro.setText(response.body().getHoroscope().substring(0, response.body().getHoroscope().length() - 59));
        displayDate.setText(getDate());
    }

    private String getDate() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sf = new SimpleDateFormat("MM-dd-yyyy");
        String formatDate = sf.format(date);
        return formatDate;
    }
}
