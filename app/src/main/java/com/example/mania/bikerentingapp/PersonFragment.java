package com.example.mania.bikerentingapp;

import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mania.bikerentingapp.SingIn_and_SingUp.LogInActivity;
import com.example.mania.bikerentingapp.customdialog.CustomDialog;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class PersonFragment extends Fragment implements View.OnClickListener {

    private ImageView iv_stroke,iv_customer_service,iv_repair;
    private TextView tv_name;
    private Button btn_logout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iv_stroke = view.findViewById(R.id.iv_stroke);
        iv_customer_service = view.findViewById(R.id.iv_customer_service);
        iv_repair = view.findViewById(R.id.iv_repair);
        tv_name = view.findViewById(R.id.tv_name);
        btn_logout = view.findViewById(R.id.btn_logout);

        iv_stroke.setOnClickListener(this);
        iv_customer_service.setOnClickListener(this);
        iv_repair.setOnClickListener(this);

        //Bmob初始化
        Bmob.initialize(getActivity(),"2546cdcbd73f5fc75fbf6c06802cdf87");
        BmobUser bmobUser = BmobUser.getCurrentUser();      //从本地缓存中获取当前登陆用户某一列的值。其中key为用户表的指定列名。
        String username = bmobUser.getUsername();
        tv_name.setText(username);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent1 = new Intent(getActivity(), LogInActivity.class);
                        BmobUser.logOut();
                        BmobUser currentUser = BmobUser.getCurrentUser(); // 现在的currentUser是null了
                        startActivity(intent1);
                    }
        });

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.iv_stroke:
                intent = new Intent(getActivity(),StrokeActivity.class);
                break;
            case R.id.iv_customer_service:

                break;
            case R.id.iv_repair:

                break;
        }
        startActivity(intent);

    }
}
