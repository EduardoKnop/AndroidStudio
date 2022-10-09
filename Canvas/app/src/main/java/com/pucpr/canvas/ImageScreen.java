package com.pucpr.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

public class ImageScreen extends View {

    private Bitmap smi;

    public ImageScreen(Context context) {
        super(context);

        try {

            InputStream stream = context.getAssets().open("smi.png");
            smi = BitmapFactory.decodeStream(stream);
            stream.close();

        }
        catch (IOException e) {

            e.printStackTrace();

        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(smi,
                canvas.getWidth() / 2 - smi.getWidth() / 2,
                20,
                null);

        Rect dst = new Rect(canvas.getWidth() / 2 - smi.getWidth(),
                400,
                canvas.getWidth() / 2 + smi.getWidth(),
                400 + 2 * smi.getHeight());

        canvas.drawBitmap(smi, null, dst, null);

        Rect src = new Rect(smi.getWidth() / 4,
                smi.getHeight() / 4,
                smi.getWidth() / 4 * 3,
                smi.getHeight() / 4 * 3);

        dst.set(canvas.getWidth() / 2 - smi.getWidth(),
                1140,
                canvas.getWidth() / 2 + smi.getWidth(),
                1140 + 2 * smi.getHeight());

        canvas.drawBitmap(smi, src, dst, null);
    }
}
