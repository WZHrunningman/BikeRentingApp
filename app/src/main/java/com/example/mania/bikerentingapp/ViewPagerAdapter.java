package com.example.mania.bikerentingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import cn.bmob.v3.b.V;

/**
 * 这个适配器是ViewPage的适配器，普通功能
 * 只能滑动，在第一个和最后一个item无法再向右或向右滑动。
 * 无法自动轮播
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<View> list;

    public ViewPagerAdapter(List<View> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list == null){
            return 0;
        }
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    //初始化每个条目要显示的内容
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = list.get(position);
        container.addView(view);
        return (view);
    }

    //滑出屏幕就销毁
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(list.get(position));
    }
}
