package com.zkhaider.sweartime.ui;

import android.app.Activity;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.Display;

public abstract class WatchFaceActivity extends Activity implements DisplayManager.DisplayListener {

    public abstract void onScreenDim();

    public abstract void onScreenAwake();

    public void onWatchFaceRemoved(){};

    public void onScreenOff(){};

    private DisplayManager displayManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set up the display manager and register a listener (this activity)
        displayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
        displayManager.registerDisplayListener(this, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        displayManager.unregisterDisplayListener(this);
    }

    @Override
    public void onDisplayAdded(int displayId) {
        switch (displayManager.getDisplay(displayId).getState()) {
            case Display.STATE_DOZE:
                onScreenDim();
                break;
            case Display.STATE_OFF:
                onScreenOff();
                break;
            default:
                onScreenAwake();
                break;
        }
    }

}
