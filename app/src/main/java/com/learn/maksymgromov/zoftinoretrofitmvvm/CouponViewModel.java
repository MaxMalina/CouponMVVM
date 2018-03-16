package com.learn.maksymgromov.zoftinoretrofitmvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.learn.maksymgromov.zoftinoretrofitmvvm.data.Coupon;
import com.learn.maksymgromov.zoftinoretrofitmvvm.data.remote.CouponRepository;


public class CouponViewModel extends AndroidViewModel {
    private Coupon coupon;
    private CouponRepository couponRepository = new CouponRepository();

    public CouponViewModel(@NonNull Application application) {
        super(application);
    }

    public Coupon getCoupon() {
        if(coupon == null){
            coupon = couponRepository.getTopCoupon();
        }
        return coupon;
    }
}
