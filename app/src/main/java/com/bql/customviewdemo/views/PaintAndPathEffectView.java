package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:  lbqiang on 2018/8/23 23:37
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */
public class PaintAndPathEffectView extends View {
    private float startX = 50;
    private float startY = 50;

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    private PathEffect mDashPathEffect = new DashPathEffect(new float[]{10, 5}, 10);
    private PathEffect mCornerPathEffect = new CornerPathEffect(20);
    private PathEffect mDiscretePathEffect = new DiscretePathEffect(20, 5);
//    private PathEffect mPathDashPathEffect = new PathDashPathEffect();

    public PaintAndPathEffectView(Context context) {
        this(context, null);
    }

    public PaintAndPathEffectView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintAndPathEffectView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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


        // PathEffect
        mPaint.setStyle(Paint.Style.STROKE);
        //        mPaint.setPathEffect(mDashPathEffect);
        //        canvas.drawCircle(150, 150, 100, mPaint);


        // 画一段path
        drawLines(startX, startY);
        mPaint.setPathEffect(null);
        canvas.drawPath(mPath, mPaint);

        // 拐角变圆角
        mPath = new Path();
        drawLines(startX, startY + 150);
        mPaint.setPathEffect(mCornerPathEffect);
        canvas.drawPath(mPath, mPaint);

        // 分离偏离
        mPath = new Path();
        drawLines(startX, startY + 300);
        mPaint.setPathEffect(mDiscretePathEffect);
        canvas.drawPath(mPath, mPaint);

        // 虚线
        mPath = new Path();
        drawLines(startX, startY + 450);
        mPaint.setPathEffect(mDashPathEffect);
        canvas.drawPath(mPath, mPaint);


    }

    private void drawLines(float startX, float startY) {
        mPath.moveTo(startX, startY);
        mPath.rLineTo(50, 100);
        mPath.rLineTo(70, -100);
        mPath.rLineTo(40, 120);
        mPath.rLineTo(60, -70);
        mPath.rLineTo(50, 110);
    }
}
