package com.bwie.my_demo3.mvp.model;

import com.bwie.my_demo3.mvp.model.bean.CartsBean;
import com.bwie.my_demo3.utils.HttpUtils;

import io.reactivex.Observable;

public class ModelCarts {

    public Observable<CartsBean> getCarts(String uid){

        return HttpUtils.getInstance().api.getCarts(uid);
    }
}
