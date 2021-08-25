package com.example.jymmy.notificacionesalarma;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;

public class RingtonPlayService extends Service {
    MediaPlayer media_song;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        media_song = MediaPlayer.create(this, R.raw.pizza);
        media_song.start();
        return START_STICKY;




}
    public void onCreate(){
        super.onCreate();
    }

    public void initMusicPlayer(){
        //set player properties
        media_song.setWakeMode(getApplicationContext(),
                PowerManager.PARTIAL_WAKE_LOCK);
        media_song.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
