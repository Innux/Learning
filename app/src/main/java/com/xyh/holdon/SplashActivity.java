package com.xyh.holdon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import com.xyh.holdon.utils.SharedPreUtil;

public class SplashActivity extends AppCompatActivity {

    private RelativeLayout mRlSplash;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        mContext = this;

        mRlSplash = (RelativeLayout) findViewById(R.id.rl_splash);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);

        mRlSplash.startAnimation(alphaAnimation);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                boolean isFirst = SharedPreUtil.getBoolean(mContext, "is_first_enter", true);
                Intent intent;

                if (isFirst) {
                    //第一次进入，跳转至新手引导界面
                    intent = new Intent(mContext, GuideAvtivity.class);
                } else {
                    //跳转至主页面
                    intent = new Intent(mContext, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
