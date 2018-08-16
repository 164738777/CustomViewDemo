package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者:  lbqiang on 2018/8/12 15:46
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */
public class PieChatView extends View {

    private Map<String, Double> mData = new HashMap<>();
    private List<String> mStringList = new ArrayList<>();
    private List<Double> mDataList = new ArrayList<>();

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int pieRadius = 100; // 半径
    private boolean useCenter = true; // 默认实心

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

    public void setData(Map<String, Double> dataMap) {
        for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
            mStringList.add(entry.getKey());
            mDataList.add(entry.getValue());
        }

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int startAngle = 0;

        for (Map.Entry<String, Double> entry : mData.entrySet()) {
            entry.getValue()
        }

        canvas.drawArc(0, 0, pieRadius * 2, pieRadius * 2,
                0,
                0,
                useCenter, mPaint);
    }
}
