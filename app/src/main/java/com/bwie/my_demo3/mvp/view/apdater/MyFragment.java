package com.bwie.my_demo3.mvp.view.apdater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyFragment extends FragmentPagerAdapter {

    public MyFragment(FragmentManager fm) {
        super(fm);
    }
    private ArrayList<Fragment> list;
    public  void  MyData(ArrayList<Fragment> list1){
        list=list1;
    }
    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
