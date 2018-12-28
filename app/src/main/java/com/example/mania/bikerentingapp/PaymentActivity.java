package com.example.mania.bikerentingapp;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SQLQueryListener;

public class PaymentActivity extends AppCompatActivity {

    private long exitTime = 0;      //按下两次返回键的间隔时长
    private TextView tv_bikenumber,tv_time,tv_money,tv_date;
    private Button btn_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        tv_bikenumber = findViewById(R.id.tv_bikemassage);
        tv_time = findViewById(R.id.tv_time);
        tv_money = findViewById(R.id.tv_money);
        tv_date = findViewById(R.id.tv_date);
        btn_pay = findViewById(R.id.btn_pay);

        //获取当前日期
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        tv_date.setText(year+"/"+month+"/"+day);

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 选择支付对话框
                 */
                final String items[] = {"微信支付", "支付宝支付", "银行卡支付"};
                AlertDialog dialog = new AlertDialog.Builder(PaymentActivity.this)
                        .setIcon(R.mipmap.icon_pay)//设置标题的图片
                        .setTitle("选择支付方式")//设置对话框的标题
                        .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(PaymentActivity.this,"支付成功",Toast.LENGTH_SHORT).show();
                                setResult(2);
                                finish();
                            }
                        }).create();
                dialog.show();
            }
        });



    }

    /**
     * //禁止使用返回键返回到上一页,但是按两下可以直接退出程序**
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event); //继续执行父类其他点击事件
    }

    private void exit() {

        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            moveTaskToBack(true);
            System.exit(0);
        }

    }


}






























