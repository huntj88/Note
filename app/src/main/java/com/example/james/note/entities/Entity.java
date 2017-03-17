package com.example.james.note.entities;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by James on 3/16/2017.
 */

public abstract class Entity {

    protected int positionX;
    protected int positionY;
    protected Paint entityPaint;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Paint getEntityPaint() {
        return entityPaint;
    }

    public void drawEntity(Canvas canvas)
    {
        canvas.drawRect(canvas.getWidth()/2 + getPositionX() - 10,canvas.getHeight()/2 + getPositionY() - 10, canvas.getWidth()/2 + getPositionX() + 10, canvas.getHeight()/2 + getPositionY() + 10, getEntityPaint());
    }
}
