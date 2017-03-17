package com.example.james.note.weapons;

/**
 * Created by James on 3/16/2017.
 */

public abstract class Weapon {

    protected String weaponName;
    protected int weaponDamage;
    protected float weaponRateOfFire;

    public String getWeaponName()
    {
        return weaponName;
    }

    public int getWeaponDamage()
    {
        return weaponDamage;
    }

    public float getWeaponRateOfFire()
    {
        return weaponRateOfFire;
    }

}
