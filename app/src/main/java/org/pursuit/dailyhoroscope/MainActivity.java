package org.pursuit.dailyhoroscope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.dailyhoroscope.controller.HoroscopeAdapter;
import org.pursuit.dailyhoroscope.model.HoroApi;
import org.pursuit.dailyhoroscope.model.Signs;
import org.pursuit.dailyhoroscope.network.HoroscopeService;
import org.pursuit.dailyhoroscope.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "not it";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRetroFit(setUpRecyclerView());
    }

    public void setUpRetroFit(final RecyclerView recyclerView) {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        Call<String[]> call = retrofit.create(HoroscopeService.class).getSignsEndPoint();
        Log.d(TAG, "setUpRetroFit: " + call.request());
        call.enqueue(new Callback<String[]>() {
            @Override
            public void onResponse(Call<String[]> call, Response<String[]> response) {
                Log.d(TAG, "onResponse: " + response.body()[0]);
                recyclerView.setAdapter(new HoroscopeAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<String[]> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }

        });
    }

    public RecyclerView setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        return recyclerView;
    }
}
