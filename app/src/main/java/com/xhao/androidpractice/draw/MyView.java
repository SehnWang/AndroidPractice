package com.xhao.androidpractice.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.xhao.androidpractice.R;

/**
 * Created by WongxHao on 2016/5/25 22:35
 */
public class MyView extends View {
    private Paint mPaint;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setColor(getResources().getColor(R.color.purple));//画笔颜色
        mPaint.setStyle(Paint.Style.FILL);//画笔风格
        mPaint.setTextSize(36);//绘制文字大小，单位px
        mPaint.setStrokeWidth(5);//画笔粗细

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.yellow));//设置画布颜色
        canvas.drawCircle(200, 200, 100, mPaint);
    }
}
