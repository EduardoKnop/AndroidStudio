package com.pucpr.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.view.View;

public class TextScreen extends View {

    private Typeface fredoka;
    private Paint paint = new Paint();
    Path path = new Path();

    public TextScreen(Context context) {
        super(context);

        fredoka = Typeface.createFromAsset(context.getAssets(), "fredoka.ttf");
        paint.setTypeface(fredoka);
        paint.setTextSize(80);
        paint.setARGB(255, 0, 0, 200);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setFakeBoldText(true);
        paint.setTextSkewX(-0.18f);
        path.moveTo(100, 400);
        path.lineTo(500, 700);
        path.lineTo(900, 100);
        path.lineTo(1300, 400);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("TESTE",
                canvas.getWidth() / 2,
                canvas.getHeight() / 2,
                paint);

        canvas.drawTextOnPath("Texto sobre um caminho Ihuuuuu",
                path,
                0,
                0,
                paint);
    }
}
