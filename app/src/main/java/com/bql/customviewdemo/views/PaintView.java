package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:  lbqiang on 2018/8/23 23:37
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */
public class PaintView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private PathEffect mPathEffect;

    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mPathEffect = new DashPathEffect(new float[]{10, 5}, 10);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        // paint 的两个色彩优化函数
        // 抖动
        //        mPaint.setDither(true);
        // 双线性过滤优化bitmap的方法绘制
        //        mPaint.setFilterBitmap(true);

        // 设置拐角
        //        mPaint.setStrokeJoin();
        // 设置拐角延长补充
        //        mPaint.setStrokeMiter();


        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setPathEffect(mPathEffect);
        canvas.drawCircle(300, 300, 200, mPaint);
    }
}
