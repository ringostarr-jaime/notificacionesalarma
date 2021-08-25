package com.example.jymmy.notificacionesalarma;


import android.app.DialogFragment;

import android.app.NotificationManager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{

Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =(Button)findViewById(R.id.donow);
    }

    public void iniciar(View v)
    {
    //establecer();

      Intent intent = new Intent(this, HelloService.class);
        startService(intent);

    }

    public void establecer()
    {
        // Patrón de vibración: 1 segundo vibra, 0.5 segundos para, 1 segundo vibra
        long[] pattern = new long[]{1000,500,1000};

        // Sonido por defecto de notificaciones, podemos usar otro
        Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder note = new NotificationCompat.Builder(getApplicationContext());
        note.setSmallIcon(android.R.drawable.sym_def_app_icon).setContentTitle("Notificacion").setContentText("El autobus se encuentra cerca de ti")
                .setTicker("Notificacion").setColor(Color.BLACK).setSound(defaultSound).setVibrate(pattern);

        NotificationManager manager1 = (NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        manager1.notify(1,note.build());

    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }


}
