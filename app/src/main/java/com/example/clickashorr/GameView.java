package com.example.clickashorr;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private CharacterSprite characterSprite;
    //constructor
    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    //override some methods
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    // starts thread
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
            characterSprite = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.shorr));
            thread.setRunning(true);
            thread.start();
    }
    //stops thread
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update() {
        characterSprite.update();
    }
    // draws graphics
    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        if (canvas != null) {
            canvas.drawColor(Color.WHITE);
            characterSprite.draw(canvas);
        }

    }

}
