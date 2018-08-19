package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者:  lbqiang on 2018/8/12 15:46
 * 邮箱:  anworkmail_q@126.com
 * 作用:  能自定义数据的饼图, 有待添加折线&描述文字
 */
public class PieChatView extends View {

    public static final int BLACK = 0xFF000000;
    public static final int DKGRAY = 0xFF444444;
    public static final int GRAY = 0xFF888888;
    public static final int LTGRAY = 0xFFCCCCCC;
    public static final int WHITE = 0xFFFFFFFF;
    public static final int RED = 0xFFFF0000;
    public static final int GREEN = 0xFF00FF00;
    public static final int BLUE = 0xFF0000FF;
    public static final int YELLOW = 0xFFFFFF00;
    public static final int CYAN = 0xFF00FFFF;
    public static final int MAGENTA = 0xFFFF00FF;
    public static final int TRANSPARENT = 0;

    private static final int[] COLOR_ARRAY = {RED, BLUE, YELLOW, GREEN, CYAN, MAGENTA, BLACK, DKGRAY, GRAY, LTGRAY, WHITE};


    private Map<String, Double> mData = Maps.newHashMap();
    private List<String> mStringList = Lists.newArrayList();
    private List<Double> mDataList = Lists.newArrayList();

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int pieRadius = 100; // 半径
    private boolean useCenter = true; // 默认实心
    private double sum = 0;

    public PieChatView(Context context) {
        this(context, null);
    }

    public PieChatView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieChatView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initPaint();
    }

    private void initPaint() {

    }

    private void dataReset() {
        mStringList.clear();
        mDataList.clear();
        sum = 0;
    }

    public void setData(Map<String, Double> dataMap) {
        dataReset();

        mData = dataMap;

        for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
            mStringList.add(entry.getKey());
            mDataList.add(entry.getValue());
            sum += entry.getValue();
        }

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float startAngle = 0;
        float sweepAngle = 0;
        int count = 0;

        //        Log.d("MyLog", "onDraw: sum  " + sum);

        for (Map.Entry<String, Double> entry : mData.entrySet()) {
            mPaint.setColor(COLOR_ARRAY[count % COLOR_ARRAY.length]);
            count++;

            //            Log.d("MyLog", "onDraw: entry.getValue()  " + entry.getValue());
            startAngle += sweepAngle;
            sweepAngle = (float) (entry.getValue() / sum * 360);
            //            Log.d("MyLog", "onDraw: sweepAngle  " + sweepAngle);
            //            Log.d("MyLog", "onDraw: startAngle  " + startAngle);

            canvas.drawArc(0, 0, pieRadius * 2, pieRadius * 2,
                    startAngle,
                    sweepAngle,
                    useCenter, mPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                if (getMeasuredWidth() < pieRadius * 2) {
                    widthSize = pieRadius * 2;
                }
                break;
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                widthSize = pieRadius * 2;
                break;
        }

        //        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthSize, widthSize);
    }
}
