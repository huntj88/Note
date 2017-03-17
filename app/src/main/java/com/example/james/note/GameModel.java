package com.example.james.note;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.james.note.entities.Entity;
import com.example.james.note.entities.LivingEntity;
import com.example.james.note.entities.Player;
import com.example.james.note.entities.Zombie;

import java.util.ArrayList;

/**
 * Created by James on 3/16/2017.
 */

public class GameModel implements Runnable {

    private GamePresenterContract presenter;
    private Player player;
    private ArrayList<Entity> entities;

    public GameModel(GamePresenterContract presenter) {
        this.presenter = presenter;
        player = new Player();
        entities = new ArrayList<>();
        entities.add(player);
    }

    public void drawModel(Canvas canvas) {

        for(int i = 0; i < entities.size(); i++)
        {
            entities.get(i).drawEntity(canvas);
        }
    }

    public void doEntityLogic()
    {

        entities.add(new Zombie());

        for(int i = 0; i < entities.size(); i++)
        {
            Entity temp = entities.get(i);
           if(temp instanceof LivingEntity)
           {
               ((LivingEntity) temp).doEntityLivingLogic(player);
           }
        }
    }

    public void changeCharacterLocation(int distanceFromCenter, float angle) {
        player.changeCharacterLocation(distanceFromCenter, angle);
    }

    public void run() {
        while (true) {
            try {
                doEntityLogic();
                presenter.updateView();
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}