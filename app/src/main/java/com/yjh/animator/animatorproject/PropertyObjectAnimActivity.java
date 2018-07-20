package com.yjh.animator.animatorproject;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PropertyObjectAnimActivity extends AppCompatActivity {

    private ImageView propertyAnimIv;
    private Button alphaAnimBtn;
    private Button translateAnimBtn;
    private Button scaleAnimBtn;
    private Button roateAnimBtn;
    private Button setAnimBtn;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        initView();
        setListener();
    }

    public void initView(){
        propertyAnimIv = findViewById(R.id.iv_property_tween_anim);
        alphaAnimBtn = findViewById(R.id.btn_property_alpha_anim);
        translateAnimBtn = findViewById(R.id.btn_property_translate_anim);
        scaleAnimBtn = findViewById(R.id.btn_property_scale_anim);
        roateAnimBtn = findViewById(R.id.btn_property_roate_anim);
        setAnimBtn = findViewById(R.id.btn_property_set_anim);
        mButton = findViewById(R.id.btn);
    }

    public void setListener(){
        alphaAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnim();
            }
        });
        scaleAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleAnim();
            }
        });
        translateAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translateAnim();
            }
        });
        roateAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateAnim();
            }
        });
        setAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setAnim();
                setAnimXml();
            }
        });
    }


    /**
     * ===============================================================================================
     * 使用java代码设置，移动：把一张图片沿X轴向右移动100px，然后向左移动回到原位：
     */
    public void translateAnim(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(propertyAnimIv,"translationX",0f,100f,0f);
        animator.setDuration(500);
        animator.start();
    }

    /**
     * 旋转：3D旋转把一张图片垂直旋转360度
     */
    public void rotateAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(propertyAnimIv, "rotation", 90f, 0f);
        animator.setDuration(500);
        animator.start();
    }

    /**
     * 透明度：
     */
    public void alphaAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(propertyAnimIv, "alpha", 1f, 0f,1f);
        animator.setDuration(3000);
        animator.start();
    }

    /**
     * 缩放：
     */
    public void scaleAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(propertyAnimIv, "scaleX",  1f,0f,1f);
        animator.setDuration(3000);
        animator.start();
    }

    /**
     * 组合动画
     */
    public void setAnim(){
        ObjectAnimator translation = ObjectAnimator.ofFloat(propertyAnimIv,"translationX",0f,100f,0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(propertyAnimIv,"rotation",0f,360f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(propertyAnimIv,"alpha",1f,0f,1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(translation).with(rotate).before(alpha);
        animatorSet.setDuration(5000);
        animatorSet.start();
    }
    //================================================================================================


    /**
     * ===============================================================================================
     * ValueAnimatorxml资源文件设置valueanimator   ???????
     * */
    public void setAnimXml(){
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.property_set_anim);
        animatorSet.setTarget(propertyAnimIv); // 设置动画作用对象
        animatorSet.start();
    }
    //================================================================================================


}
