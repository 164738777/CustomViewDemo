package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 作者:  lbqiang on 2018/8/18 18:29
 * 邮箱:  anworkmail_q@126.com
 * 作用:  假数据的直方图
 */
public class HistogramView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    private Map<String, Integer> mData = Maps.newHashMap();


    public HistogramView(Context context) {
        this(context, null);
    }

    public HistogramView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HistogramView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initData();
    }

    private void initData() {
        mData.put("1", 1);
        mData.put("2", 2);
        mData.put("3", 3);
        mData.put("4", 4);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.BLACK);
        // 不能为Fill , 否则会封闭
        mPaint.setStyle(Paint.Style.STROKE);

        mPath.moveTo(50, 50); // 起点往右下角移动 50，50
        mPath.lineTo(50, 250); // 从(0,0) 画线到 (50, 250)
        mPath.lineTo(500, 250); // 从(0,0) 画线到 (500, 250)

        // 效果一样
        //        mPath.moveTo(50, 50); // 起点往右下角移动 50，50
        //        mPath.rLineTo(0, 200); // 从(50,50) 为原点画线到 (0, 200)
        //        mPath.rLineTo(500, 0); // 以上个直接的末端坐标为原点画线到 (500, 0)
        canvas.drawPath(mPath, mPaint);


        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(100, 200, 150, 250, mPaint);
        canvas.drawRect(200, 150, 250, 250, mPaint);
        canvas.drawRect(300, 100, 350, 250, mPaint);
        canvas.drawRect(400, 50, 450, 250, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(30);
        canvas.drawText("1", (float) (100+ (150 - 100) * 1.0 / 2), 280, mPaint);
        canvas.drawText("2", (float) (200+ (250 - 200) * 1.0 / 2), 280, mPaint);
        canvas.drawText("3", (float) (300+ (350 - 300) * 1.0 / 2), 280, mPaint);
        canvas.drawText("4", (float) (400+ (450 - 400) * 1.0 / 2), 280, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        switch (widthMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                widthSize = 50 + 500 + 50;
                break;
            case MeasureSpec.EXACTLY:
                if (widthSize > 50 + 500 + 50) {
                    widthSize = 50 + 500 + 50;
                }
                break;
        }

        switch (heightMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                if (heightSize > 50 + 250 + 50) {
                    heightSize = 50 + 250 + 50;
                }
                break;
            case MeasureSpec.EXACTLY:
                if (heightSize > 50 + 250 + 50) {
                    heightSize = 50 + 250 + 50;
                }
                break;
        }

        setMeasuredDimension(widthSize, heightSize);
    }
}
