package com.example.prj_03;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


import android.app.Activity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    GameThread gameThread;

    public GameView(Activity activity) {
        super(activity);

        this.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        gameThread = new GameThread(this);
        gameThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}


