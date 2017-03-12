package com.xyh.holdon.base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.xyh.holdon.Api;
import com.xyh.holdon.base.BasePager;
import com.xyh.holdon.bean.TypeBean;

import java.io.IOException;

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

        getDataFromServer();
    }

    //从服务器获取数据
    private void getDataFromServer() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(Api.TIANGOU_CLASSIFY)
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Toast.makeText(mActivity, "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String str = response.body().string();
                System.out.println("服务器返回结果" + str);

                //解析数据
                processData(str);
            }
        });
    }

    //解析数据
    protected void processData(String json) {
        Gson gson = new Gson();
        TypeBean data = gson.fromJson(json, TypeBean.class);
        System.out.println("解析结果:" + data);

    }
}
