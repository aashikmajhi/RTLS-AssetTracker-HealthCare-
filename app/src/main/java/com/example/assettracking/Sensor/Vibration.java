package com.example.assettracking.Sensor;

import android.content.Context;
import android.os.Vibrator;

public class Vibration {
    public static void getVibration(Context context){
        Vibrator v =(Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        v.vibrate(250);
    }
}
