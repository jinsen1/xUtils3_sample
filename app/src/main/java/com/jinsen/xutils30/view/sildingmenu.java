package com.jinsen.xutils30.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;
import android.widget.Scroller;

/**
 * Created by jinsen-a on 2015/12/11.
 */
public class sildingmenu extends HorizontalScrollView implements GestureDetector.OnGestureListener{


    private GestureDetector mGestureDetector;
    private Scroller mScroller;

    public sildingmenu(Context context) {
        super(context);
    }

    public sildingmenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public sildingmenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview();
    }

    private void initview() {

        /**
         * 默认是8dp
         */
        int slop = ViewConfiguration.get(getContext()).getScaledTouchSlop();

        mGestureDetector = new GestureDetector(this);
        mGestureDetector.setIsLongpressEnabled(false);

        ObjectAnimator.ofArgb(this,"",0,100).setDuration(100).start();

        mScroller = new Scroller(getContext());
        mScroller.startScroll(0, getScrollY(), 0, 100, 1000);
        invalidate();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec),getDefaultSize(getSuggestedMinimumHeight(),heightMeasureSpec));
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        // 引用速度追踪
        VelocityTracker velocityTracker = VelocityTracker.obtain();
        velocityTracker.addMovement(ev);

       // 获取 1000ms 手指活动的速度
        velocityTracker.computeCurrentVelocity(1000);
        int x = (int) velocityTracker.getXVelocity();
        int y = (int) velocityTracker.getYVelocity();

        // 不需要时 需要回收
        velocityTracker.clear();;
        velocityTracker.recycle();;

        return  mGestureDetector.onTouchEvent(ev);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        //  手指轻轻触摸屏幕的一瞬间，由一个action_down 触发
        return false;
    }
    @Override
    public void onShowPress(MotionEvent e) {
//       触摸屏幕手指未松开 或拖动 是 由一个 action_down 触发
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

//        手指触摸后松开，伴随1个 action—up 触发
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        拖动行为
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
//   长按
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

//         快速滑动行为
        return false;
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

}
