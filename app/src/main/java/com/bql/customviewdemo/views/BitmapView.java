package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.bql.customviewdemo.R;

/**
 * 作者:  lbqiang on 2018/9/12 23:36
 * 邮箱:  anworkmail_q@126.com
 * 作用:  https://hencoder.com/ui-1-4/
 */
public class BitmapView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

    public BitmapView(Context context) {
        this(context, null);
    }

    public BitmapView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BitmapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 范围裁切
        // clipRect clipPath
        canvas.save();
        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
        canvas.restore();

        Path path = new Path();
        path.addCircle(bitmap.getWidth() + 50 + bitmap.getWidth() / 2, bitmap.getHeight() / 2, 50, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 50, 0, mPaint);
        canvas.restore();



        // canvas 二维变换
        canvas.save();
        //        canvas.translate(200, 0); // 平移
        //        canvas.rotate(45, bitmap.getWidth() / 2, bitmap.getHeight() / 2 + 150); // 旋转
        //        canvas.scale(1.3f, 1.3f); // 缩放
        //        canvas.skew(0, 0.5f); // 歪斜
        canvas.drawBitmap(bitmap, 0, 150, mPaint);
        canvas.restore();
    }
}
