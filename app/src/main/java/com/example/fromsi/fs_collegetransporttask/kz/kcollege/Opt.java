package com.example.fromsi.fs_collegetransporttask.kz.kcollege;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.fromsi.fs_collegetransporttask.R;

public class Opt extends AppCompatActivity {
    private int intT1;
    private int intT2;
    private int[] U;
    private int[] V;
    private int c = 0;
    private int intA[][];
    private int intB[][];
    private boolean boolB[][];
    private int indexB = 0;
    private int intTest = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt);
        intT1 = getIntent().getIntExtra("intT1", 2);
        intT2 = getIntent().getIntExtra("intT2", 2);
        boolB = new boolean[intT1][intT2];
        U = new int[intT1];
        V = new int[intT2];
        intA = new int[intT1][intT2];
        intB = new int[intT1][intT2];
        booleanTest();

        if (intT1 >= intT2) {
            U[0] = 0;
            for (int i = 0; i < intT1; i++) {
                for (int j = 0; j < intT2; j++) {
//                    if (boolB[i][j] == true)
//                    if (i == 0){
//                        V[j] = intA[i][j];
//                    } else {
//                        U[i] = intA[i][j] - V[j];
//                    }
                }
            }
        } else if (intT1 < intT2) {
            V[0] = 0;
            for (int i = 0; i < intT2; i++) {
                for (int j = 0; j < intT1; j++) {
                    if (!((i > 0)&&(j > 0))){

                    }
                }
            }
        }


    }

    private void booleanTest() {
        for (int i = 0; i < intT1; i++) {
            intA[i] = getIntent().getIntArrayExtra("intA" + i);
            intB[i] = getIntent().getIntArrayExtra("intB" + i);
        }

        for (int i = 0; i < intT1; i++) {
            int intTest2 = 0;
            for (int j = 0; j < intT2; j++) {
                if (intB[i][j] > 0) {
                    boolB[i][j] = true;
                    intTest2++;
                    indexB++;
                    if (intTest2 > intTest) {
                        intTest = intTest2;
                        c = i;
                    }
                } else {
                    boolB[i][j] = false;
                }
            }
        }
        for (int i = 0; i < intT1; i++) {
            if (getIntent().getIntExtra("intB", 2) > indexB) {
                if (intT1 >= intT2 && boolB[c][i] == false) {
                    boolB[c][i] = true;
                    indexB++;
                } else if (intT1 < intT2 && boolB[i][c] == false) {
                    boolB[i][c] = true;
                    indexB++;
                }

            }
        }
    }
}
