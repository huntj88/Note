package com.example.james.note.entities;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by James on 3/17/2017.
 */

public class Zombie extends LivingEntity {

    public Zombie()
    {
        aggressive = true;
        speed = 3;
        positionX = (int) (Math.random()*2500) - 1250;
        positionY = (int) (Math.random()*2500) - 1250;

        entityPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        entityPaint.setColor(Color.RED);
        entityPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void doEntityLivingLogic(Player player) {
        entityRotation = (float) (Math.atan2(getPositionY() - player.getPositionY(),getPositionX() - player.getPositionX()));

        positionX -= getSpeed() * Math.cos(entityRotation);
        positionY -= getSpeed() * Math.sin(entityRotation);

    }
}
