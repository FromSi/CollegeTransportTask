package com.example.fromsi.fs_collegetransporttask.kz.kcollege.finale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fromsi.fs_collegetransporttask.R;

/**
 * Created by fromsi on 04.12.17.
 */

public class Finale1 extends Fragment implements View.OnClickListener{
    private LinearLayout linearLayout;
    private Button optimal;
    private TextView textformula, textost1, textost2;
    private ViewGroup root;
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

        textformula.setText(getActivity().getIntent().getStringExtra("formula"));

        return root;
    }

    @Override
    public void onClick(View view) {
        ViewPager viewPager = getActivity().findViewById(R.id.vp2);
        viewPager.setCurrentItem(1);
    }
}
