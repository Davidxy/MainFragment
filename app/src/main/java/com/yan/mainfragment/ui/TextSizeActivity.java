package com.yan.mainfragment.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

import com.yan.mainfragment.R;
import com.yan.mainfragment.view.ViewPagerIndicator;

public class TextSizeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pagerIndicator.setViewList(R.layout.header_textsize).setOnSelectChangeViewListener(new ViewPagerIndicator.OnSelectListener<TextView>() {
            @Override
            public void onSelected(int position, TextView slectedView, TextView lastSelected) {
                slectedView.setTextColor(Color.RED);
                slectedView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                lastSelected.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
                lastSelected.setTextColor(Color.GRAY);
            }
        });
    }
}
