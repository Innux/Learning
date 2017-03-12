package com.xyh.holdon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.xyh.holdon.utils.SharedPreUtil;

import java.util.ArrayList;

/**
 * Created by xyh on 2017/3/10.
 */

public class GuideAvtivity extends AppCompatActivity {

    private Context mContext;

    private ViewPager mViewPager;

    private int[] mImageIds = new int[]{R.drawable.guide_3, R.drawable.guide_2, R.drawable.guide_1};

    private ArrayList<ImageView> mList;
    private LinearLayout mLlContainer;
    private ImageView mIvRedPoint;
    private Button mBtnStart;

    private int mPointDis;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        mContext = this;

        mViewPager = (ViewPager) findViewById(R.id.vp_guide);
        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);
        mIvRedPoint = (ImageView) findViewById(R.id.iv_red_point);
        mBtnStart = (Button) findViewById( R.id.btn_start);

        initData();

        mViewPager.setAdapter(new GuideAdapter());

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int leftMargin = (int) (mPointDis * positionOffset + mPointDis * position);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mIvRedPoint.getLayoutParams();
                params.leftMargin = leftMargin;
                mIvRedPoint.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {
                //页面被选中
                if (position == mList.size() - 1) {
                    mBtnStart.setVisibility(View.VISIBLE);
                } else {
                    mBtnStart.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //页面状态发生回调
            }
        });

        mIvRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        //移除监听
                        mIvRedPoint.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        mPointDis = mLlContainer.getChildAt(1).getLeft() - mLlContainer.getChildAt(0).getLeft();
                    }
                }
        );

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreUtil.setBoolean(mContext, "is_first_enter", false);
                startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }
        });

    }

    private void initData() {
        mList = new ArrayList<ImageView>();

        for (int i = 0; i < mImageIds.length; i++) {
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImageIds[i]);
            mList.add(view);

            ImageView point = new ImageView(this);
            point.setImageResource(R.drawable.shape_point_white);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            if (i > 0) {
                params.leftMargin = 10;
            }
            point.setLayoutParams(params);
            mLlContainer.addView(point);
        }

    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView view = mList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
