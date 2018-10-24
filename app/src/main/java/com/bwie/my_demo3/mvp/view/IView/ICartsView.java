package com.bwie.my_demo3.mvp.view.IView;


import com.bwie.my_demo3.mvp.model.bean.CartsBean;

public interface ICartsView extends IBaseView {

    void success(CartsBean cartsBean);
    void Error(String msg);
}
