package com.xyh.holdon.base;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.xyh.holdon.R;

/**
 * Created by xyh on 2017/3/12.
 */

public class BasePager {

    public Activity mActivity;
    public TextView mTvTitle;
    public FrameLayout mFlPagerContent;//动态添加布局
    public View mRootView;//当前页面的布局对象


    public BasePager(Activity activity) {
        mActivity = activity;
        mRootView = initView();
    }

    public View initView() {
        View view = View.inflate(mActivity, R.layout.base_pager, null);
        mTvTitle = (TextView) view.findViewById(R.id.tv_head_title);
        mFlPagerContent = (FrameLayout) view.findViewById(R.id.fl_pager_content);

        //TODO 初始化toolbar  可能要放在baseviewpager中
        Toolbar tbMain = (Toolbar) view.findViewById(R.id.tb_main);
        tbMain.setTitle("");
        ((AppCompatActivity) mActivity).setSupportActionBar(tbMain);

        ActionBar actionBar = ((AppCompatActivity) mActivity).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_reorder_white_48dp);
        }

        return view;
    }

    public void initData() {

    }


}
