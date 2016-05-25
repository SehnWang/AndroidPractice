package com.xhao.androidpractice.draw;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.xhao.androidpractice.R;

/**
 * Created by WongxHao on 2016/5/25 22:52
 */
public class MyViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_myview_test);
    }
}
