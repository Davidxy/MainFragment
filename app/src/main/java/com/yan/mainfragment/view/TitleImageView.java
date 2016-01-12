package com.yan.mainfragment.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yan.mainfragment.R;

/**
 * Created by 洒笑天涯 on 2016/1/12.
 */
public class TitleImageView extends LinearLayout {
    /****
     * @return 需要文本, 需要图片, 在做或者右
     */
    private boolean needText, needImage, isRight;
    private ImageView imageView;
    private TextView textView;
    private int color;
    private String text;

    public TitleImageView(Context context) {
        super(context);
        iniView();

    }

    public TitleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getProperties(context, attrs);
        iniView();
    }


    private void getProperties(Context context, AttributeSet attrs) {
        TypedArray tp = context.obtainStyledAttributes(attrs, R.styleable.TitleImageView);
        int count = tp.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = tp.getIndex(i);
            switch (attr) {
                case R.styleable.TitleImageView_android_textColor:
                    color = tp.getColor(attr, Color.BLUE);
                    break;
                case R.styleable.TitleImageView_android_tint:
                    break;
                case R.styleable.TitleImageView_isRight:
                    isRight = tp.getBoolean(attr, false);
                    break;
                case R.styleable.TitleImageView_need_image:
                    needImage = tp.getBoolean(attr, false);
                    break;
                case R.styleable.TitleImageView_need_text:
                    needText = tp.getBoolean(attr, false);
                    break;
                case R.styleable.TitleImageView_android_text:
                    text = tp.getString(attr);
                    break;
            }
        }
        tp.recycle();
    }

    /***
     * @return 初始化控件
     */
    private void iniView() {
        this.setGravity(Gravity.CENTER);
        if (needImage) {
            imageView = new ImageView(getContext());
            LinearLayout.LayoutParams imgLp = new LinearLayout.LayoutParams(dip2px(20), dip2px(20));
            imageView.setLayoutParams(imgLp);
            imageView.setColorFilter(color);
            imageView.setImageResource(R.mipmap.ic_launcher);

        }
        if (needText) {
            LinearLayout.LayoutParams tvLp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            textView = new TextView(getContext());
            textView.setLayoutParams(tvLp);
            textView.setTextColor(color);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
            textView.setText(text);

        }
        if (isRight&&imageView!=null&&textView!=null) {
            this.addView(imageView);
            this.addView(textView);
            return;
        } else if(imageView!=null&&textView!=null){
            this.addView(textView);
            this.addView(imageView);
            return;
        }
        if (needImage){
            this.addView(imageView);
        }
        if (needText)this.addView(textView);

    }

    /***
     * @return 设置字体颜色和图片渲染颜色
     */
    public void setTextNTintColor(int color) {
        if (imageView != null) imageView.setColorFilter(color);
        if (textView != null) textView.setTextColor(color);
    }

    private int dip2px(int i) {
        return (int) (getContext().getResources().getDisplayMetrics().density * i + 0.5f);
    }

    public TitleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        iniView();
    }
}
