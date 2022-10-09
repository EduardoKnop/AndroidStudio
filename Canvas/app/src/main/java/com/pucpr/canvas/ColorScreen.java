package com.pucpr.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import java.util.Random;

public class ColorScreen extends View {

    private Random rnd = new Random();
    private int r;
    private int g;
    private int b;
    private long startTime = System.nanoTime();
    private float animTime = 0;


    public ColorScreen(Context context) {
        super(context);

        r = rnd.nextInt(256);
        g = rnd.nextInt(256);
        b = rnd.nextInt(256);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Cálculo do Tempo transcorrido em ms
        float elapsedTime = (System.nanoTime() - startTime) / 1000000.0f;
        startTime = System.nanoTime();

        animTime += elapsedTime;
        if (animTime >= 1000) {

            animTime = 0;
            r = rnd.nextInt(256);
            g = rnd.nextInt(256);
            b = rnd.nextInt(256);

        }
        canvas.drawRGB(r, g, b);

        invalidate();

    }
}
