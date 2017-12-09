package com.example.fromsi.fs_collegetransporttask.kz.kcollege;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fromsi.fs_collegetransporttask.R;

import java.util.ArrayList;

public class Fin extends AppCompatActivity implements View.OnClickListener {
    private Button optimal;
    private TextView textformula, textost1, textost2;
    private int summ1, summ2;
    private int[] editTexts1, editTexts2;
    private int[][] arrayOt, intB;

    private int index = 0;

    private TextView t1, t2;
    private ImageView imageView;
    private LinearLayout otvet2;
    private LinearLayout lnfinale1;
    private LinearLayout lnfinale2;
    private LinearLayout.LayoutParams sizefinale1;
    private ArrayList<LinearLayout> linearLayouts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        optimal = findViewById(R.id.optimal);
        textformula = findViewById(R.id.textformula);
        textost1 = findViewById(R.id.textost1);
        textost2 = findViewById(R.id.textost2);
        otvet2 = findViewById(R.id.otvet2);
        sizefinale1 = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale1),
                (int) getResources().getDimension(R.dimen.sizefinale1));
        optimal.setOnClickListener(this);
        editTexts1 = getIntent().getIntArrayExtra("editTexts1");
        editTexts2 = getIntent().getIntArrayExtra("editTexts2");
        intB = new int[editTexts1.length][editTexts2.length];
        arrayOt = new int[editTexts1.length][editTexts2.length];
        for (int i = 0; i < editTexts1.length; i++) {
            arrayOt[i] = getIntent().getIntArrayExtra("arryaOt" + i);
        }
        summ1 = 0;
        summ2 = 0;
        for (int i = 0; i < editTexts1.length; i++) {
            summ1 += editTexts1[i];
        }
        for (int i = 0; i < editTexts2.length; i++) {
            summ2 += editTexts2[i];
        }
        if (summ1 != summ2) checkF(summ1, summ2);
        textformula.setText(getIntent().getStringExtra("formula"));
        start();

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Opt.class);

        for (int i = 0; i < editTexts1.length; i++) {
            intent.putExtra("intA" + i, arrayOt[i]);
        }

        for (int i = 0; i < editTexts1.length; i++) {
            intent.putExtra("intB" + i, intB[i]);
        }
        intent.putExtra("intT1", editTexts1.length);
        intent.putExtra("intT2", editTexts2.length);
        int intB = getIntent().getIntExtra("intB", 2);
        intent.putExtra("intB", intB);
        startActivity(intent);
    }

    public void checkF(int a, int b) {
        if (a > b) {
            textost1.setText(String.valueOf(a - b));
        } else if (a < b) {
            textost2.setText(String.valueOf(b - a));
        }
    }

    public void start() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < editTexts1.length; j++) {
                for (int k = 0; k < editTexts2.length; k++) {
                    if (arrayOt[j][k] == i)
                        if (editTexts1[j] > 0 && editTexts2[k] > 0) {
                            if (editTexts1[j] > editTexts2[k]) {
                                createotvet(j, k, editTexts2[k]);
                                index++;
                                intB[j][k] = editTexts2[k];
                                Log.d("MyLog", "C" + (k + 1) + (j + 1) + " " + (editTexts2[k]));
                                editTexts1[j] -= editTexts2[k];
                                editTexts2[k] = 0;
                            } else if (editTexts2[k] > editTexts1[j]) {
                                createotvet(j, k, editTexts1[j]);
                                index++;
                                intB[j][k] = editTexts1[j];
                                Log.d("MyLog", "C" + (k + 1) + (j + 1) + " " + (editTexts1[j]));
                                editTexts2[k] -= editTexts1[j];
                                editTexts1[j] = 0;
                            } else if (editTexts1[j] == editTexts2[k]) {
                                createotvet(j, k, editTexts1[j]);
                                index++;
                                intB[j][k] = editTexts1[j];
                                Log.d("MyLog", "C" + (k + 1) + (j + 1) + " " + (editTexts1[j]));
                                editTexts2[k] = 0;
                                editTexts1[j] = 0;
                            }
                        }
                }
            }
        }
    }

    public void createotvet(int j, int k, int a) {
        if (((index + 1) % 2) == 1) {
            lnfinale1 = new LinearLayout(this);
            linearLayouts = new ArrayList<>();
            lnfinale1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    (int) getResources().getDimension(R.dimen.sizefinale2)));
            otvet2.addView(lnfinale1);
            for (int i = 0; i < 2; i++) {
                lnfinale2 = new LinearLayout(this);
                lnfinale2.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale2),
                        LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                lnfinale2.setGravity(Gravity.CENTER);
                linearLayouts.add(lnfinale2);
            }
            lnfinale1.addView(linearLayouts.get((index + 1) % 2));
            lnfinale1.addView(linearLayouts.get((index + 2) % 2));
        }
        t1 = new TextView(this);
        t2 = new TextView(this);
        imageView = new ImageView(this);
        t1.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
        t2.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
        imageView.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));
        t1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        t2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        imageView.setLayoutParams(sizefinale1);
        t1.setTextSize(getResources().getDimension(R.dimen.textsizefinale1));
        t2.setTextSize(getResources().getDimension(R.dimen.textsizefinale1));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.car));
        t1.setText(String.valueOf("C" + (k + 1) + (j + 1)));
        t2.setText(String.valueOf(a));
        linearLayouts.get((index + 1) % 2).addView(imageView);
        linearLayouts.get((index + 1) % 2).addView(t1);
        linearLayouts.get((index + 1) % 2).addView(t2);
    }
}
