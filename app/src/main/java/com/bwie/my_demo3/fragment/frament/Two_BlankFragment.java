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
public class Two_BlankFragment extends Fragment {


    public Two_BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two__blank, container, false);
    }

}
