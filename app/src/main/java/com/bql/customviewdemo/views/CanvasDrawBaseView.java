package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bql.customviewdemo.R;

/**
 * 作者:  lbqiang on 2018/8/11 14:32
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */
public class CanvasDrawBaseView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CanvasDrawBaseView(Context context) {
        this(context, null);
    }

    public CanvasDrawBaseView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasDrawBaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }

    private void initPaint() {
        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 圆形
        //        canvas.drawColor(Color.BLUE); // 整个canvas都上色, 注意draw的顺序
        canvas.drawCircle(300, 300, 200, mPaint);
        //        canvas.drawColor(Color.parseColor("#88880000")); // 覆盖一层半透明遮罩


        // 矩形
        canvas.drawRect(600, 100, 1000, 500, mPaint);


        // 点
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(100, 600, mPaint);

        // 圆点
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        // 方点
        //        mPaint.setStrokeCap(Paint.Cap.BUTT);
        //        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(150, 600, mPaint);

        // 点集合
        mPaint.setColor(Color.RED);
        float[] points = {0, 0, 200, 600, 250, 600, 300, 600, 350, 600, 400, 600};
        canvas.drawPoints(points,
                2/*跳过前n个数再拿坐标*/,
                8/*一个绘制n个数, n/2 个点*/,
                mPaint
        );


        // 椭圆
        mPaint.setColor(Color.YELLOW);
        canvas.drawOval(100, 650, 400, 850, mPaint);


        // 画线
        //        mPaint.setStyle(); // 画线不影响
        canvas.drawLine(450, 650, 750, 850, mPaint);

        float[] lines = {900, 650, 1000, 650, 800, 750, 1050, 750, 950, 650, 950, 850};
        canvas.drawLines(lines, mPaint);


        // 圆角矩形
        canvas.drawRoundRect(100, 900, 500, 1100, 50, 50, mPaint);

        // 圆弧 或 扇形
        mPaint.setStyle(Paint.Style.FILL);
        // 扇形
        canvas.drawArc(600, 900, 900, 1100, -110, 100, true, mPaint);
        // 弧形
        canvas.drawArc(600, 900, 900, 1100, 20, 140, false, mPaint);
        // 圆弧
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(600, 900, 900, 1100, 180, 60, false, mPaint);


        // 画图
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 100, 1150, mPaint);
        //        canvas.drawBitmapMesh();


        // 绘制文字
        mPaint.setTextSize(80);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText("Hello", 250, 1250, mPaint);
    }
}
