package com.bql.customviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 作者:  lbqiang on 2018/9/4 23:31
 * 邮箱:  anworkmail_q@126.com
 * 作用:  https://hencoder.com/ui-1-3/
 */
public class DrawTextView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();
    private PathEffect mCornerPathEffect = new CornerPathEffect(20);
    private StaticLayout mStaticLayout;
    private StaticLayout mStaticLayout2;
    private TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

    public DrawTextView(Context context) {
        this(context, null);
    }

    public DrawTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // drawText的坐标在 左下角 （再偏左一点点），而不是左上角
        // 偏左一点点是因为最左边的 H 周围是有间隙
        String text = "Hello World";
        mPaint.setTextSize(40);
        canvas.drawText(text, 0, 100, mPaint);

        // API 23  新设置：上下文，文字方向
        //        canvas.drawTextRun();

        // drawTextOnPath() 使用的 Path ，拐弯处全用圆角，别用尖角，否则难看
        drawLines(50, 150);
        mPaint.reset();
        mPaint.setTextSize(40);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setPathEffect(mCornerPathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.drawTextOnPath(text, mPath, 0, 0, mPaint);


        // StaticLayout 多行文字的绘制，换行, 并不是一个 View 或者 ViewGroup
        String longText = "Hello World 我非常非常非常非常非常非常非常非常非常非常非常非常非常非常非常长，要换行先得";
        String longText2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";
        mTextPaint.setTextSize(40);
        mStaticLayout = new StaticLayout(longText, mTextPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        mStaticLayout2 = new StaticLayout(longText2, mTextPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        canvas.save();
        canvas.translate(50, 400);
        mStaticLayout.draw(canvas);
        canvas.translate(0, 200);
        mStaticLayout2.draw(canvas);
        canvas.restore();


        // 设置字体
        //        mPaint.setTypeface();

        mPaint.reset();
        mPaint.setTextSize(40);
        canvas.drawText(text, 0, 1100, mPaint);
        mPaint.setFakeBoldText(true); // 伪粗体，不改变字体weight
        canvas.drawText(text, 0, 1150, mPaint);
        mPaint.setFakeBoldText(false);
        mPaint.setStrikeThruText(true); // 删除线
        mPaint.setUnderlineText(true); // 下划线
        mPaint.setTextSkewX(-0.5f); // 文字倾斜度
        canvas.drawText(text, 0, 1200, mPaint);
        mPaint.setTextScaleX(0.8f); // 文字横向放缩
        mPaint.setLetterSpacing(0.2f); // 字符间距，默认0
        //        mPaint.setFontFeatureSettings(); // 用 CSS 的 font-feature-settings 的方式来设置文字
        //        mPaint.setTextAlign(Paint.Align.RIGHT); // 设置文字对齐方式, 默认left
        //        mPaint.setTextLocale(); // 设置Locale文字本地化（例如大陆，台湾，日本的相同中文的书写方式差异）
        //        mPaint.setElegantTextHeight(); // 中英文没用，压缩高度
        canvas.drawText(text, 0, 1250, mPaint);


        // 获取推荐的行距(手动绘制的两行baseline的距离，并不是StaticLayout的多行文字)
        Log.d("MyLog", "onDraw:getFontSpacing " + mPaint.getFontSpacing());

        // FontMetrics 包含：top, ascent, descent, bottom 的位置, 以及leading的大小
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        Log.d("MyLog", "onDraw:fontMetrics ----  ");
        // 4个位置均以baseline为相对应起点
        Log.d("MyLog", "onDraw:top " + fontMetrics.top);
        Log.d("MyLog", "onDraw:ascent " + fontMetrics.ascent); // mPaint.ascent()
        Log.d("MyLog", "onDraw:descent " + fontMetrics.descent); // mPaint.descent()
        Log.d("MyLog", "onDraw:bottom " + fontMetrics.bottom);
        Log.d("MyLog", "onDraw:leading " + fontMetrics.leading);


        // getTextBounds 获取文字显示范围
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(40);
        canvas.drawText(text, 0, 1300, mPaint);
        Rect bound = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), bound);
        bound.top += 1300;
        bound.bottom += 1300;
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(bound, mPaint);


        // 测量文字占用宽度（宽于getTextBounds）
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(text, 0, 1350, mPaint);
        float textWidth = mPaint.measureText(text);
        canvas.drawLine(0, 1350, textWidth, 1350, mPaint);


        // 获取给定的长度以内所测量的文字宽度 breakText 返回值是截取的个数
        float[] measuredWidth = {0};
        int measuredCount = mPaint.breakText(text, 0, text.length(), true, 100, measuredWidth);
        canvas.drawText(text, 0, measuredCount, 0, 1400, mPaint);

        measuredCount = mPaint.breakText(text, 0, text.length(), true, 150, measuredWidth);
        canvas.drawText(text, 0, measuredCount, 0, 1450, mPaint);

        measuredCount = mPaint.breakText(text, 0, text.length(), true, 300, measuredWidth);
        canvas.drawText(text, 0, measuredCount, 0, 1500, mPaint);
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
