package com.example.james.note;

import android.graphics.Canvas;

import com.example.james.note.entities.Player;
import com.example.james.note.views.JoystickView;

/**
 * Created by James on 3/16/2017.
 */

public class GamePresenter implements GamePresenterContract{

    GameViewContract view;
    GameModel model;
    boolean limitLeftJoystickInput = false;
    boolean limitRightJoystickInput = false;

    public GamePresenter(GameViewContract view)
    {
        this.view = view;
    }

    public void setLeftJoystickValues(int distanceFromCenter, float angle)
    {
        if(!limitLeftJoystickInput) {
            limitLeftJoystickInput = true;
            model.changeCharacterLocation(distanceFromCenter, angle);
        }
    }

    public void setRightJoystickValues(int distanceFromCenter, float angle)
    {

    }

    public void setModel(GameModel model)
    {
        this.model = model;
    }

    public void drawModel(Canvas canvas)
    {
        model.drawModel(canvas);
    }

    @Override
    public void updateView() {
        limitLeftJoystickInput = false;
        limitRightJoystickInput = false;
        view.updateView();
    }
}
