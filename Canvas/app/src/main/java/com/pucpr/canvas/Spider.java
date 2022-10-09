package com.pucpr.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;

import java.io.IOException;
import java.io.InputStream;

public class Spider {

    private float w = 0;
    private float h = 0;
    private Bitmap spider;
    private Rect src;
    private RectF dst;
    private int frame = 0;
    private float x;
    private float y;
    private float animTime = 0;
    private float vel = 220; // px/s
    private boolean first = true;

    public Spider(float x, float y, Context context) {
        this.x = x;
        this.y = y;
        this.w = 5000;
        this.h = 5000;

        try {

            InputStream stream = context.getAssets().open("aranha.png");
            spider = BitmapFactory.decodeStream(stream);
            stream.close();

        }
        catch (IOException e) {

            e.printStackTrace();

        }
    }


    public void moveLeft(float elapsedTime) {

        animTime += elapsedTime;
        if (animTime >= 100) {

            animTime = 0;
            frame++;

            if (frame == 4)
                frame = 0;
        }

        x -= vel * elapsedTime / 1000;

        if (x < -192)
            x = w + 192;

        src = new Rect(frame * 96, 96, frame * 96 + 96, 192);
        dst = new RectF(x - 192,  y - 192,  x + 192,  y + 192);

    }


    public void moveRight(float elapsedTime) {

        animTime += elapsedTime;
        if (animTime >= 100) {
            animTime = 0;
            frame++;
            if (frame == 4)
                frame = 0;
        }

        x += vel * elapsedTime / 1000;

        if (x > w + 192)
            x = -192;


        src = new Rect(frame * 96, 192, frame * 96 + 96, 288);
        dst = new RectF(x - 192,  y - 192,  x + 192,  y + 192);

    }


    public void moveUp(float elapsedTime) {

        animTime += elapsedTime;
        if (animTime >= 100) {
            animTime = 0;
            frame++;
            if (frame == 4)
                frame = 0;
        }

        y -= vel * elapsedTime / 1000;

        if (y < -192)
            y = h + 192;

        src = new Rect(frame * 96, 288, frame * 96 + 96, 384);
        dst = new RectF(x - 192,  y - 192,  x + 192,  y + 192);

    }


    public void moveDown(float elapsedTime) {

        animTime += elapsedTime;
        if (animTime >= 100) {
            animTime = 0;
            frame++;
            if (frame == 4)
                frame = 0;
        }

        y += vel * elapsedTime / 1000;
        if (y > h + 192)
            y = - 192;

        src = new Rect(frame * 96, 0, frame * 96 + 96, 96);
        dst = new RectF(x - 192,  y - 192,  x + 192,  y + 192);

    }


    public void update(float x, float y, String move) {

        frame++;
        if (frame == 4)
            frame = 0;

        switch (move) {
            case "Down":
                src = new Rect(frame * 96, 0, frame * 96 + 96, 96);
                break;
            case "Up":
                src = new Rect(frame * 96, 288, frame * 96 + 96, 384);
                break;
            case "Left":
                src = new Rect(frame * 96, 96, frame * 96 + 96, 192);
                break;
            case "Right":
                src = new Rect(frame * 96, 192, frame * 96 + 96, 288);
                break;
        }

        dst = new RectF(x - 192,  y - 192,  x + 192,  y + 192);

        this.x = x;
        this.y = y;

    }


    public RectF getDst() {
        return dst;
    }

    public void render(Canvas canvas) {

        if (first) {

            first = false;
            this.w = canvas.getWidth();
            this.h = canvas.getHeight();

        }

        canvas.drawBitmap(spider, src, dst, null);

    }
}
