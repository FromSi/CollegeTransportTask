package com.example.fromsi.fs_collegetransporttask;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Fill extends FragmentActivity {
    private ArrayList<EditText> editTexts1, editTexts2;
    private LinearLayout ln1, ln2;

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        viewPager = findViewById(R.id.vp);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
//        editTexts1 = new ArrayList<>();
//        editTexts2 = new ArrayList<>();
//        ln1 = findViewById(R.id.ln1);
//        ln2 = findViewById(R.id.ln2);
//
//
//        for (int i = 0; i < getIntent().getIntExtra("np", 2); i++) {
//            EditText editText;
//            editText = new EditText(this);
//            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
//            editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
//            editText.setHint("A"+(i+1));
//            editTexts1.add(editText);
//            ln1.addView(editTexts1.get(i));
//        }
//
//        for (int i = 0; i < getIntent().getIntExtra("np2", 2); i++) {
//            EditText editText;
//            editText = new EditText(this);
//            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
//            editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
//            editText.setHint("B"+(i+1));
//            editTexts2.add(editText);
//            ln2.addView(editTexts2.get(i));
//        }



    }


}
