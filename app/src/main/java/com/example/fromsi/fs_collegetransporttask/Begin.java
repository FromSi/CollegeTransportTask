package com.example.fromsi.fs_collegetransporttask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class Begin extends AppCompatActivity {
    private NumberPicker np,np2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        np = findViewById(R.id.np);
        np2 = findViewById(R.id.np2);
        b1 = findViewById(R.id.btn);

        np.setMaxValue(10);
        np2.setMaxValue(10);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Begin.this, Fill.class);
                intent.putExtra("np",np.getValue());
                intent.putExtra("np2",np2.getValue());
                startActivity(intent);
            }
        });

    }
}
