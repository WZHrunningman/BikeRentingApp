package com.example.mania.bikerentingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mania.bikerentingapp.Balance;
import com.example.mania.bikerentingapp.R;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Balance> list;
    private LayoutInflater layoutInflater;
    private int money;

    public ListViewAdapter() {
    }

    public ListViewAdapter(Context context, List<Balance> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_item,null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.tv_money);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        for (Balance balance : list){
            money += balance.getBalance();
        }
        holder.textView.setText(money+"元");
        return convertView;
    }

}
