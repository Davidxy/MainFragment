package com.yan.mainfragment.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yan.mainfragment.R;
import com.yan.mainfragment.fragment.FragmentOne;
import com.yan.mainfragment.view.CustomViewPager;
import com.yan.mainfragment.view.ViewPagerIndicator;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/12.
 */
public class BaseActivity<T extends View> extends AppCompatActivity {
    protected CustomViewPager viewPager;
    protected ViewPagerIndicator<T> pagerIndicator;
    protected ArrayList<Fragment> fragList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniData();
        iniView();
    }

    /***
     * @return 初始化数据
     */
    private void iniData() {
        fragList.add(getFragment("第一"));
        fragList.add(getFragment("第二"));
        fragList.add(getFragment("第三"));
        fragList.add(getFragment("第四"));
        fragList.add(getFragment("第五"));
    }

    /***
     * 初始化Fragmnet
     *
     * @return
     */
    private Fragment getFragment(String text) {
        FragmentOne fraone = new FragmentOne();
        Bundle bundle = new Bundle();
        bundle.putString("args", text);
        fraone.setArguments(bundle);
        return fraone;
    }

    /***
     * @return 初始化视图
     */
    private void iniView() {
        viewPager = (CustomViewPager) findViewById(R.id.viewPager);
        pagerIndicator = (ViewPagerIndicator) findViewById(R.id.custome_vp);
        pagerIndicator.setViewPager(viewPager).setMarginTop(40).setIndicatorColor(Color.RED).setIndicatorWidth(10);
        setAdapter();
    }

    /***
     * @return 设置监听事件
     */
    private void setAdapter() {
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragList.get(position);
            }

            @Override
            public int getCount() {
                return fragList == null ? 0 : fragList.size();
            }
        });
    }
}
