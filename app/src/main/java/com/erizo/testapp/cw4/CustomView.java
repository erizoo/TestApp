package com.erizo.testapp.cw4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Erizo on 16.02.2018.
 */

public class CustomView extends View {

    private Paint paint;
    private float radius;
    private float cx;
    private float cy;
    private RectF rect;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setColor(Color.MAGENTA);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        cx = w / 2;
        cy = h / 2;
        radius = w > h ? cy / 4 : cx / 4;

        float wRec = w * 0.9f;
        float hRec = w * 0.2f;

        rect = new RectF();
        rect.left = (w - wRec) / 2;
        rect.right = w - rect.left;
        rect.top = (h - hRec) / 2;
        rect.bottom = h - rect.top;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawCircle(cx, cy, radius, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:{
                break;
            }
            case MotionEvent.ACTION_UP:{
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                cx = event.getX();
                cy = event.getY();
                invalidate();
                return false;
            }

        }
        return true;
    }
}
