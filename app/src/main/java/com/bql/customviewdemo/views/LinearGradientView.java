package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:  lbqiang on 2018/8/20 22:53
 * 邮箱:  anworkmail_q@126.com
 * 作用:  LinearGradient 线性渐变
 */
public class LinearGradientView extends View {
    private Shader mShader;
    private Shader mShaderClamp;
    private Shader mShaderMirror;
    private Shader mShaderRepeat;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public LinearGradientView(Context context) {
        this(context, null);
    }

    public LinearGradientView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearGradientView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initShader();
    }

    private void initShader() {
        mShader = new LinearGradient(100, 100, 500, 500,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);

        mShaderClamp = new LinearGradient(250, 650, 350, 750,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);

        mShaderMirror = new LinearGradient(750, 650, 850, 750,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.MIRROR);

        mShaderRepeat = new LinearGradient(250, 950, 350, 1050,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 在设置了 Shader 的情况下， Paint.setColor/ARGB() 所设置的颜色不再起作用。
        mPaint.setShader(mShader);
        canvas.drawCircle(300, 300, 200, mPaint);

        // 默认效果
        mPaint.setShader(mShaderClamp);
        canvas.drawRect(100, 600, 500, 800, mPaint);
        // 镜像效果
        mPaint.setShader(mShaderMirror);
        canvas.drawRect(600, 600, 1000, 800, mPaint);
        // 重复效果
        mPaint.setShader(mShaderRepeat);
        canvas.drawRect(100, 900, 500, 1100, mPaint);
    }
}
