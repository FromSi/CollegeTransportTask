package com.example.fromsi.fs_collegetransporttask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
public class Fill2 extends Fragment {
    private int index1, index2;
    private ArrayList<EditText> editTexts1;
    private LinearLayout.LayoutParams params;
    private LinearLayout ll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_fill2, container, false);
        final int scale = (int) getActivity().getResources().getDimension(R.dimen.norm);
        index1 = 0;
        ll = root.findViewById(R.id.llmain);
        editTexts1 = new ArrayList<>();
        params = new LinearLayout.LayoutParams(scale, LinearLayout.LayoutParams.MATCH_PARENT);

        for (int i = 0; i < getActivity().getIntent().getIntExtra("np2", 2); i++) {
            index1++;
            index2 = 0;
            LinearLayout linearLayout = new LinearLayout(root.getContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setLayoutParams(params);
            for (int j = getActivity().getIntent().getIntExtra("np", 2)*i;
                 j < getActivity().getIntent().getIntExtra("np", 2)*(i+1); j++) {
                EditText editText;
                editText = new EditText(getActivity());
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                editText.setTextSize(getActivity().getResources().getDimension(R.dimen.textsize));
                index2++;
                editText.setHint("C"+index1+""+index2);
                editTexts1.add(editText);
                linearLayout.addView(editTexts1.get(j));
            }
            ll.addView(linearLayout);
        }
        return root;
    }
}
