package com.material.viewapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by wangtao on 2017/2/15.
 */

public class WXView extends ViewGroup {
//    private int number;//item 数量
    private int place;//位置
    private float radius;//半径
    private float centerRadius;// 中心圆半径
    private float itemRadius;//小圆半径
    private float circular;//弧度
    private Drawable centerDrawable;//中心圆drawable
    private ImageView centerImg;

    private final int CENTER = 0;
    private final int TOP_LEFT = 1;
    private final int TOP_RIGHT = 2;
    private final int BOTTOM_LEFT = 3;
    private final int BOTTOM_RIGHT = 4;

    public WXView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.WXMenu);
//        number = array.getInt(R.styleable.WXMenu_number, 4);
        radius = array.getFloat(R.styleable.WXMenu_radius, 200f);
        centerRadius = array.getFloat(R.styleable.WXMenu_centerRadius, 0.0f);
        itemRadius = array.getFloat(R.styleable.WXMenu_itemRadius, 0.0f);
        circular = array.getFloat(R.styleable.WXMenu_circular, 90f);
        centerDrawable = array.getDrawable(R.styleable.WXMenu_centerDrawable);
        place = array.getInt(R.styleable.WXMenu_menu_location, CENTER);
        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        layoutCenter(getChildAt(0));
        int count = getChildCount();
        ImageView childView;
        for (int i = 0; i < count-1 ; i++) {
            childView = (ImageView) getChildAt(i+1);
            childView.setImageDrawable(centerDrawable);
            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();
            childView.layout((int) radius, (int) itemRadius, (int) (radius+childWidth), (int) (itemRadius+childHeight));
        }
    }

    private void layoutCenter(View childAt) {
        centerImg = (ImageView) childAt;
        centerImg.setImageDrawable(centerDrawable);

        int logoWidth = centerImg.getMeasuredWidth();
        int logoHeight = centerImg.getMeasuredHeight();

        if (TOP_LEFT == place) {
            centerImg.layout(0,0,logoWidth,logoHeight);
        }
        if (TOP_RIGHT == place) {
        }
        if (CENTER == place) {
            centerImg.layout(0,0,logoWidth,logoHeight);
        }
        if (BOTTOM_LEFT == place) {
        }
        if (BOTTOM_RIGHT == place) {
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
