package com.example.fromsi.fs_collegetransporttask.kz.kcollege;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.example.fromsi.fs_collegetransporttask.R;
import com.example.fromsi.fs_collegetransporttask.kz.kcollege.Finale;
import com.example.fromsi.fs_collegetransporttask.kz.kcollege.OnDataPass;
import com.example.fromsi.fs_collegetransporttask.kz.kcollege.fill.ScreenSlidePagerAdapter;

import java.util.ArrayList;

public class Fill extends FragmentActivity implements OnDataPass {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private int[] editTexts1, editTexts2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);
        viewPager = findViewById(R.id.vp);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    @Override
    public void onDataPass1(ArrayList<EditText> editTexts1, ArrayList<EditText> editTexts2) {
        this.editTexts1 = new int[editTexts1.size()];
        this.editTexts2 = new int[editTexts2.size()];
        for (int i = 0; i < editTexts1.size(); i++) {
            this.editTexts1[i] = Integer.parseInt(editTexts1.get(i).getText().toString());
        }
        for (int i = 0; i < editTexts2.size(); i++) {
            this.editTexts2[i] = Integer.parseInt(editTexts2.get(i).getText().toString());
        }
    }

    @Override
    public void onDataPass2(String formula, int[][] arryaOt) {
        Intent intent = new Intent(this, Finale.class);

        for (int i = 0; i < editTexts1.length; i++) {
                intent.putExtra("arryaOt"+i, arryaOt[i]);
        }

        intent.putExtra("formula", formula);
//        intent.putExtra("arryaOt", arryaOt);
        intent.putExtra("np", arryaOt);
        intent.putExtra("np2", arryaOt);
        intent.putExtra("editTexts1", editTexts1);
        intent.putExtra("editTexts2", editTexts2);
        startActivity(intent);
    }
}
