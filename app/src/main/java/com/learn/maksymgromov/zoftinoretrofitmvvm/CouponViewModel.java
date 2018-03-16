package com.learn.maksymgromov.zoftinoretrofitmvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.learn.maksymgromov.zoftinoretrofitmvvm.data.Coupon;
import com.learn.maksymgromov.zoftinoretrofitmvvm.data.remote.CouponRepository;


public class CouponViewModel extends AndroidViewModel {
    private LiveData<Coupon> liveCoupon;
    private CouponRepository couponRepository = new CouponRepository();

    public CouponViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Coupon> getCoupon() {
        if(liveCoupon == null){
            liveCoupon = couponRepository.getTopCouponLive();
        }
        return liveCoupon;
    }
}
