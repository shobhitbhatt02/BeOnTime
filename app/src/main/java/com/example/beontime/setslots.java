package com.example.beontime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class setslots extends AppCompatActivity {
    public static TextView dateText;
    public static TextView beginText;
    public static TextView endText;
    Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setslots);
        dateText=(TextView)findViewById(R.id.dateTexView);
        beginText=(TextView)findViewById(R.id.BeginTimeTexView);
        endText=(TextView)findViewById(R.id.EndTimeTexView);
        btn_save=(Button) findViewById(R.id.btn_save);

    }

    public void btn_datepicker(View view) {
        DialogFragment fragment=new MyDateFragment();
        fragment.show(getSupportFragmentManager(),"date picker");
    }
    public static void populateSetDateText(int year,int month, int day)
    {
        dateText.setText(day+"/"+month+"/"+year);

    }

    public void btn_begintimepicker(View view) {
        DialogFragment timePicker= new TimePickerFragment();
        timePicker.show(getSupportFragmentManager(),"time picker");
    }


    public static void populateSetBeginTime(int hourofday,int minute)
    {
        beginText.setText(hourofday+":"+minute);

    }



    public void btn_endtimepicker(View view) {
        DialogFragment t= new EndTimePickerFragment();
        t.show(getSupportFragmentManager(),"time picker");
    }
    public static void populateSetEndTime(int hourofday,int minute)
    {
        endText.setText(hourofday+":"+minute);

    }


    public void btn_save(View view) {
        HashMap<String,Object> map =new HashMap<>();
        map.put("date",dateText.getText().toString());
        map.put("begintime",beginText.getText().toString());
        map.put("endtime",endText.getText().toString());

        FirebaseDatabase .getInstance().getReference().child("TimeSlots").push()
                .setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.i("ssssss","oncomplete");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("sssssk","onfaliure"+e.toString());
            }

        });
        Toast.makeText(setslots.this, "Slot Booked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),Home.class));

    }
}
