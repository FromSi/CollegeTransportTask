package com.example.fromsi.fs_collegetransporttask.kz.kcollege.finale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fromsi.fs_collegetransporttask.R;

/**
 * Created by fromsi on 04.12.17.
 */

public class Finale1 extends Fragment {
    private ViewGroup root;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.fragment_finale1, container, false);
        return root;
    }
}
