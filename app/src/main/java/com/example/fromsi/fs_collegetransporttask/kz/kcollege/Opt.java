package com.example.fromsi.fs_collegetransporttask.kz.kcollege;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fromsi.fs_collegetransporttask.R;

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
        booleanTest();
        checkAB();

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
}
