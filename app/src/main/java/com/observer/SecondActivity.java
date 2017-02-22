package com.observer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import observer.MyObservable;

/**
 * Created by zhangyang on 17/2/22.
 */

public class SecondActivity extends Activity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //注册被观察者
                MyObservable.getInstance().notifyObserverListener("SecondActivity触发");
            }
        });
    }
}
