package com.xyh.holdon.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.xyh.holdon.base.BasePager;

/**
 * Created by xyh on 2017/3/12.
 */

public class SecondPager extends BasePager {

    public SecondPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        System.out.println("2222......");
        TextView textView = new TextView(mActivity);
        textView.setText("这是第二页");
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        mFlPagerContent.addView(textView);
        mTvTitle.setText("title 2");
    }
}
