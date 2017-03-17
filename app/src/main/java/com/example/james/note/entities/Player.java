package com.example.james.note.entities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.example.james.note.weapons.ShittyGunWeapon;
import com.example.james.note.weapons.Weapon;

/**
 * Created by James on 3/16/2017.
 */

public class Player extends LivingEntity{

    private Weapon weapon;


    public Player()
    {
        weapon = new ShittyGunWeapon();
        positionX = 0;
        positionY = 0;
        health = 100;

        entityPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        entityPaint.setColor(Color.GREEN);
        entityPaint.setStyle(Paint.Style.FILL);
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void doEntityLivingLogic(Player player) {
        health++;
    }

    public Weapon getWeapon() {
        return weapon;
    }


    public void changeCharacterLocation(int distanceFromCenter, float angle)
    {
        int changeX = (int) (distanceFromCenter * Math.cos(angle)) / 10;
        int changeY = (int) (distanceFromCenter * Math.sin(angle)) / 10;
        positionX += changeX;
        positionY += changeY;
    }
}
