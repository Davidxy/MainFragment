package com.yan.mainfragment.ui;

import android.graphics.Color;
import android.os.Bundle;

import com.yan.mainfragment.R;
import com.yan.mainfragment.view.TitleImageView;
import com.yan.mainfragment.view.ViewPagerIndicator;

public class WhatYourLoveActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pagerIndicator.setViewList(R.layout.header_what_you_love);
        pagerIndicator.setOnSelectChangeViewListener(new ViewPagerIndicator.OnSelectListener<TitleImageView>() {
            @Override
            public void onSelected(int position, TitleImageView slectedView, TitleImageView lastSelected) {
             slectedView.setTextNTintColor(Color.RED);
                lastSelected.setTextNTintColor(Color.GRAY);
            }
        });
    }
}
