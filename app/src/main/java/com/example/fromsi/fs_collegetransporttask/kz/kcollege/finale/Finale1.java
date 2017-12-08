package com.example.fromsi.fs_collegetransporttask.kz.kcollege.finale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fromsi.fs_collegetransporttask.R;

import java.util.ArrayList;

public class Finale1 extends Fragment implements View.OnClickListener {
    private Button optimal;
    private TextView textformula, textost1, textost2;
    private int summ1, summ2;
    private int[] editTexts1, editTexts2;
    private int[][] arrayOt;

    private TextView t1,t2;
    private ImageView imageView;
    private LinearLayout otvet2;
    private LinearLayout lnfinale1;
    private LinearLayout lnfinale2;
    private LinearLayout.LayoutParams sizefinale1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_finale1, container, false);
        optimal = root.findViewById(R.id.optimal);
        textformula = root.findViewById(R.id.textformula);
        textost1 = root.findViewById(R.id.textost1);
        textost2 = root.findViewById(R.id.textost2);
        otvet2 = root.findViewById(R.id.otvet2);
        sizefinale1 = new LinearLayout.LayoutParams((int) getActivity().getResources().getDimension(R.dimen.sizefinale1),
                (int) getActivity().getResources().getDimension(R.dimen.sizefinale1));
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
//        final int textsizefinale1 = (int) getActivity().getResources().getDimension(R.dimen.textsizefinale1);
//        final int alig1 = (int) getActivity().getResources().getDimension(R.dimen.alig1);
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < editTexts1.length; j++) {
                for (int k = 0; k < editTexts2.length; k++) {
                    if (arrayOt[k][j] == i)
                        if (editTexts1[j] > 0 && editTexts2[k] > 0) {
                            if (editTexts1[j] > editTexts2[k]) {
                                createotvet(j,k,editTexts2[k]);

                                Log.d("MyLog", "C" + (j + 1) + (k + 1) + " " + (editTexts2[k]));
                                editTexts1[j] -= editTexts2[k];
                                editTexts2[k] = 0;
                            } else if (editTexts2[k] > editTexts1[j]) {
                                createotvet(j,k,editTexts1[j]);

                                Log.d("MyLog", "C" + (j + 1) + (k + 1) + " " + (editTexts1[j]));
                                editTexts2[k] -= editTexts1[j];
                                editTexts1[j] = 0;
                            } else if (editTexts1[j] == editTexts2[k]){
                                createotvet(j,k,editTexts1[j]);

                                Log.d("MyLog", "C" + (j + 1) + (k + 1) + " " + (editTexts1[j]));
                                editTexts2[k] = 0;
                                editTexts1[j] = 0;
                            }
                        }
                }
            }
        }
    }

    public void createotvet(int j, int k , int a){
        if (((k+1) % 2) == 1) {
            lnfinale1 = new LinearLayout(getContext());

            lnfinale1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    (int) getActivity().getResources().getDimension(R.dimen.sizefinale2)));
            otvet2.addView(lnfinale1);
        }
        lnfinale2 = new LinearLayout(getContext());
        lnfinale2.setLayoutParams(new LinearLayout.LayoutParams((int) getActivity().getResources().getDimension(R.dimen.sizefinale2),
                LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
        lnfinale2.setGravity(Gravity.CENTER);

        t1 = new TextView(getContext());
        t2 = new TextView(getContext());
        imageView = new ImageView(getContext());

        t1.setLayoutParams(new LinearLayout.LayoutParams((int) getActivity().getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
        t2.setLayoutParams(new LinearLayout.LayoutParams((int) getActivity().getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
        imageView.setLayoutParams(new LinearLayout.LayoutParams((int) getActivity().getResources().getDimension(R.dimen.sizefinale3),
                LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));

        t1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        t2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        imageView.setLayoutParams(sizefinale1);

        t1.setTextSize(getActivity().getResources().getDimension(R.dimen.textsizefinale1));
        t2.setTextSize(getActivity().getResources().getDimension(R.dimen.textsizefinale1));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.car));

        t1.setText(String.valueOf("C" + (j + 1) + (k + 1)));
        t2.setText(String.valueOf(a));

        lnfinale2.addView(imageView);
        lnfinale2.addView(t1);
        lnfinale2.addView(t2);

        lnfinale1.addView(lnfinale2);


    }
}
