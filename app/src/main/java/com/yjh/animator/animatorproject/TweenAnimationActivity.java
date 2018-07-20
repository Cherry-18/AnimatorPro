package com.yjh.animator.animatorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 补间动画
 * 只能对View进行动画操作，支持移动、旋转、透明、缩放四种效果，有一定的局限性。
 */

public class TweenAnimationActivity extends AppCompatActivity {

    private ImageView tweenAnimIv;
    private Button alphaAnimBtn;
    private Button translateAnimBtn;
    private Button scaleAnimBtn;
    private Button roateAnimBtn;
    private Button setAnimBtn;
    AlphaAnimation alphaAnimation;
    RotateAnimation rotateAnimation;
    TranslateAnimation translateAnimation;
    ScaleAnimation scaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        initView();
        setListener();
    }

    public void initView(){
        tweenAnimIv = findViewById(R.id.iv_tween_anim);
        alphaAnimBtn = findViewById(R.id.btn_alpha_anim);
        translateAnimBtn = findViewById(R.id.btn_translate_anim);
        scaleAnimBtn = findViewById(R.id.btn_scale_anim);
        roateAnimBtn = findViewById(R.id.btn_roate_anim);
        setAnimBtn = findViewById(R.id.btn_set_anim);
    }

    public void setListener(){
        alphaAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                alphaAnimStart();
                alphaAnim();
            }
        });
        scaleAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleAnimStart();
            }
        });
        translateAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translateAnimStart();
            }
        });
        roateAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roateAnimStart();
            }
        });
        setAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                animSetStart();
                setAnim();
            }
        });
    }



    /**
     * ===============================================================================================
     * 使用java代码创建补间动画
     * Interpolator 主要作用是可以控制动画的变化速率 ，就是动画进行的快慢节奏。
     * pivot 决定了当前动画执行的参考位置。pivot 这个属性主要是在translate 和 scale 动画中，这两种动画都牵扯到view
     * 的“物理位置“发生变化，所以需要一个参考点。
     */
    public void alphaAnimStart(){
        alphaAnimation = new AlphaAnimation(0,1); //0---->1从透明到不透明
        alphaAnimation.setDuration(3000);
        tweenAnimIv.startAnimation(alphaAnimation);
    }

    public void roateAnimStart(){
        rotateAnimation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(3000);
        tweenAnimIv.startAnimation(rotateAnimation);
    }

    public void translateAnimStart(){
        translateAnimation = new TranslateAnimation(0,200,0,300);
        translateAnimation.setDuration(3000);
        tweenAnimIv.startAnimation(translateAnimation);
    }

    public void scaleAnimStart(){
        scaleAnimation = new ScaleAnimation(0,2,0,2);
        scaleAnimation.setDuration(3000);
        tweenAnimIv.startAnimation(scaleAnimation);
    }

    public void animSetStart(){
        AnimationSet animSet = new AnimationSet(false);
        alphaAnimation = new AlphaAnimation(0,1); //0---->1从透明到不透明
        alphaAnimation.setDuration(3000);
        scaleAnimation = new ScaleAnimation(0,2,0,2);
        scaleAnimation.setDuration(3000);
        rotateAnimation = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(3000);
        translateAnimation = new TranslateAnimation(0,200,0,300);
        translateAnimation.setDuration(3000);
        animSet.addAnimation(alphaAnimation);
        animSet.addAnimation(rotateAnimation);
        animSet.addAnimation(translateAnimation);
        animSet.addAnimation(scaleAnimation);
        tweenAnimIv.startAnimation(animSet);
    }
    //================================================================================================



    /**
     * ==========================================================================================
     * xml资源文件设置补间动画，在imageview中设置src
     */
    public void alphaAnim(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
        animation.setDuration(5000);
        tweenAnimIv.startAnimation(animation);
    }

    public void setAnim(){
        Animation animSet = AnimationUtils.loadAnimation(this,R.anim.tween_set_anim);
        tweenAnimIv.startAnimation(animSet);

    }
    //================================================================================================

}
