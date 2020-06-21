package com.example.beontime;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

import static com.example.beontime.setslots.populateSetBeginTime;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog
.OnTimeSetListener{
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Calendar c= Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute=c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(),this,hour,minute,
                android.text.format.DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {
        populateSetBeginTime(hour,minute+1);

    }
}
