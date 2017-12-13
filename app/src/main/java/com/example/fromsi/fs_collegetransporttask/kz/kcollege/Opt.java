package com.example.fromsi.fs_collegetransporttask.kz.kcollege;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.example.fromsi.fs_collegetransporttask.R;

import java.util.ArrayList;

public class Opt extends AppCompatActivity {
    private int intT1;
    private int intT2;
    private int[] U;
    private boolean[] boolU;
    private boolean[] boolV;
    private int[] V;
    private int c = 0;
    private int intA[][];
    private int intB[][];
    private int intС[][];
    private boolean boolB[][];
    private int indexB = 0;
    private int intTest = 0;
    private int index = 1;
    private boolean bool = false;
    private int d = -1;
    private int T1beta;
    private int T2beta;

    private TextView t1, t2, t3, t4;
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private LinearLayout otvet2;
    private LinearLayout lnfinale1;
    private LinearLayout lnfinale2;
    private LinearLayout.LayoutParams sizefinale1;
    private Space space, space2, space3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt);
        intT1 = getIntent().getIntExtra("intT1", 2);
        intT2 = getIntent().getIntExtra("intT2", 2);
        boolB = new boolean[intT1][intT2];
        U = new int[intT1];
        boolU = new boolean[intT1];
        V = new int[intT2];
        boolV = new boolean[intT2];
        intA = new int[intT1][intT2];
        intB = new int[intT1][intT2];
        intС = new int[intT1][intT2];

        otvet2 = findViewById(R.id.otvet3);
        sizefinale1 = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.sizefinale1),
                (int) getResources().getDimension(R.dimen.sizefinale1));
        booleanTest();
        checkAB();
        otvetFix();

        for (int i = 0; i < intT1; i++) {
            for (int j = 0; j < intT2; j++) {
                if (boolB[i][j])
                    if (intB[i][j] != 0)
                        createotvet(i, j, intB[i][j]);
            }
        }


//        for (int i = 0; i < intT1; i++) {
//            for (int j = 0; j < intT2; j++) {
//                intС[j][i] = intA[j][i] - (V[j] + U[i]);
//                if (intA[j][i] - (V[j] + U[i])<=d){
//                    bool = true;
//                    d = intA[j][i] - (V[j] + U[i]);
//                    T1beta = i;
//
//                }
//            }
//        }


    }

    private void checkAB() {
        if (intT1 == intT2) {
            U[0] = 0;
            boolU[0] = true;
            for (int i = 0; i < intT2; i++) {
                if (boolB[i][0]) {
                    V[i] = intA[i][0];
                    boolV[i] = true;
                }
            }
            for (int i = 0; i < intT1; i++) {
                index = 1;
                for (int j = 0; j < index; j++) {
                    for (int k = 0; k < intT2; k++) {
                        if (boolB[k][i])
                            if (boolV[k] && !boolU[i]) {
                                U[i] = intA[k][i] - V[k];
                                boolU[i] = true;
                            } else if (!boolV[k] && boolU[i]) {
                                V[k] = intA[k][i] - U[i];
                                boolV[k] = true;
                            } else if (!boolV[k] && !boolU[i]) {
                                index++;
                            }
                    }
                }

            }
        } else if (intT1 < intT2) {
            U = new int[intT2];
            boolU = new boolean[intT2];
            V = new int[intT1];
            boolV = new boolean[intT1];
            U[0] = 0;
            boolU[0] = true;
//            for (int i = 0; i < intT2; i++) {
//                if (boolB[0][i]) {
//                    V[i] = intA[0][i];
//                    boolV[i] = true;
//                }
//            }
        } else if (intT1 > intT2) {
            U = new int[intT2];
            boolU = new boolean[intT2];
            V = new int[intT1];
            boolV = new boolean[intT1];
            V[0] = 0;
            boolV[0] = true;
        }
    }

    private void otvetFix() {
//        do {
        if (bool)
            for (int i = 1; i < intT1; i++) {
//            for (int j = 0; j < intT2; j++) {
                if (T1beta - i >= 0) {
                    if (boolB[T1beta - i][T2beta]) {
                        for (int j = 1; j < intT2; j++) {
                            if (T2beta - j > 0) {
                                if (boolB[T1beta - i][T2beta - j]) {


                                    int intMax = Math.min(intB[T1beta - i][T2beta], intB[T1beta][T2beta - j]);
                                    intB[T1beta][T2beta] += intMax;
                                    intB[T1beta - i][T2beta] -= intMax;
                                    intB[T1beta - i][T2beta - j] += intMax;
                                    intB[T1beta][T2beta - j] -= intMax;
                                }
                            } else if (intT2 > T2beta + j) {
                                if (boolB[T1beta - i][T2beta + j]) {
                                    int intMax = Math.min(intB[T1beta - i][T2beta], intB[T1beta][T2beta + j]);
                                    intB[T1beta][T2beta] += intMax;
                                    intB[T1beta - i][T2beta] -= intMax;
                                    intB[T1beta - i][T2beta + j] += intMax;
                                    intB[T1beta][T2beta + j] -= intMax;
                                }
                            }
                        }
                    }
                }
                if (intT1 > T1beta + i) {
                    if (boolB[T1beta + i][T2beta]) {
                        for (int j = 1; j < intT2; j++) {
                            if (T2beta - j > 0) {
                                if (boolB[T1beta + i][T2beta - j]) {
                                    int intMax = Math.min(intB[T1beta + i][T2beta], intB[T1beta][T2beta - j]);
                                    intB[T1beta][T2beta] += intMax;
                                    intB[T1beta + i][T2beta] -= intMax;
                                    intB[T1beta + i][T2beta - j] += intMax;
                                    intB[T1beta][T2beta - j] -= intMax;
                                }
                            } else if (intT2 > T2beta + j) {
                                if (boolB[T1beta + i][T2beta + j]) {
                                    int intMax = Math.min(intB[T1beta + i][T2beta], intB[T1beta][T2beta + j]);
                                    intB[T1beta][T2beta] += intMax;
                                    intB[T1beta + i][T2beta] -= intMax;
                                    intB[T1beta + i][T2beta + j] += intMax;
                                    intB[T1beta][T2beta + j] -= intMax;
                                }
                            }
                        }
                    }
                }
//            }
            }
        bool = false;
        for (int i = 0; i < intT1; i++) {
            for (int j = 0; j < intT2; j++) {
                intС[i][j] = intA[i][j] - (V[i] + U[j]);
                if (intA[i][j] - (V[i] + U[j]) <= d) {
                    bool = true;
                    d = intA[i][j] - (V[i] + U[j]);
                    T1beta = i;
                    T2beta = j;
                }
            }
        }
//        } while (bool);
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
        if (intT1 == intT2) {
            for (int i = 0; i < intT1; i++) {
                int intBtest = getIntent().getIntExtra("intB", 2);
                if (intBtest > indexB) {
                    if (intT1 >= intT2 && !boolB[i][c]) {
                        boolB[i][c] = true;
                        indexB++;
                    } else if (intT1 < intT2 && !boolB[c][i]) {
                        boolB[c][i] = true;
                        indexB++;
                    }
                }
            }
        } else if (intT1 < intT2) {
            for (int i = 0; i < intT2; i++) {
                int intBtest = getIntent().getIntExtra("intB", 2);
                if (intBtest > indexB) {
                    if (intT1 >= intT2 && !boolB[i][c]) {
                        boolB[i][c] = true;
                        indexB++;
                    } else if (intT1 < intT2 && !boolB[c][i]) {
                        boolB[c][i] = true;
                        indexB++;
                    }
                }
            }
        } else if (intT1 > intT2) {
            //1231312313132132131
            for (int i = 0; i < intT1; i++) {
                int intBtest = getIntent().getIntExtra("intB", 2);
                if (intBtest > indexB) {
                    if (intT1 > intT2 && !boolB[i][c]) {
                        boolB[i][c] = true;
                        indexB++;
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
