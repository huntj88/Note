package com.example.james.note.entities;

/**
 * Created by James on 3/16/2017.
 */

public abstract class LivingEntity extends StaticEntity {

    protected float entityRotation;
    protected int health;
    protected boolean aggressive = false;
    protected int speed = 2;

    public float getEntityRotation() {
        return entityRotation;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    public int getSpeed() {
        return speed;
    }

    public abstract void doEntityLivingLogic(Player player);
}
