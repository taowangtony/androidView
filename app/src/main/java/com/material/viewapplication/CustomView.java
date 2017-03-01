package com.material.viewapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wangtao on 2017/2/8.
 */

public class CustomView extends View {
    private static final float STROKE_WIDTH = 1F / 256F, // 描边宽度占比
            LINE_LENGTH = 3F / 32F, // 线段长度占比
            CRICLE_LARGER_RADIU = 3F / 32F,// 大圆半径
            CRICLE_SMALL_RADIU = 5F / 64F,// 小圆半径
            ARC_RADIU = 1F / 8F,// 弧半径
            ARC_TEXT_RADIU = 5F / 32F,// 弧围绕文字半径
            SPACE = 3F / 128F;
    private Paint mPaint,mArcPaint,mBsrPaint,paint;
    private Path mPath;
    private TextPaint mTextPaint;
    private float strokeWidth;
    private float cx, cy;
    private float largeCircleRadiu; //大圆半径
    private float littleCircleRadiu;
    private float lineLength;
    private float space;
    private int size;
    private float textOffsetY;// 文本的Y轴偏移值
    private PorterDuffXfermode porterDuffXfermode;// Xfermode
    private Bitmap mBitmap;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0x55EC6941);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(20);

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setColor(0x55EC6941);
        textOffsetY = (mTextPaint.ascent() + mTextPaint.descent())/2;
//
//        mBsrPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mBsrPaint.setColor(0x55EC6941);
//        mPath = new Path();
//        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
//        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.logo);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        size = w;
        calculation(h);
    }

    private void calculation(int h) {
        strokeWidth = size * STROKE_WIDTH;

        lineLength = size * LINE_LENGTH;
        littleCircleRadiu = size * CRICLE_SMALL_RADIU;
        largeCircleRadiu = size * CRICLE_LARGER_RADIU;
        space = size * SPACE;
        cx = size / 2;
        cy = h / 2 + largeCircleRadiu;
        setPara();
    }

    private void setPara() {
        mPaint.setStrokeWidth(strokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0xFFF29B76);

        //draw 贝塞尔
//        mPath.moveTo(size-130,140);
//        mPath.cubicTo(size-120,110,size-80,140,size-50,100);
//        mPath.lineTo(size,150);
//        mPath.lineTo(size-400,150);
//        canvas.drawBitmap(mBitmap,size-200,100,paint);
//        paint.setXfermode(porterDuffXfermode);
//        canvas.drawPath(mPath,paint);
//        paint.setXfermode(null);

        canvas.drawCircle(cx, cy, largeCircleRadiu, mPaint);
        canvas.drawText("Luanguge",cx,cy-textOffsetY,mTextPaint);
        drawLeftTop(canvas);
        drawRightTop(canvas);
        drawLeftBottom(canvas);
        drawBottom(canvas);
        drawRightBottom(canvas);
    }

    private void drawLeftTop(Canvas canvas) {
        canvas.save();//锁定画布
        canvas.translate(cx, cy);
        canvas.rotate(-30);

        canvas.drawLine(0, -largeCircleRadiu, 0, -(lineLength + largeCircleRadiu), mPaint);
        canvas.drawCircle(0, -(lineLength + 2 * largeCircleRadiu), largeCircleRadiu, mPaint);

        canvas.save();
        canvas.translate(0, -(lineLength + 2 * largeCircleRadiu));
        canvas.rotate(30);
        canvas.drawText("Java",0,-textOffsetY,mTextPaint);
        canvas.restore();
        canvas.drawLine(0, -(lineLength + 3 * largeCircleRadiu), 0, -(2 * lineLength + 3 * largeCircleRadiu), mPaint);
        canvas.drawCircle(0, -2 * (lineLength + 2 * largeCircleRadiu), largeCircleRadiu, mPaint);
        canvas.save();
        canvas.translate(0, -2 * (lineLength + 2 * largeCircleRadiu));
        canvas.rotate(30);
        canvas.drawText("Android",0,-textOffsetY,mTextPaint);
        canvas.restore();
        // 释放画布
        canvas.restore();
    }

    private void drawRightTop(Canvas canvas) {
        canvas.save();
        canvas.translate(cx, cy);
        canvas.rotate(30);

        canvas.drawLine(0, -largeCircleRadiu, 0, -(lineLength + largeCircleRadiu), mPaint);
        canvas.drawCircle(0, -(lineLength + 2 * largeCircleRadiu), largeCircleRadiu, mPaint);

        canvas.save();
        canvas.translate(0, -(lineLength + 2 * largeCircleRadiu));
        canvas.rotate(-30);
        canvas.drawText("IOS",0,-textOffsetY,mTextPaint);
        canvas.restore();
        drawH(canvas,-(lineLength + 2 * largeCircleRadiu));
        canvas.restore();

    }

    private void drawH(Canvas canvas,float cy2) {
        canvas.save();
        canvas.translate(0,cy2);
        float arcRadiu = size * ARC_RADIU;
        RectF rectF = new RectF(-arcRadiu,-arcRadiu,arcRadiu,arcRadiu);
        canvas.drawArc(rectF,-155F,130,true,mArcPaint);
        mArcPaint.setStrokeWidth(strokeWidth);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setColor(Color.WHITE);
        canvas.drawArc(rectF,-155F,130,false,mArcPaint);

        float arcTextRadiu = size*ARC_TEXT_RADIU;
        canvas.save();
        canvas.rotate(-65);
        for(float i = 0;i<=130;i+=32.5F){
            canvas.save();
            canvas.rotate(i);
            canvas.drawText("Mc",0,-arcTextRadiu,mTextPaint);
            canvas.restore();
        }

        canvas.restore();
        canvas.restore();
    }

    private void drawLeftBottom(Canvas canvas) {
        canvas.save();
        canvas.translate(cx, cy);
        canvas.rotate(-100);

        canvas.drawLine(0, -largeCircleRadiu - space, 0, -(lineLength + largeCircleRadiu + space), mPaint);
        canvas.drawCircle(0, -(lineLength + littleCircleRadiu + largeCircleRadiu + 2*space), littleCircleRadiu, mPaint);

        canvas.save();
        canvas.translate(0, -(lineLength + littleCircleRadiu + largeCircleRadiu + 2*space));
        canvas.rotate(100);
        canvas.drawText("JavaScript",0,-textOffsetY,mTextPaint);
        canvas.restore();
        canvas.restore();
    }

    private void drawBottom(Canvas canvas) {

        canvas.save();
        canvas.translate(cx, cy);
        canvas.rotate(180);

        canvas.drawLine(0, -largeCircleRadiu - space, 0, -(lineLength + largeCircleRadiu + space), mPaint);
        canvas.drawCircle(0, -(lineLength + littleCircleRadiu + largeCircleRadiu + 2*space), littleCircleRadiu, mPaint);

        canvas.save();
        canvas.rotate(-180);
        canvas.drawText("Swift",0,lineLength + littleCircleRadiu + largeCircleRadiu + 2*space - textOffsetY,mTextPaint);
        canvas.restore();
        canvas.restore();
    }

    private void drawRightBottom(Canvas canvas) {
        canvas.save();
        canvas.translate(cx, cy);
        canvas.rotate(100);

        canvas.drawLine(0, -largeCircleRadiu - space, 0, -(lineLength + largeCircleRadiu + space), mPaint);
        canvas.drawCircle(0, -(lineLength + littleCircleRadiu + largeCircleRadiu + 2*space), littleCircleRadiu, mPaint);
        canvas.save();
        canvas.translate(0, -(lineLength + littleCircleRadiu + largeCircleRadiu + 2*space));
        canvas.rotate(-100);
        canvas.drawText("PHP",0,-textOffsetY,mTextPaint);
        canvas.restore();
        canvas.restore();
    }
}
