package com.example.fromsi.fs_collegetransporttask.kz.kcollege;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

import com.example.fromsi.fs_collegetransporttask.R;
import com.example.fromsi.fs_collegetransporttask.kz.kcollege.finale.FinalePagerAdapter;


public class Finale extends FragmentActivity {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finale);
        viewPager = findViewById(R.id.vp2);
        pagerAdapter = new FinalePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }
}
