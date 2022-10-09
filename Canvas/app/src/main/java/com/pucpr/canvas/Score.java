package com.pucpr.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

public class Score {

    private Paint paint = new Paint();
    private int score = 0;


    public Score(Context context) {

        Typeface fredoka = Typeface.createFromAsset(context.getAssets(), "fredoka.ttf");

        paint.setTypeface(fredoka);
        paint.setTextSize(60);
        paint.setARGB(255, 0, 0, 0);

    }


    public void update() {
        score++;
    }


    public void render(Canvas canvas) {

        canvas.drawText("Score: " + score, 20, 50, paint);
    }
}
