package com.example.fromsi.fs_collegetransporttask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Fill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);
        Toast.makeText(this, getIntent().getIntExtra("np",0)+" "+getIntent().getIntExtra("np2",0), Toast.LENGTH_SHORT).show();
    }
}