package com.pucpr.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class AnimScreen extends View implements View.OnTouchListener {

    Random rnd = new Random();
    private float x;
    private float y;
    private int xCircle;
    private int yCircle;
    private final Spider spider;
    private final Circle circle;
    private final Score score;
    private long startTime = System.nanoTime();
    private String move = "Down";
    private boolean caught = false;

    public AnimScreen(Context context) {
        super(context);

        this.setOnTouchListener(this);
        spider = new Spider(600, 900, context);

        xCircle = rnd.nextInt(720);
        yCircle = rnd.nextInt(1080);
        circle = new Circle(xCircle, yCircle);

        score = new Score(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float elapsedTime = (System.nanoTime() - startTime) / 1000000.0f;
        startTime = System.nanoTime();

        if (caught)
            spider.update(x, y, move);
        else {
            switch (move) {
                case "Down":
                    spider.moveDown(elapsedTime);
                    break;
                case "Up":
                    spider.moveUp(elapsedTime);
                    break;
                case "Left":
                    spider.moveLeft(elapsedTime);
                    break;
                case "Right":
                    spider.moveRight(elapsedTime);
                    break;
            }
        }

        if (spider.getDst().contains(xCircle, yCircle)) {

            xCircle = rnd.nextInt(getWidth() + 1);
            yCircle = rnd.nextInt(getHeight() + 1);
            score.update();

        }

        circle.update(xCircle, yCircle);

        spider.render(canvas);
        circle.render(canvas);
        score.render(canvas);

        invalidate();
    }


    @Override
    public boolean onTouch(View view, MotionEvent e) {

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = e.getX();
                y = e.getY();

                if (spider.getDst().contains(x, y))
                    caught = true;
                else if (x < view.getWidth() / 4.0f)
                    move = "Left";
                else if (y > view.getHeight() / 4.0f * 3)
                    move = "Down";
                else if (y < view.getHeight() / 4.0f)
                    move = "Up";
                else if (x > view.getWidth() / 4.0f * 3)
                    move = "Right";

                break;
            case MotionEvent.ACTION_MOVE:
                if (caught) {

                    x = e.getX();
                    y = e.getY();
                }

                break;
            case MotionEvent.ACTION_UP:
                if (caught)
                    caught = false;

                break;
        }

        return true;
    }
}
