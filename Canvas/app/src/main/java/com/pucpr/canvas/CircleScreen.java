package com.pucpr.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class CircleScreen extends View {

    private Random rnd = new Random();
    private Paint paint = new Paint();
    private long startTime = System.nanoTime();
    private float animTime = 0;
    private int a;
    private int r;
    private int g;
    private int b;
    private int x;
    private int y;
    private int radius;


    public CircleScreen(Context context) {
        super(context);
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

        for (int i = 0; i < 1000; i++) {

            a = rnd.nextInt(256);
            r = rnd.nextInt(256);
            g = rnd.nextInt(256);
            b = rnd.nextInt(256);
            paint.setARGB(a, r, g, b);

            x = rnd.nextInt(canvas.getWidth() + 1);
            y = rnd.nextInt(canvas.getHeight() + 1);
            radius = rnd.nextInt(50) + 50;

            canvas.drawCircle(x, y, radius, paint);
        }

    }
}
