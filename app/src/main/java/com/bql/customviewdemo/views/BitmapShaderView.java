package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.bql.customviewdemo.R;

/**
 * 作者:  lbqiang on 2018/8/23 22:42
 * 邮箱:  anworkmail_q@126.com
 * 作用:  https://hencoder.com/ui-1-2/ 了解即可
 */
public class BitmapShaderView extends View {
    private Shader mShader;
    private Shader mShader2;
    private Shader mComposeShader;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public BitmapShaderView(Context context) {
        this(context, null);
    }

    public BitmapShaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BitmapShaderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mShader = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.drawable.img_batman), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mShader2 = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mComposeShader = new ComposeShader(mShader, mShader2, PorterDuff.Mode.SRC_OVER);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        mPaint.setShader(mShader);
        //        canvas.drawCircle(200, 200, 100, mPaint);

        mPaint.setShader(mComposeShader);
        canvas.drawCircle(200, 200, 100, mPaint);
    }
}
