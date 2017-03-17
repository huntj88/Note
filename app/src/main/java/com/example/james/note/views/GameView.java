package com.example.james.note.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.james.note.GamePresenter;
import com.example.james.note.GameViewContract;
import com.example.james.note.entities.Entity;
import com.example.james.note.entities.Player;

import java.util.ArrayList;

/**
 * Created by James on 3/16/2017.
 */

public class GameView extends View implements GameViewContract {

    private GamePresenter presenter;

    public GameView(Context context) {
        super(context);
        init(context);
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context)
    {

    }

    public void setPresenter(GamePresenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        presenter.drawModel(canvas);
    }

    @Override
    public void updateView() {
        postInvalidate();
    }
}
