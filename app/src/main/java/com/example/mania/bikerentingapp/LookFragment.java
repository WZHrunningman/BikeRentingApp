package com.example.mania.bikerentingapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mania.bikerentingapp.SingIn_and_SingUp.Table_UserMassage;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class LookFragment extends Fragment {

    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private List<View> views;
    private List<RecycleViewItem> list;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_look,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        viewPager = view.findViewById(R.id.vp_image);
        recyclerView = view.findViewById(R.id.rv_image);


//        /**
//         * 以下代码是添加ViewPageAdapter适配器所用到的代码
//         */
//        views = new ArrayList<>();
//        View green1 = LayoutInflater.from(getActivity())
//                .inflate(R.layout.viewpage_item1,null);
//        views.add(green1);
//        View green2 = LayoutInflater.from(getActivity())
//                .inflate(R.layout.viewpage_item2,null);
//        views.add(green2);
//        View green3 = LayoutInflater.from(getActivity())
//                .inflate(R.layout.viewpage_item3,null);
//        views.add(green3);
//
//        viewPager.setAdapter(new ViewPagerAdapter(views));
//        viewPager.setOffscreenPageLimit(shenglue);

        /**
         * 以下代码是recycleview添加适配器代码
         */

        list = new ArrayList<>();
        list.add(new RecycleViewItem(R.drawable.city1,"狮山"));
        list.add(new RecycleViewItem(R.drawable.city2,"顺德"));
        list.add(new RecycleViewItem(R.drawable.city3,"禅城"));
        list.add(new RecycleViewItem(R.drawable.city4,"三水"));
        list.add(new RecycleViewItem(R.drawable.city5,"深圳"));
        list.add(new RecycleViewItem(R.drawable.city6,"天河"));
        list.add(new RecycleViewItem(R.drawable.city7,"珠海"));
        recyclerView.setAdapter(new ReclcleViewAdapter(getActivity(),list));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

}































