package com.example.beontime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
Button btn_setslot;
Button btn_bookslot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_setslot=(Button)findViewById(R.id.btn_setslot);
        btn_bookslot=(Button)findViewById(R.id.btn_bookslot);
        btn_setslot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),setslots.class));
            }
        });

    }
}
