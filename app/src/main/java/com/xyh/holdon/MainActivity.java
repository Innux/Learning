package com.xyh.holdon;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.xyh.holdon.fragment.ContentFragment;
import com.xyh.holdon.fragment.LeftMenuFragment;

/**
 * Created by xyh on 2017/3/10.
 */

public class MainActivity extends AppCompatActivity{

    private DrawerLayout mDlMain;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        mDlMain = (DrawerLayout) findViewById(R.id.dl_main);

        initFragment();

    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_left_menu, new LeftMenuFragment());
        fragmentTransaction.replace(R.id.fl_main_content, new ContentFragment());
        fragmentTransaction.commit();

    }

    //Toolbar点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDlMain.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }

}
