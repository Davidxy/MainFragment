package com.yan.mainfragment.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yan.mainfragment.R;
import com.yan.mainfragment.view.ViewPagerIndicator;

/***
 * @return 当使用的是同一种View的时候, 这里可以直接塞进同一种VIew, 像这里, 塞进去的是TextView, 如果不是同一种的话, 塞进VIew, 也就是泛型解决
 */
public class VariousViewActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pagerIndicator.setViewList(R.layout.header_various);
        pagerIndicator.setOnSelectChangeViewListener(new ViewPagerIndicator.OnSelectListener<View>() {
            @Override
            public void onSelected(int position, View slectedView, View lastSelected) {
                setTextColor(slectedView, true);
                setTextColor(lastSelected, false);
            }
        });
    }

    /***
     * @return 如果需要包含其他控件的话
     */
    private void setTextColor(View view, boolean isSelcted) {
        int color = Color.RED;
        if (!isSelcted) {
            color = Color.GRAY;
        }
        if (view instanceof TextView) {
            TextView sView = (TextView) view;
            sView.setTextColor(color);
        } else {
            LinearLayout slView = (LinearLayout) view;
            TextView textView = (TextView) slView.getChildAt(1);
            textView.setTextColor(color);
            ImageView imageView = (ImageView) slView.getChildAt(0);
            imageView.setColorFilter(color);
        }
    }
}
