package com.example.beontime;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

import static com.example.beontime.setslots.populateSetDateText;

public class MyDateFragment extends DialogFragment implements
        DatePickerDialog.OnDateSetListener {
   @NonNull
   public Dialog onCreateDialog(Bundle savedInstanceState)
   {
       final Calendar calendar=Calendar.getInstance();
       int year= calendar.get(Calendar.YEAR);
       int month= calendar.get(Calendar.MONTH);
       int day= calendar.get(Calendar.DAY_OF_MONTH);

       return new DatePickerDialog(getActivity(),this,year,month,day);
   }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        populateSetDateText(year,month+1,dayOfMonth);

    }
}
