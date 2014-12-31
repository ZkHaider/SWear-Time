package com.zkhaider.sweartime.services;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.wearable.watchface.CanvasWatchFaceService;
import android.view.SurfaceHolder;

/**
 * Created by Haider on 12/25/2014.
 */
public class AnalogWatchFaceService extends CanvasWatchFaceService {

    @Override
    public Engine onCreateEngine() {
        /* Provide your watch face implementation */
        return new Engine();
    }

    /* Implement service callback methods */
    private class Engine extends CanvasWatchFaceService.Engine {

        @Override
        public void onCreate(SurfaceHolder holder) {
            /* Initialize the watch plan */

        }

        @Override
        public void onPropertiesChanged(Bundle properties) {
            /* Get devices features (burn-in, low-bit ambient) */

        }

        @Override
        public void onTimeTick() {
            /* The time changed */

        }

        @Override
        public void onAmbientModeChanged(boolean isAmbientMode) {
            /* The wearable switched between modes */

        }

        @Override
        public void onDraw(Canvas canvas, Rect rect) {
            /* Draw your watch face */

        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            /* The watch face became visible or invisible */

        }
    }

}
