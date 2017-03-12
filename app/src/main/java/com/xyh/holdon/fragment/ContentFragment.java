package com.xyh.holdon.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.xyh.holdon.R;
import com.xyh.holdon.base.BasePager;
import com.xyh.holdon.base.impl.FirstPager;
import com.xyh.holdon.base.impl.SecondPager;
import com.xyh.holdon.base.impl.ThirdPager;

import java.util.ArrayList;

/**
 * Created by xyh on 2017/3/12.
 */

public class ContentFragment extends BaseFragment {
    private ViewPager mViewPager;
    private ArrayList<BasePager> mPagers;
    private RadioGroup mRadioGroup;

    @Override
    public void initData() {
        mPagers = new ArrayList<BasePager>();
        //添加标签页
        mPagers.add(new FirstPager(mActivity));
        mPagers.add(new SecondPager(mActivity));
        mPagers.add(new ThirdPager(mActivity));

        mViewPager.setAdapter(new ContentAdapter());

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbtn_home:
                        mViewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rbtn_news:
                        mViewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rbtn_scocial:
                        mViewPager.setCurrentItem(2, false);
                        break;
                    default:
                        break;
                }
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //当页面被选中 加载布局
            @Override
            public void onPageSelected(int position) {
                BasePager pager = mPagers.get(position);
                pager.initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_content);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.rg_tab);

        return view;
    }


    class ContentAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mPagers.get(position);
            View view = pager.mRootView;
            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
