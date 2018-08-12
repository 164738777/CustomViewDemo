package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:  lbqiang on 2018/8/11 16:27
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */
public class PathView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initPaint();
        initPath();
    }

    private void initPaint() {
        mPaint.setColor(Color.RED);
        //        mPaint.setStyle(Paint.Style.STROKE);
        //        mPaint.setStrokeWidth(5);
    }

    private void initPath() {
        // ❤
        //        mPath.addArc(200, 200, 400, 400, -225, 225);
        //        mPath.arcTo(400, 200, 600, 400, 180, 225, false);
        //        mPath.lineTo(400, 542);

        // Path 分种类, 第一类：直接描述路径

        // 1. 添加子图形
        // 只画普通圆形， 直接用drawCircle则可以, Path通常用于组合图形
        //        mPath.addCircle(300, 300, 200, Path.Direction.CW);
        //        mPath.addOval();
        //        mPath.addRoundRect();

        // 2. 画线
        mPaint.setStyle(Paint.Style.STROKE);
        //        mPath.lineTo(100, 100); // 相对绝对坐标，由当前位置（0，0）向（100， 100）画一直线

        // 相对相对坐标，由当前位置（100，100）向（100， 100）画一直线(可以理解为以上一个path的坐标为原点的坐标轴开始计算)
        //        mPath.rLineTo(100, 0);

        // 二三阶贝塞尔曲线
        //        mPath.quadTo();
        //        mPath.cubicTo();

        // 常用函数，移动初始坐标
        //        mPath.lineTo(100, 100);
        //        mPath.moveTo(200, 100); // 移动起点坐标, 常用
        //        mPath.lineTo(200, 0);

        //        mPath.lineTo(100, 100);
        // 相对初始坐标(100, 100)，并非(0,0)
        // 最后参数：是否无痕。如果和前面的path有间隔，是否留下移动痕迹
        //        mPath.arcTo(100, 100, 300, 300, -90, 90, false);
        // 以下两句效果一模一样
        //        mPath.arcTo(100, 100, 300, 300, -90, 90, true);
        //        mPath.addArc(100, 100, 300, 300, -90, 90);

        mPaint.setStyle(Paint.Style.STROKE);
        mPath.moveTo(100, 100);
        mPath.lineTo(200, 100);
        mPath.lineTo(150, 150);
        mPath.close(); // 画一条直线以封闭图形， 其实和lineTo 完全等价，只是不需要自己再输入坐标
        // 如果FIll笔触，这代码不需要close也会自动封闭

        // ----------------------------------分割线----------------------------------------

        // Path 第二类：辅助设置或计算
        // 涉及path的逆顺向
        //        mPath.setFillType(Path.FillType.EVEN_ODD);
        //        mPath.setFillType(Path.FillType.WINDING);
        //        mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD); // 反向
        //        mPath.setFillType(Path.FillType.INVERSE_WINDING); // 反向



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(mPath, mPaint);
    }
}
