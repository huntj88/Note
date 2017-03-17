package com.example.james.note.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.james.note.GamePresenter;
import com.example.james.note.Utils;

/**
 * Created by James on 3/16/2017.
 */

public class JoystickView extends View implements View.OnTouchListener{

    private Paint basePaint;
    private Paint fingerPaint;
    private GamePresenter presenter;
    private float angle = 0;
    private int distanceFromCenter = 0;
    private boolean leftJoystick = true;


    public JoystickView(Context context) {
        super(context);
        init();
    }

    public JoystickView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public JoystickView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public JoystickView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init()
    {
        setOnTouchListener(this);
        basePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        basePaint.setColor(Color.BLUE);
        basePaint.setStyle(Paint.Style.FILL);

        fingerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fingerPaint.setColor(Color.LTGRAY);
        fingerPaint.setStyle(Paint.Style.FILL);
    }

    public void setPresenter(GamePresenter presenter)
    {
        this.presenter = presenter;
    }

    public void setRightJoystick()
    {
        leftJoystick = false;
    }

    public int getDistanceFromCenter(int x, int y)
    {
        x = x - getWidth()/2;
        y = y - getHeight()/2;
        int distance = (int) Math.sqrt(x*x + y*y);

        if(distance > Utils.dpToPx(40))
            distance = Utils.dpToPx(40);

        distanceFromCenter = distance;

        return distance;
    }

    public float getAngle(int x, int y)
    {
        double baseAngle = (Math.atan2(y - getHeight()/2,x - getWidth()/2));

        angle = (float) baseAngle;

        return (float) baseAngle;
    }

    public int[] getfingerCordinatesForDrawning()
    {
        int fingerX = (int) (distanceFromCenter * Math.cos(angle)) + getWidth()/2;
        int fingerY = (int) (distanceFromCenter * Math.sin(angle)) + getHeight()/2;

        return new int[]{fingerX,fingerY};
    }

    public void onDraw(Canvas canvas)
    {
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,basePaint);
        int[] fingerCoord = getfingerCordinatesForDrawning();
        canvas.drawCircle(fingerCoord[0],fingerCoord[1],Utils.dpToPx(14),fingerPaint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(leftJoystick)
            presenter.setLeftJoystickValues(getDistanceFromCenter((int)event.getX(),(int)event.getY()),getAngle((int)event.getX(),(int)event.getY()));
        else
            presenter.setRightJoystickValues(getDistanceFromCenter((int)event.getX(),(int)event.getY()),getAngle((int)event.getX(),(int)event.getY()));

        if(event.getAction() == MotionEvent.ACTION_UP)
        {
            distanceFromCenter = 0;
        }

        invalidate();


        return true;
    }
}
