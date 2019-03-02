package org.pursuit.dailyhoroscope.network;

import org.pursuit.dailyhoroscope.model.HoroApi;
import org.pursuit.dailyhoroscope.model.Horoscope;
import org.pursuit.dailyhoroscope.model.Signs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HoroscopeService {
    @GET("theastrologer/api/")
    Call<HoroApi> getApi();

    @GET("theastrologer/api/horoscope/{sunsign}/today")
    Call<Horoscope> getHoroscope(@Path("sunsign") String sign);

    @GET ("theastrologer/api/sunsigns/")
    Call<String[]> getSignsEndPoint();
}
