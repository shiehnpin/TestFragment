package com.enping.testfragment;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {


    private int tag;

    public BlankFragment() {
        // Required empty public constructor
    }


    public static BlankFragment newInstance(int i) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt("TAG",i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tag = getArguments().getInt("TAG");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_blank, container, false);
        ((Button)view.findViewById(R.id.button)).setText("TAG"+tag);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack((tag+1)+"")
                        .replace(R.id.activity_main,BlankFragment.newInstance(tag+1),(tag+1)+"")
                        .commit();
                view.setVisibility(View.GONE);
            }
        });
        return view;
    }

}
