package com.example.fromsi.fs_collegetransporttask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fromsi.fs_collegetransporttask.kz.kcollege.Begin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.main1);
        b2 = findViewById(R.id.main2);
        b3 = findViewById(R.id.main3);
        b4 = findViewById(R.id.main4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main1:
                startActivity(new Intent(this, Begin.class));
                break;
            case R.id.main2:

                break;
            case R.id.main3:
                startActivity(new Intent(this, Help.class));
                break;
            case R.id.main4:
                startActivity(new Intent(this, About.class));
                break;
            default:
                break;
        }
    }
}
