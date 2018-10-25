package com.bwie.my_demo3.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.my_demo3.R;
import com.bwie.my_demo3.fragment.frament.One_BlankFragment;
import com.bwie.my_demo3.fragment.frament.Three_BlankFragment;
import com.bwie.my_demo3.fragment.frament.Two_BlankFragment;
import com.bwie.my_demo3.mvp.view.apdater.MyFragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFregment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_classify_fregment, container, false);
        tabLayout = view.findViewById(R.id.tab);
        viewPager = view.findViewById(R.id.viewppp);
        inuit();
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void inuit() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new One_BlankFragment());
        list.add(new Two_BlankFragment());
        list.add(new Three_BlankFragment());
        MyFragment myFragment = new MyFragment(getChildFragmentManager());
        myFragment.MyData(list);
        viewPager.setAdapter(myFragment);



        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("新书");
        tabLayout.getTabAt(1).setText("热门");
        tabLayout.getTabAt(2).setText("附近");


    }
}
