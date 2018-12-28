package com.example.mania.bikerentingapp;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class WalletFragment extends Fragment {

    private Button button;      //充值按钮
    private ImageView iv_cardpackage,iv_yearcard,iv_coupon; //卡包，年卡，优惠券
    private TextView textView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wallet,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.tv_money);
        button = view.findViewById(R.id.button);
        iv_cardpackage = view.findViewById(R.id.iv_cardpackage);
        iv_yearcard = view.findViewById(R.id.iv_yearcard);
        iv_coupon = view.findViewById(R.id.iv_coupon);

        //Bmob初始化
        Bmob.initialize(getActivity(),"2546cdcbd73f5fc75fbf6c06802cdf87");

        //充值事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RechargeActivity.class);
                startActivityForResult(intent,100);
            }
        });
    }
}


