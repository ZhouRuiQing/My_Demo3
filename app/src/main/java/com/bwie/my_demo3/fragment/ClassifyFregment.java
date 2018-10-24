package com.bwie.my_demo3.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.my_demo3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFregment extends Fragment {


    public ClassifyFregment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classify_fregment, container, false);
    }

}
