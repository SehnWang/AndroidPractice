package com.xhao.androidpractice.draw;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.xhao.androidpractice.R;

/**
 * Created by WongxHao on 2016/5/25 22:35
 */
public class MyView extends View {
    private Paint mPaint;

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setColor(ContextCompat.getColor(context, R.color.purple));//画笔颜色
        mPaint.setStyle(Paint.Style.FILL);//画笔风格
        mPaint.setTextSize(36);//绘制文字大小，单位px
        mPaint.setStrokeWidth(5);//画笔粗细

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(ContextCompat.getColor(getContext(), R.color.PaleGoldenRod));//设置画布颜色
        //绘制实心圆形
        canvas.drawCircle(150, 150, 100, mPaint);

        //绘制矩形
        canvas.drawRect(0, 300, 300, 450, mPaint);

        //绘制Bitmap
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher), 400, 50, mPaint);

        //绘制弧形区域
        //第三个参数：true的话，会连着圆心的范围一起绘制出来
        canvas.drawArc(new RectF(400, 400, 500, 500), 0, 90, true, mPaint);
        canvas.drawArc(new RectF(600, 50, 700, 150), 0, 90, false, mPaint);

        //绘制圆角矩形
        canvas.drawRoundRect(new RectF(600, 300, 800, 400), 15, 15, mPaint);

        //绘制椭圆
        canvas.drawOval(new RectF(0, 600, 200, 900), mPaint);
    }
}
