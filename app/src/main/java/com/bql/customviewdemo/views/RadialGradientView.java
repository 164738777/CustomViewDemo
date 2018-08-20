package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者:  lbqiang on 2018/8/20 23:22
 * 邮箱:  anworkmail_q@126.com
 * 作用:  RadialGradient 辐射渐变
 */
public class RadialGradientView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private Shader mShader;
    private Shader mShaderClamp;
    private Shader mShaderMirror;
    private Shader mShaderRepeat;

    public RadialGradientView(Context context) {
        this(context, null);
    }

    public RadialGradientView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadialGradientView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initShader();
    }

    private void initShader() {
        // TitleMode 辐射范围之外的着色模式

        mShader = new RadialGradient(300, 300, 200, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);

        mShaderClamp = new RadialGradient(300, 750, 100, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);

        mShaderMirror = new RadialGradient(300, 1150, 100, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.MIRROR);

        mShaderRepeat = new RadialGradient(300, 1550, 100, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setShader(mShader);
        canvas.drawCircle(300, 300, 200, mPaint);

        mPaint.setShader(mShaderClamp);
        canvas.drawRect(100, 600, 500, 900, mPaint);

        mPaint.setShader(mShaderMirror);
        canvas.drawRect(100, 1000, 500, 1300, mPaint);

        mPaint.setShader(mShaderRepeat);
        canvas.drawRect(100, 1400, 500, 1700, mPaint);


    }
}
