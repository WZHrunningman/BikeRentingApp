package com.example.mania.bikerentingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;

import org.w3c.dom.Text;

import java.util.List;

public class ReclcleViewAdapter extends RecyclerView.Adapter<ReclcleViewAdapter.myViewHolder>{

    private Context context;
    private List<RecycleViewItem> list;

    public ReclcleViewAdapter(Context context, List<RecycleViewItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        holder.iv_photo.setImageResource(list.get(position).getPhoto());
        holder.tv_where.setText(list.get(position).getWhere());
        holder.btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Poi start = new Poi("广东东软学院",new LatLng(23.1559147591,113.0308304427),"");
                        Poi end = new Poi("狮山",new LatLng(23.1222783189,113.0074154408),"");
                        AmapNaviPage.getInstance().showRouteActivity(context, new AmapNaviParams(start, null, end, AmapNaviType.DRIVER), new INaviInfoCallback() {
                                @Override
                                public void onInitNaviFailure() {

                                }

                                @Override
                                public void onGetNavigationText(String s) {

                                }

                                @Override
                                public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

                                }

                                @Override
                                public void onArriveDestination(boolean b) {

                                }

                                @Override
                                public void onStartNavi(int i) {

                                }

                                @Override
                                public void onCalculateRouteSuccess(int[] ints) {

                                }

                                @Override
                                public void onCalculateRouteFailure(int i) {

                                }

                                @Override
                                public void onStopSpeaking() {

                                }

                                @Override
                                public void onReCalculateRoute(int i) {

                                }

                                @Override
                                public void onExitPage(int i) {

                                }

                                @Override
                                public void onStrategyChanged(int i) {

                                }

                                @Override
                                public View getCustomNaviBottomView() {
                                    return null;
                                }

                                @Override
                                public View getCustomNaviView() {
                                    return null;
                                }

                                @Override
                                public void onArrivedWayPoint(int i) {

                                }});
                        break;
                    case 1:
                        Poi start1 = new Poi("广东东软学院",new LatLng(23.1559147591,113.0308304427),"");
                        Poi end1 = new Poi("顺德",new LatLng(22.8053542549,113.2931927783),"");
                        AmapNaviPage.getInstance().showRouteActivity(context, new AmapNaviParams(start1, null, end1, AmapNaviType.DRIVER), new INaviInfoCallback() {
                            @Override
                            public void onInitNaviFailure() {

                            }

                            @Override
                            public void onGetNavigationText(String s) {

                            }

                            @Override
                            public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

                            }

                            @Override
                            public void onArriveDestination(boolean b) {

                            }

                            @Override
                            public void onStartNavi(int i) {

                            }

                            @Override
                            public void onCalculateRouteSuccess(int[] ints) {

                            }

                            @Override
                            public void onCalculateRouteFailure(int i) {

                            }

                            @Override
                            public void onStopSpeaking() {

                            }

                            @Override
                            public void onReCalculateRoute(int i) {

                            }

                            @Override
                            public void onExitPage(int i) {

                            }

                            @Override
                            public void onStrategyChanged(int i) {

                            }

                            @Override
                            public View getCustomNaviBottomView() {
                                return null;
                            }

                            @Override
                            public View getCustomNaviView() {
                                return null;
                            }

                            @Override
                            public void onArrivedWayPoint(int i) {

                            }});
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_photo;
        TextView tv_where;
        Button btn_go;

        public myViewHolder(View itemView) {
            super(itemView);
            iv_photo = itemView.findViewById(R.id.iv_photo);
            tv_where = itemView.findViewById(R.id.tv_where);
            btn_go = itemView.findViewById(R.id.btn_go);
        }
    }
}
