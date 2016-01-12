package com.yan.mainfragment.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;

/****
 * Created by 黄艳武 on 2016/1/12.
 * Function:自定义Indicator;解决头部控件样式不同的时候,不能更改的问题;现在头部使用者可以自行diy;
 */
public class ViewPagerIndicator<T extends View> extends LinearLayout {
    /***
     * 滚动的ViewPager
     */
    private CustomViewPager viewPager;
    /***
     * 选上次择的位置
     */
    private int lastPosition;
    /***
     * 设置监听事件
     */
    private OnSelectListener<T> onSelectChangeViewListener;

    /***
     * 存放View 的集合
     */
    private ArrayList<T> viewList;

    private View mIndicator;
    /***
     * 子View的宽度
     */
    private int childWidth;
    /***
     * 设置页面可以看见的视图的大小
     */
    private int visibleCount;
    /**
     * 指示器的宽度,指示器的高度
     **/
    private int indicatorWidth, indicatorHeight;
    /****
     * 用户如果不设置mIndicatorView,需要手动绘制滚动条
     */
    private Paint mPaint;

    public ViewPagerIndicator(Context context) {
        super(context);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public ViewPagerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /***
     * @return 未设置进来的view设置属性
     */
    private void setLayoutParameters(ArrayList<T> viewList) {
        visibleCount = viewList.size();//现在这里默认的是设置可现实的控件

        for (int i = 0; i < viewList.size(); i++) {
            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, dip2px(50), 1.0f);
            layoutParams.gravity = Gravity.CENTER;
            T view = viewList.get(i);
            view.setLayoutParams(layoutParams);
            this.addView(view);
        }
        childWidth = getChildWidth();
    }

    /****
     * @return 设置头部的资源
     */
    public void setViewList(int layoutId) {
        ViewGroup parent = (ViewGroup) LayoutInflater.from(getContext()).inflate(layoutId, null);
        if (viewList == null) viewList = new ArrayList<>();
        for (int i = 0; i < parent.getChildCount(); i++) {
            viewList.add((T) parent.getChildAt(i));
        }
        parent.removeAllViews();//因为要直接将子类给这个自定义的ViewPagerIndicator
        setLayoutParameters(viewList);
        setOnClickListenerForChild(viewList);
    }

    /***
     * @return 装载视图
     */
    public void setViewList(ArrayList<T> viewList) {
        this.viewList = viewList;
        setLayoutParameters(viewList);
        setOnClickListenerForChild(this.viewList);
    }

    /***
     * @return 为每个view设置监听事件;哪个view被点击,就设置当前页为那一页
     */
    private void setOnClickListenerForChild(ArrayList<T> viewList) {
        for (int i = 0; i < viewList.size(); i++) {
            final int finalI = i;
            viewList.get(i).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(finalI);
                }
            });
        }
    }


    /****
     * @return 设置改变视图的监听器
     */
    public void setOnSelectChangeViewListener(OnSelectListener<T> onSelectChangeViewListener) {
        this.onSelectChangeViewListener = onSelectChangeViewListener;
    }

    /***
     * 顶部的指示器
     *
     * @return
     */
    public void setIndicator(View mIndicatorView) {
        this.mIndicator = mIndicatorView;
        indicatorWidth = mIndicator.getWidth();
        indicatorHeight = mIndicator.getHeight();
        this.addView(mIndicator);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    /****
     * @return 设置选择的监听事件
     */
    private void setPagerSelectListener() {
        if (viewPager == null) throw new NullPointerException("请为ViewPagerIndicator设置ViewPager");
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /****
             * 这个是比例,positionOffset;一个是移动屏幕的距离positionOffsetPixels
             * */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //在这里控制指示器的移动
                //if (mIndicator == null) return;
                //Log.v("mine", positionOffset + ":positionOffSet::positionOffsetPixels" + positionOffsetPixels + "getScreenWidth:" + getChildWidth());
                //childWidth的大小,也就是两个child之间的间距
                //onLayout(0,);
                int scolleWidth = (int) (childWidth * positionOffset);
                mIndicator.layout(dip2px(30), childWidth - indicatorWidth, dip2px(30) + childWidth, scolleWidth + childWidth * position);
                Log.v("mine", dip2px(30) + ":" + (childWidth - indicatorWidth) + ":" + (dip2px(30) + childWidth) + ":" + (scolleWidth + childWidth * position));
            }

            @Override
            public void onPageSelected(int position) {
                setSelected(position, lastPosition);
                lastPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /***
     * @return 得到视图中子类view的大小
     */
    private int getChildWidth() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return (point.x - getPaddingRight() - getPaddingLeft()) / visibleCount;
    }

    /****
     * @return 设置选中的view
     */
    private void setSelected(int position, int lastPosition) {
        if (onSelectChangeViewListener != null) {
            onSelectChangeViewListener.onSelected(position, viewList.get(position), viewList.get(lastPosition));
        }
    }

    /****
     * @return 返回数据和当前位置 用来改变视图的监听器
     */
    public interface OnSelectListener<T extends View> {
        public void onSelected(int position, T slectedView, T lastSelected);
    }

    /***
     * @return 将ViewPager设置进来
     */
    public void setViewPager(CustomViewPager viewPager) {
        this.viewPager = viewPager;
        setPagerSelectListener();
    }

    /***
     * @return height
     */
    private int dip2px(int height) {
        return (int) (getContext().getResources().getDisplayMetrics().density * height + 0.5f);
    }
}
