package com.xhao.androidpractice.draw;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.xhao.androidpractice.R;

/**
 * Created by WongxHao on 2016/5/25 22:52
 */
public class MyViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MyViewActivity", "execute on create - - - >");
        setContentView(R.layout.activity_myview_test);
    }
}
