package com.example.proyectopc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReciever extends BroadcastReceiver

{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "SE EJECUTA",Toast.LENGTH_LONG).show();
    }

}