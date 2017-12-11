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
import android.widget.Space;
import android.widget.TextView;

import com.example.fromsi.fs_collegetransporttask.R;

import java.util.ArrayList;

public class Fin extends AppCompatActivity implements View.OnClickListener {
    private Button optimal;
    private TextView textost1, textost2;
    private int summ1, summ2;
    private int[] editTexts1, editTexts2;
    private int[][] arrayOt, intB;

    private int index = 0;

    private TextView t1, t2, t3, t4;
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private LinearLayout otvet2;
    private LinearLayout lnfinale1;
    private LinearLayout lnfinale2;
    private LinearLayout.LayoutParams sizefinale1;
    private ArrayList<LinearLayout> linearLayouts;
    private Space space, space2, space3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        optimal = findViewById(R.id.optimal);
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

        lnfinale1 = new LinearLayout(this);
        lnfinale1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(R.dimen.sizefinale2)));
        otvet2.addView(lnfinale1);

        space = new Space(this);
        space2 = new Space(this);
        space3 = new Space(this);
        space.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));
        space2.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
        space3.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));

        t1 = new TextView(this);
        t2 = new TextView(this);
        t3 = new TextView(this);
        t4 = new TextView(this);
        imageView = new ImageView(this);
        imageView2 = new ImageView(this);
        imageView3 = new ImageView(this);
        t1.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
        t2.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
        t3.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
        t4.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
        imageView.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));
        imageView2.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));
        imageView3.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));
        t1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        t2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        t3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        t4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        imageView.setLayoutParams(sizefinale1);
        imageView2.setLayoutParams(sizefinale1);
        imageView3.setLayoutParams(sizefinale1);
        t1.setTextSize(getResources().getDimension(R.dimen.textsizefinale1));
        t2.setTextSize(getResources().getDimension(R.dimen.textsizefinale1));
        t3.setTextSize(getResources().getDimension(R.dimen.textsizefinale1));
        t4.setTextSize(getResources().getDimension(R.dimen.textsizefinale1));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.car));
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.storage));
        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.shop));

//        t1.setText(String.valueOf("C" + (k + 1) + (j + 1)));
        t1.setText(String.valueOf(k + 1));
        t2.setText(String.valueOf('-'));
        t3.setText(String.valueOf(j + 1));
        t4.setText(String.valueOf(a));

        lnfinale2 = new LinearLayout(this);
        lnfinale2.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale2),
                LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
        lnfinale2.setGravity(Gravity.CENTER);
        lnfinale2.addView(imageView2);
        lnfinale2.addView(t1);
        lnfinale2.addView(t2);
        lnfinale2.addView(t3);
        lnfinale2.addView(imageView3);
        lnfinale1.addView(space3);
        lnfinale1.addView(lnfinale2);
        lnfinale1.addView(space);

        lnfinale2 = new LinearLayout(this);
        lnfinale2.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale2),
                LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
        lnfinale2.setGravity(Gravity.CENTER);
        lnfinale2.addView(imageView);
        lnfinale2.addView(t4);
        lnfinale2.addView(space2);
        lnfinale1.addView(lnfinale2);
    }
}
