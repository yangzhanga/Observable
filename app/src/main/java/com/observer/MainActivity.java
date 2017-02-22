package com.observer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.*;

/**
 * 回调函数与观察者模式
 *  关于回调函数的定义在知乎上看到过一个很赞的解释：
 *  你到一个商店买东西，刚好你要的东西没有货，于是你在店员那里留下了你的电话，
 *  过了几天店里有货了，店员就打了你的电话，然后你接到电话后就到店里去取了货。
 *  在这个例子里，你的电话号码就叫回调函数，你把电话留给店员就叫登记回调函数，
 *  店里后来有货了叫做触发了回调关联的事件，店员给你打电话叫做调用回调函数，
 *  你到店里去取货叫做响应回调事件。回答完毕。
 *
 *  类似于按钮点击事件 setOnClickListener
 *  这里我们的被观察者就是View，他的注册方法（register）就是setOnClickListener(),
 *  通知方法就是performClick；而OnClickListener就是观察者。只不过这里的只能注册一个观察对象而已。
 */
public class MainActivity extends AppCompatActivity implements ObserverListener{
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button) findViewById(R.id.btn_main);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        //注册被观察者
        MyObservable.getInstance().register(this);

        MyObservable.getInstance().notifyObserverListener("更新提醒信息");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyObservable.getInstance().remove(this);
    }

    /**
     * 观察者中的方法
     * @param message
     */
    @Override
    public void receive(String message) {
        Log.e("aaa",message+"");
    }
}
