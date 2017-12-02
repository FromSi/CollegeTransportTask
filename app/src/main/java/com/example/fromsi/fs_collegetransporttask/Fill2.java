package com.example.fromsi.fs_collegetransporttask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by fromsi on 02.12.17.
 */

public class Fill2 extends Fragment {
    private LinearLayout linearLayout;
    private ArrayList<LinearLayout> linearLayouts;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_fill2, container, false);
        linearLayouts = new ArrayList<>();
        linearLayout = new LinearLayout(root.getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < 5; i++) {
            linearLayouts.add(linearLayout);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                linearLayouts.get(i).addView(new Button(root.getContext()));
            }
        }

        return root;
    }
}
