package com.bwie.my_demo3.mvp.view.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.my_demo3.R;
import com.bwie.my_demo3.mvp.view.My_add_reduce;

class ProductViewHoder extends RecyclerView.ViewHolder {

    public CheckBox ProcuctCheckbox;
    public ImageView productIcon;
    public TextView tv_name;
    public TextView price;
    public My_add_reduce myAddReduce;

    public ProductViewHoder(View itemView) {
        super(itemView);

        ProcuctCheckbox = itemView.findViewById(R.id.ProcuctCheckbox);
        productIcon = itemView.findViewById(R.id.product_icon);
        tv_name = itemView.findViewById(R.id.tv_product_name);
        price = itemView.findViewById(R.id.price);
        myAddReduce = itemView.findViewById(R.id.jiajianqi);


    }
}