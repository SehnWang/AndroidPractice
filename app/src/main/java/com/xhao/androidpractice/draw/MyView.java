package com.xhao.androidpractice.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
        mPaint.setColor(Color.GREEN);//画笔颜色
        mPaint.setStyle(Paint.Style.STROKE);//画笔风格
        mPaint.setTextSize(100);//绘制文字大小，单位px
        mPaint.setStrokeWidth(2);//画笔粗细

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(ContextCompat.getColor(getContext(), R.color.yellow));//设置画布颜色
        canvas.drawCircle(150, 150, 100, mPaint);
    }
}
