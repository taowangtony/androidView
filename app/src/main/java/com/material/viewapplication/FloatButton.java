package com.material.viewapplication;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by wangtao on 2017/3/1.
 */

public class FloatButton extends Button {
    private float oldX, oldY;

    public FloatButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                oldX = event.getRawX();
                oldY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = event.getRawX() - oldX;
                float dy = event.getRawY() -oldY;

                int l = (int) (getLeft() + dx);
                int t = (int) (getTop() + dy);
                int r = (int) (getRight() +dx);
                int b = (int) (getBottom() + dy);

                this.layout(l,t,r,b);
                oldX = event.getRawX();
                oldY = event.getRawY();
                postInvalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }
}
