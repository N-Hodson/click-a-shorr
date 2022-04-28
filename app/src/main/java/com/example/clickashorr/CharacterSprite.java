package com.example.clickashorr;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ResourceBundle;

public class CharacterSprite {
    private Bitmap image;
    private int x,y;
    private int xVelocity = 10;
    private int yVelocity = 20;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public CharacterSprite(Bitmap bmp) {
        image = bmp;
        x = 100;
        y = 100;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update(){
        if(x<0 && y<0){
            x = screenWidth / 2;
            y = screenHeight / 2;
        }else{
            x += xVelocity;
            y += yVelocity;
            if(x>screenWidth-image.getWidth())||
        }
    }

}
