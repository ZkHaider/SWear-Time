package com.zkhaider.sweartime.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;
import android.widget.Toast;

import com.zkhaider.sweartime.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;


/**
 * Created by Haider on 12/25/2014.
 */
public class SwearWatchFace extends WatchFaceActivity {

    private TextView mSaying, mHours, mMinutes, mAmOrPm;
    private Random random;
    public static final String[] mSayings = { "OH SHIT", "FUCK YEA",
            "SWEET",
            "WHAT\'S GOING ON?",
            "TAKE IT EASY MAN",
            "FUCK",
            "ALRIGHT LET\'S DO IT",
            "HOLY SHIT",
            "DAMN...",
            "FUCK. SHIT",
            "YEA",
            "DAMNIT",
            "ALRIGHT COOL",
            "YO DAWG",
            "WHAT THE FUCK",
            "MAN...",
            "UMMMM...",
            "THICK SOLID TIGHT",
            "BRAH",
            "HOLY FUCKIN HELL",
            "HMM... IT\'S",
            "BROSEPTOPOTAMUS",
            "FUCK SHIT BALLS",
            "WHAT THE FUCK",
            "I DUNNO...",
            "OH. WOW",
            "FUCKING SHIT",
            "LOOKING SEXY",
            "FUCK MAN",
            "I UNDERSTAND",
            "HELL YEA" };

    private final static IntentFilter INTENT_FILTER;

    static {
        INTENT_FILTER = new IntentFilter();
        INTENT_FILTER.addAction(Intent.ACTION_TIME_TICK);
        INTENT_FILTER.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        INTENT_FILTER.addAction(Intent.ACTION_TIME_CHANGED);
    }

    private final String TIME_FORMAT_HOUR_DISPLAYED = "hh";
    private final String TIME_FORMAT_MINUTES_DISPLAYED = "mm";
    private final String TIME_FORMAT_AMPM_DISPLAYED = "a";

    private BroadcastReceiver mTimeInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            mHours.setText(new SimpleDateFormat(TIME_FORMAT_HOUR_DISPLAYED)
                    .format(Calendar.getInstance().getTime()));
            mMinutes.setText(new SimpleDateFormat(TIME_FORMAT_MINUTES_DISPLAYED)
                    .format(Calendar.getInstance().getTime()));
            mAmOrPm.setText(new SimpleDateFormat(TIME_FORMAT_AMPM_DISPLAYED)
                    .format(Calendar.getInstance().getTime()));

            random = new Random();
            int index = random.nextInt(mSayings.length);
            mSaying.setText(mSayings[index]);
        }
    };

    @Override
    public void onScreenDim() {

    }

    @Override
    public void onScreenAwake() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mHours = (TextView) stub.findViewById(R.id.watch_time_hour);
                mMinutes = (TextView) stub.findViewById(R.id.watch_time_minutes);
                mAmOrPm = (TextView) stub.findViewById(R.id.watch_am_pm);
                mSaying = (TextView) stub.findViewById(R.id.saying);
                mTimeInfoReceiver.onReceive(SwearWatchFace.this, null);
                registerReceiver(mTimeInfoReceiver, INTENT_FILTER);
            }
        });
    }

    @Override
    public void onDisplayRemoved(int displayId) {

    }

    @Override
    public void onDisplayChanged(int displayId) {

    }

}
