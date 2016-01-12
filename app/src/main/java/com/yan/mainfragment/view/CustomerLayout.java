package com.yan.mainfragment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by 黄艳武 on 2016/1/12.
 * Function:
 */
public class CustomerLayout extends LinearLayout {

    public CustomerLayout(Context context) {
        super(context);
    }

    public CustomerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        for (int i=0;i<getChildCount();i++){
            View view=getChildAt(i);
            view.layout(100,100,300,300);
        }
    }
}
