package com.jinsen.xutils30.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * Created by jinsen-a on 2016/2/15.
 */
public class CusListview extends ListView {

    private int mMaxOverScrollY = 200;

    public CusListview(Context context) {
        this(context,null);
    }

    public CusListview(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CusListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float d = dm.density;
        mMaxOverScrollY = (int) (d * mMaxOverScrollY);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverScrollY, isTouchEvent);
    }
}
