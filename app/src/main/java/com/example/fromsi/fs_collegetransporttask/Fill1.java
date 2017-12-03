package com.example.fromsi.fs_collegetransporttask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Fill1 extends Fragment implements View.OnClickListener {
    private ArrayList<EditText> editTexts1, editTexts2;
    private ViewGroup root;
    private LinearLayout ln1, ln2;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.fragment_fill1, container, false);
        editTexts1 = new ArrayList<>();
        editTexts2 = new ArrayList<>();
        ln1 = root.findViewById(R.id.ln1);
        ln2 = root.findViewById(R.id.ln2);
        button = root.findViewById(R.id.btn2);
        button.setOnClickListener(this);

        for (int i = 0; i < getActivity().getIntent().getIntExtra("np", 2); i++) {
            EditText editText;
            editText = new EditText(getActivity());
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
            editText.setHint("A" + (i + 1));
            editTexts1.add(editText);
            ln1.addView(editTexts1.get(i));
        }

        for (int i = 0; i < getActivity().getIntent().getIntExtra("np2", 2); i++) {
            EditText editText;
            editText = new EditText(getActivity());
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
            editText.setHint("B" + (i + 1));
            editTexts2.add(editText);
            ln2.addView(editTexts2.get(i));
        }
        return root;
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < getActivity().getIntent().getIntExtra("np", 2); i++) {
            if (editTexts1.get(i).getText().toString().isEmpty()) return;
        }
        for (int i = 0; i < getActivity().getIntent().getIntExtra("np2", 2); i++) {
            if (editTexts2.get(i).getText().toString().isEmpty()) return;
        }
        ViewPager viewPager = getActivity().findViewById(R.id.vp);
        viewPager.setCurrentItem(1);
    }
}
