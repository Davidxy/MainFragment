package com.yan.mainfragment.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yan.mainfragment.R;

/**
 * Created by 黄艳武 on 2016/1/12.
 */
public class CountTextView extends LinearLayout {

    private TextView tv_titles, tv_count;

    public CountTextView(Context context) {
        super(context);
    }

    public CountTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_count_textview, this);
        iniViews();
        getPropertites(context, attrs);

    }

    /***
     * @return 获取自定义属性
     */
    private void getPropertites(Context context, AttributeSet attrs) {
        TypedArray tp = context.obtainStyledAttributes(attrs, R.styleable.CountTextView);
        int color = tp.getColor(R.styleable.CountTextView_android_textColor, Color.BLUE);
        tv_titles.setTextColor(color);
        tp.recycle();
    }

    /***
     * @return 初始化控件
     */
    private void iniViews() {
        tv_titles = (TextView) findViewById(R.id.tv_names);
        tv_count = (TextView) findViewById(R.id.tv_count);
    }

    public CountTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /***
     * @return 设置主控件的字体颜色
     */
    public void setMainColor(int color) {
        tv_titles.setTextColor(color);
    }

    /***
     * @return 设置消息的数量
     */
    public void setMessageCount(String count) {
        tv_count.setText(count);
    }
}
