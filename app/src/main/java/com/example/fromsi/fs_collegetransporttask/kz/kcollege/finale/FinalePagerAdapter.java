package com.example.fromsi.fs_collegetransporttask.kz.kcollege.finale;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by fromsi on 04.12.17.
 */

public class FinalePagerAdapter extends FragmentStatePagerAdapter {
    public FinalePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Finale1();
            case 1:
                return new Finale2();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
