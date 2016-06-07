package com.xhao.androidpractice.anim;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.xhao.androidpractice.R;

import static com.xhao.androidpractice.R.id.scale_xml;
import static com.xhao.androidpractice.R.id.translate_xml;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener{
    private Button alphaXml;
    private Button alphaJava;
    private Button scaleXml;
    private Button scalJava;
    private Button rotateXml;
    private Button rotateJava;
    private Button translateXml;
    private Button translateJava;

    private Button continueBtn1;
    private Button continueBtn2;

    private ImageView img;

    private Animation loadAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_animation);
        initView();
    }

    /**
     * 初始化组件
     */
    private void initView(){
        alphaXml = (Button) findViewById(R.id.alpha_xml);
        alphaJava = (Button) findViewById(R.id.alpha_java);
        scaleXml = (Button) findViewById(R.id.scale_xml);
        scalJava = (Button) findViewById(R.id.scale_java);
        rotateXml = (Button) findViewById(R.id.rotate_xml);
        rotateJava = (Button) findViewById(R.id.rotate_java);
        translateXml = (Button) findViewById(translate_xml);
        translateJava = (Button) findViewById(R.id.translate_java);

        continueBtn1 = (Button) findViewById(R.id.continue_btn1);
        continueBtn2 = (Button) findViewById(R.id.continue_btn2);

        img = (ImageView) findViewById(R.id.img);

        alphaXml.setOnClickListener(this);
        alphaJava.setOnClickListener(this);
        scaleXml.setOnClickListener(this);
        scalJava.setOnClickListener(this);
        rotateXml.setOnClickListener(this);
        rotateJava.setOnClickListener(this);
        translateXml.setOnClickListener(this);
        translateJava.setOnClickListener(this);

        continueBtn1.setOnClickListener(this);
        continueBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.alpha_xml://透明度
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                img.startAnimation(loadAnimation);
                break;
            case R.id.alpha_java:
                AlphaAnimation animation = new AlphaAnimation(0.2f, 1.0f);
                animation.setDuration(3000);
                animation.setRepeatCount(3);
                img.startAnimation(animation);
                break;
            case scale_xml://缩放
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
                img.startAnimation(loadAnimation);
                break;
            case R.id.scale_java:
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.5f, 0.5f, 1.5f, 0.5f, 0.5f);
                scaleAnimation.setDuration(2000);//动画持续时间
                //插入器
                //先快速 后减速
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                img.startAnimation(scaleAnimation);
                break;
            case R.id.rotate_xml://旋转
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                img.startAnimation(loadAnimation);
                break;
            case R.id.rotate_java:
                RotateAnimation rotateAnimation = new RotateAnimation(30, 180, 50f, 50f);
                rotateAnimation.setDuration(3000);
                img.startAnimation(rotateAnimation);
                break;
            case R.id.translate_xml://平移
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                img.startAnimation(loadAnimation);
                break;
            case  R.id.translate_java:
                TranslateAnimation translateAnimation = new TranslateAnimation(10, 200f, 10f, 200f);
                translateAnimation.setDuration(3000);
                translateAnimation.setBackgroundColor(Color.RED);
                img.startAnimation(translateAnimation);
                break;
            case R.id.continue_btn1:
                /*
                    实现动画的续播
                    方法1：
                        通过设置动画的动画监听setAnimationListener
                 */
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                img.startAnimation(loadAnimation);

                final Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.rotate);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        //动画开始时
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //动画结束时
                        img.startAnimation(animation1);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        //动画重复时
                    }
                });
                break;
            case R.id.continue_btn2:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.continue_anim);
                img.startAnimation(loadAnimation);
                break;
            default:
                break;
        }
    }
}
