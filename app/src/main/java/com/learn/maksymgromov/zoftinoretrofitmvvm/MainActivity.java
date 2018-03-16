package com.learn.maksymgromov.zoftinoretrofitmvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.learn.maksymgromov.zoftinoretrofitmvvm.data.Coupon;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private CouponViewModel couponViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.coupon);

        //get ViewModel using ViewModelProviders and then tech data
        couponViewModel = ViewModelProviders.of(this).get(CouponViewModel.class);

        couponViewModel.getCoupon().observe(this, coupon -> {
                String strCoupon = coupon.getStore() + " " + coupon.getCoupon() + " " + coupon.getCouponCode();
                tv.setText(strCoupon);
        });
    }

    public void getTopCoupon(View view){
        String coupon =  couponViewModel.getCoupon().getValue().getStore()+" "+ couponViewModel.getCoupon().getValue().getCoupon()
                +" "+ couponViewModel.getCoupon().getValue().getCouponCode();
        tv.setText(coupon);
    }
}
