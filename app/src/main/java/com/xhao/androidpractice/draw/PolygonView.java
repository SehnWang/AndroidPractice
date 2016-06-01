package com.xhao.androidpractice.draw;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.xhao.androidpractice.R;

/**
 * Created by WongxHao on 2016/6/1 21:52
 */
public class PolygonView extends View {
    private Paint mPaint;
    public PolygonView(Context context) {
        this(context, null);
    }

    public PolygonView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PolygonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(ContextCompat.getColor(getContext(), R.color.purple));
        mPaint.setTextSize(36);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.LTGRAY);

        Path path = new Path();
        path.moveTo(10, 10);
        path.lineTo(100, 50);
        path.lineTo(200, 40);
        path.lineTo(300, 20);
        path.lineTo(200, 10);
        path.lineTo(100, 70);
        path.lineTo(50, 40);
        path.close();
        canvas.drawPath(path, mPaint);


    }
}
