package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
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
    private PathEffect mPathDashPathEffect;
    private PathEffect mSumPathEffect = new SumPathEffect(mCornerPathEffect, mDiscretePathEffect);
    private PathEffect mComposePathEffect = new ComposePathEffect(mCornerPathEffect, mDiscretePathEffect);

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

        // 用Path来画虚线
        mPath = new Path();
        Path path = new Path();
        path.addCircle(0, 0, 10, Path.Direction.CW);
        mPathDashPathEffect = new PathDashPathEffect(path, 40, 0, PathDashPathEffect.Style.TRANSLATE);
        drawLines(startX, startY + 600);
        mPaint.setPathEffect(mPathDashPathEffect);
        canvas.drawPath(mPath, mPaint);

        // 画2条
        mPath = new Path();
        drawLines(startX, startY + 750);
        mPaint.setPathEffect(mSumPathEffect);
        canvas.drawPath(mPath, mPaint);

        // 混合效果
        mPath = new Path();
        drawLines(startX, startY + 900);
        mPaint.setPathEffect(mComposePathEffect);
        canvas.drawPath(mPath, mPaint);


        // 添加阴影，绘制在底层
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(40);
        mPaint.setShadowLayer(10, 5, 5, Color.RED);
        canvas.drawText("Hello World", 50, 1100, mPaint);

        // BlurMaskFilter 模糊效果，绘制在上层
        // EmbossMaskFilter 浮雕效果
        //        mPaint.setMaskFilter()
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
