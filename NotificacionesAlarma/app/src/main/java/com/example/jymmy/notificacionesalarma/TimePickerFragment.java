package com.example.jymmy.notificacionesalarma;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    TextView time;
    AlarmManager planificarAlarma;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(),2, this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        time =(TextView) getActivity().findViewById(R.id.timeTv);
        //time.setText(""+hourOfDay+":"+minute);
        try
        {
            String hora_programada = new StringBuilder().append(hourOfDay).append(":0").append(minute) + " hrs";
            if(minute < 10)
            {
                time.setText("" + hora_programada);
            }else
            {
                hora_programada = new StringBuilder().append(hourOfDay).append(":").append(minute) + " hrs";
                time.setText("" + hora_programada);
            }
            Toast.makeText(getActivity(), "Tarea programada a las " + hora_programada.toString(), Toast.LENGTH_SHORT).show();
            planificarAlarma = (AlarmManager)getActivity().getSystemService(ALARM_SERVICE);
            Intent intent = new Intent(getActivity(), TareaProgramada.class);
            PendingIntent pi = PendingIntent.getService(getActivity(), 0, intent, 0);
            planificarAlarma.set(AlarmManager.RTC_WAKEUP, 0, pi);


                /*Intent intent = new Intent(getActivity(), TareaProgramada.class);
                getActivity().startService(intent);*/


        }catch(Exception ex)
        {
            System.out.println("Error al programar hora de tarea: " + ex.getMessage());
        }
    }
}