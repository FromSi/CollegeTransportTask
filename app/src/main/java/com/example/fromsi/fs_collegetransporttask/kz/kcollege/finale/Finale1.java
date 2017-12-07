package com.example.fromsi.fs_collegetransporttask.kz.kcollege.finale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fromsi.fs_collegetransporttask.R;

import java.util.ArrayList;

/**
 * Created by fromsi on 04.12.17.
 */

public class Finale1 extends Fragment implements View.OnClickListener {
    private LinearLayout linearLayout;
    private Button optimal;
    private TextView textformula, textost1, textost2;
    private ViewGroup root;
    private int summ1, summ2;
    private int[] editTexts1, editTexts2;
    private int[][] arrayOt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.fragment_finale1, container, false);
        linearLayout = root.findViewById(R.id.otvet1);
        optimal = root.findViewById(R.id.optimal);
        textformula = root.findViewById(R.id.textformula);
        textost1 = root.findViewById(R.id.textost1);
        textost2 = root.findViewById(R.id.textost2);
        optimal.setOnClickListener(this);
        editTexts1 = getActivity().getIntent().getIntArrayExtra("editTexts1");
        editTexts2 = getActivity().getIntent().getIntArrayExtra("editTexts2");

        arrayOt = new int[editTexts1.length][editTexts2.length];
        for (int i = 0; i < editTexts1.length; i++) {
            arrayOt[i] = getActivity().getIntent().getIntArrayExtra("arryaOt" + i);
        }

//        arrayOt = getActivity().getIntent().getIntArrayExtra("arryaOt");
        summ1 = 0;
        summ2 = 0;
        for (int i = 0; i < editTexts1.length; i++) {
            summ1 += editTexts1[i];
        }
        for (int i = 0; i < editTexts2.length; i++) {
            summ2 += editTexts2[i];
        }
        if (summ1 != summ2) checkF(summ1, summ2);
        textformula.setText(getActivity().getIntent().getStringExtra("formula"));

        start();


        return root;
    }

    @Override
    public void onClick(View view) {
        ViewPager viewPager = getActivity().findViewById(R.id.vp2);
        viewPager.setCurrentItem(1);
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
                    if (arrayOt[k][j] == i)
                        if (editTexts1[j] > 0 && editTexts2[k] > 0) {
                            if (editTexts1[j] > editTexts2[k]) {
                                Log.d("MyLog", "C" + (j + 1) + (k + 1) + " " + (editTexts2[k]));
                                editTexts1[j] -= editTexts2[k];
                                editTexts2[k] = 0;
                            } else if (editTexts2[k] > editTexts1[j]) {
                                Log.d("MyLog", "C" + (j + 1) + (k + 1) + " " + (editTexts1[j]));
                                editTexts2[k] -= editTexts1[j];
                                editTexts1[j] = 0;
                            } else if (editTexts1[j] == editTexts2[k]){
                                Log.d("MyLog", "C" + (j + 1) + (k + 1) + " " + (editTexts1[j]));
                                editTexts2[k] = 0;
                                editTexts1[j] = 0;
                            }
                        }
                }
            }
        }
    }
}
