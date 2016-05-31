package com.xhao.androidpractice.customview.test.fontmetrics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 显示测量文字宽高的练习
 * Created by WongxHao on 2016/5/31 23:09
 */
public class FontMetricsView extends View {
    private Paint mPaint;

    public FontMetricsView(Context context) {
        this(context, null);
    }

    public FontMetricsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontMetricsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(110);
        mPaint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //FontMetrics对象
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        String showText = "abcdefghijklmnopqrstuvwxyz";

        //计算每一个坐标
        float baseX = 0;
        float baseY = 200;
        float topY = baseY + fontMetrics.top;
        float ascentY = baseY + fontMetrics.ascent;
        float descentY = baseY + fontMetrics.descent;
        float bottomY = baseY + fontMetrics.bottom;
        float leading = baseY + fontMetrics.leading;

        Log.d("FontMetrics", "baseX is : " + baseX);
        Log.d("FontMetrics", "baseY is : " + baseY);
        Log.d("FontMetrics", "topY  is : " + topY + " - fontMetrics.top : " + fontMetrics.top);
        Log.d("FontMetrics", "ascentY is : " + ascentY + " - fontMetrics.ascent : " + fontMetrics.ascent);
        Log.d("FontMetrics", "descentY is : " + descentY + " - fontMetrics.descent : " + fontMetrics.descent);
        Log.d("FontMetrics", "bottomY is : " + bottomY + " - fontMetrics.bottom : " + fontMetrics.bottom);
        Log.d("FontMetrics", "leading is : " + leading + " - fontMetrics.leading : " + fontMetrics.leading);
        canvas.drawColor(Color.BLACK);
        //绘制文本
        canvas.drawText(showText, baseX, baseY, mPaint);

        //BaseLine
        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.RED);

        canvas.drawLine(0, baseY, canvas.getWidth(), baseY, linePaint);

        canvas.drawCircle(baseX, baseY, 5, linePaint);

        //TopLine
        linePaint.setColor(Color.LTGRAY);
        canvas.drawLine(0, topY, canvas.getWidth(), topY, linePaint);

        //AscentLine
        linePaint.setColor(Color.GREEN);
        canvas.drawLine(0, ascentY, canvas.getWidth(), ascentY, linePaint);

        //DescentLine
        linePaint.setColor(Color.YELLOW);
        canvas.drawLine(0, descentY, canvas.getWidth(), descentY, linePaint);

        //BottomLine
        linePaint.setColor(Color.MAGENTA);
        canvas.drawLine(0, bottomY, canvas.getWidth(), bottomY, linePaint);
    }
}
