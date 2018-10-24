package com.bwie.my_demo3.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.my_demo3.mvp.view.IView.ICartsView;
import com.bwie.my_demo3.R;
import com.bwie.my_demo3.mvp.view.apdater.CartAdapter;
import com.bwie.my_demo3.mvp.model.bean.CartsBean;
import com.bwie.my_demo3.mvp.model.inter.CartAllCheckLinstener;
import com.bwie.my_demo3.mvp.present.CartsPresent;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCartFragment extends Fragment implements ICartsView,CartAllCheckLinstener {


    @BindView(R.id.xRecycler_View)
    XRecyclerView xRecyclerView;
    @BindView(R.id.Allcheck_box)
    CheckBox AllcheckBox;
    @BindView(R.id.sumprice)
    TextView sumprice;
    @BindView(R.id.buy)
    TextView buy;
    Unbinder unbinder;
    private CartsPresent cartsPresent;
    private List<CartsBean.DataBean> list;
    private CartAdapter cartAdapter;

    public ShopCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shop_cart, container, false);
        initData();
        unbinder = ButterKnife.bind(this, inflate);
        initView();
        return inflate;

    }

    private void initView() {
        list = new ArrayList<>();
        xRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        AllcheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AllcheckBox.isChecked()) {
                    if (list != null && list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).setSelected(true);
                            for (int i1 = 0; i1 < list.get(i).getList().size(); i1++) {
                                list.get(i).getList().get(i1).setSelected(true);
                            }
                        }
                    }
                } else {
                    if (list != null && list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).setSelected(false);
                            for (int i1 = 0; i1 < list.get(i).getList().size(); i1++) {
                                list.get(i).getList().get(i1).setSelected(false);
                            }
                        }
                    }
                }
                cartAdapter.notifyDataSetChanged();
                totalPrice();
            }
        });
    }

    private void totalPrice() {


        double totalprice = 0;

        for (int i = 0; i < cartAdapter.getCartList().size(); i++) {
            for (int i1 = 0; i1 < cartAdapter.getCartList().get(i).getList().size(); i1++) {
                if (cartAdapter.getCartList().get(i).getList().get(i1).isSelected()) {
                    CartsBean.DataBean.ListBean listBean = cartAdapter.getCartList().get(i).getList().get(i1);
                    totalprice += listBean.getBargainPrice() * listBean.getTotalNum();
                }
            }
        }
        sumprice.setText("" + totalprice);
    }

    private void initData() {

        cartsPresent = new CartsPresent(this);
        cartsPresent.getCarts("71");
    }

    @Override
    public void success(CartsBean cartsBean) {


        if(cartsBean!=null&&cartsBean.getData()!=null){
            list = cartsBean.getData();
            xRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
            cartAdapter = new CartAdapter(getActivity(),list);
            xRecyclerView.setAdapter(cartAdapter);
        }else {

            Toast.makeText(getActivity(),"没有数据",Toast.LENGTH_LONG).show();
        }
        cartAdapter.setCartAllCheckLinstener(this);

    }

    @Override
    public void notifyAllCheckboxStatus() {

        StringBuilder stringBuilder = new StringBuilder();
        if (cartAdapter != null) {
            for (int i = 0; i < cartAdapter.getCartList().size(); i++) {
                stringBuilder.append(cartAdapter.getCartList().get(i).isSelected());
                for (int i1 = 0; i1 < cartAdapter.getCartList().get(i).getList().size(); i1++) {
                    stringBuilder.append(cartAdapter.getCartList().get(i).getList().get(i1).isSelected());
                }
            }
        }
        if (stringBuilder.toString().contains("false")) {
            AllcheckBox.setChecked(false);
        } else {
            AllcheckBox.setChecked(true);
        }
        totalPrice();
    }

    @Override
    public void Error(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
