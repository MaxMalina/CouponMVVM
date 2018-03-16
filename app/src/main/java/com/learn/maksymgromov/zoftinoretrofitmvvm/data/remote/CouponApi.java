package com.learn.maksymgromov.zoftinoretrofitmvvm.data.remote;

import com.learn.maksymgromov.zoftinoretrofitmvvm.data.Coupon;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CouponApi {

    @GET("topCoupon/")
    Call<Coupon>  getTopCoupon();
}
