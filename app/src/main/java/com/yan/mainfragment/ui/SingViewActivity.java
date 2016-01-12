package com.yan.mainfragment.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.yan.mainfragment.R;
import com.yan.mainfragment.view.ViewPagerIndicator;

/***
 * @return 当使用的是同一种View的时候, 这里可以直接塞进同一种VIew, 像这里, 塞进去的是TextView, 如果不是同一种的话, 塞进VIew, 也就是泛型解决
 */
public class SingViewActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pagerIndicator.setViewList(R.layout.header).setOnSelectChangeViewListener(new ViewPagerIndicator.OnSelectListener<TextView>() {
            @Override
            public void onSelected(int position, TextView slectedView, TextView lastSelected) {
                slectedView.setTextColor(Color.RED);
                lastSelected.setTextColor(Color.GRAY);
            }
        });
    }
}
