package com.example.james.note;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.james.note.views.GameView;
import com.example.james.note.views.JoystickView;

public class MainActivity extends AppCompatActivity {

    private GamePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameView gameView = (GameView) findViewById(R.id.game_view);

        JoystickView left = (JoystickView) findViewById(R.id.left_joystick);
        JoystickView right = (JoystickView) findViewById(R.id.right_joystick);
        right.setRightJoystick();

        presenter = new GamePresenter(gameView);

        GameModel model = new GameModel(presenter);
        presenter.setModel(model);

        gameView.setPresenter(presenter);
        left.setPresenter(presenter);
        right.setPresenter(presenter);

        new Thread(model).start();


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // ignore orientation/keyboard change
        super.onConfigurationChanged(newConfig);
    }
}
