package com.pucpr.canvas;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle {

    Paint paint = new Paint();
    private int x;
    private int y;
    private int radius = 30;


    public Circle(int x, int y) {

        paint.setARGB(255, 200, 50, 0);

        this.x = x;
        this.y = y;
    }


    public void update(int x, int y) {

        this.x = x;
        this.y = y;

    }


    public void render(Canvas canvas) {

        canvas.drawCircle(x, y, radius, paint);
    }
}
