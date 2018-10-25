package com.bwie.my_demo3.utils;


import com.bwie.my_demo3.mvp.model.bean.CartsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

  /*@GET("product/searchProducts")
    Observable<UiBean> getdata(@Query("keywords") String keywords, @Query("page") int page, @Query("sort") String sort);
    @GET("home/getHome")
    Observable<HomeBean> gethome();
    @GET("product/getProductCatagory")
    Observable<ProductCatagory> getProduct(@Query("cid") String cid);*/
    @GET("product/getCarts")
    Observable<CartsBean> getCarts(@Query("uid") String uid);
   /* @GET("user/login")
    Observable<LoginBean> getLogin(@Query("mobile") String mobile, @Query("password") String password);
    @GET("user/reg")
    Observable<UserReg> getReg(@Query("mobile") String mobile, @Query("password") String password);*/
}
