package com.pucpr.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class PointScreen extends View {

    private Random rnd = new Random();
    private Paint paint = new Paint();
    private long startTime = System.nanoTime();
    private float animTime = 0;
    private int r;
    private int g;
    private int b;
    private int x;
    private int y;


    public PointScreen(Context context) {
        super(context);
        paint.setStrokeWidth(5);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float elapsedTime = (System.nanoTime() - startTime) / 1000000.0f;
        startTime = System.nanoTime();

        update(elapsedTime);
        render(canvas);

        invalidate();
    }


    private void update(float elapsedTime) {


    }


    private void render(Canvas canvas) {

        canvas.drawRGB(0, 0, 0);

        for (int i = 0; i< 10000; i++) {

            r = rnd.nextInt(256);
            g = rnd.nextInt(256);
            b = rnd.nextInt(256);
            x = rnd.nextInt(canvas.getWidth() + 1);
            y = rnd.nextInt(canvas.getHeight() + 1);
            paint.setARGB(255, r, g, b);

            canvas.drawPoint(x, y, paint);
        }
    }
}
