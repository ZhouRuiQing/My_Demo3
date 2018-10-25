package com.bwie.my_demo3.fragment.frament;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.my_demo3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class One_BlankFragment extends Fragment {


    public One_BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one__blank, container, false);
    }

}
