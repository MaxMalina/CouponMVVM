package com.learn.maksymgromov.zoftinoretrofitmvvm.data.remote;

import android.util.Log;

import com.learn.maksymgromov.zoftinoretrofitmvvm.data.Coupon;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CouponRepository {

    private static final String BASE_URL = "http://www.zoftino.com/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitCleint() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public Coupon getTopCoupon() {
        final Coupon coupon = new Coupon();
        getRetrofitCleint().create(CouponApi.class).getTopCoupon().enqueue(new Callback<Coupon>() {
            @Override
            public void onResponse(Call<Coupon> call, Response<Coupon> response) {
                Coupon cpn = response.body();

                coupon.setStore(cpn.getStore());
                coupon.setCoupon(cpn.getCoupon());
                coupon.setCouponCode(cpn.getCouponCode());
            }

            @Override
            public void onFailure(Call<Coupon> call, Throwable t) {
                Log.e("", "Error Getting TOP COUPON Data Retrofit");
            }
        });

        return coupon;
    }
}
