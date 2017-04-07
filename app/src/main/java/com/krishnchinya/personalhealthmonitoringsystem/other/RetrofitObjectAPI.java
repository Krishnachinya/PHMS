package com.krishnchinya.personalhealthmonitoringsystem.other;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by KrishnChinya on 3/26/17.
 */

public interface RetrofitObjectAPI {

        @GET("dailymed/services/v2/spls.json?pagesize=5")
        Call<Medicine> getMedicines(@Query("drug_name") String drugname);
}
