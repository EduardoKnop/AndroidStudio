package com.pucpr.canvas;

import static java.lang.Math.pow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class TouchScreen extends View implements View.OnTouchListener {

    private Paint paint = new Paint();

    private float x;
    private float y;
    private boolean first = true;
    private boolean caught = false;

    public TouchScreen(Context context) {
        super(context);
        setOnTouchListener(this);

        paint.setARGB(255, 255, 255, 255);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (first == true) {
            x = canvas.getWidth() / 2;
            y = canvas.getHeight() / 2;
            first = false;
        }

        canvas.drawRGB(0, 0, 0);
        canvas.drawCircle(x, y, 100, paint);

        invalidate();
    }

    @Override
    public boolean onTouch(View view, MotionEvent e) {

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                double dist = Math.sqrt(pow(x - e.getX(), 2) + pow(y - e.getY(), 2));
                if (dist < 100) {

                    caught = true;
                    paint.setStyle(Paint.Style.FILL);
                }
                paint.setStyle(Paint.Style.FILL);
                break;
            case MotionEvent.ACTION_MOVE:
                if (caught == true) {

                    x = e.getX();
                    y = e.getY();
                }
                break;
            case MotionEvent.ACTION_UP:
                if (caught == true) {

                    caught = false;
                }

                paint.setStyle(Paint.Style.STROKE);
                break;
            default:
                break;
        }

        return true;
    }
}
