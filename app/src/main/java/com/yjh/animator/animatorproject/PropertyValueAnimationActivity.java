package com.yjh.animator.animatorproject;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 属性动画（Property Animation）
 * 通过改变对象的属性值来实现的动画效果，不局限使用在View上。
 * ValueAnimator 类是先改变值，然后 手动赋值 给对象的属性从而实现动画；是 间接 对对象属性进行操作；
 *ObjectAnimator 类是先改变值，然后 自动赋值 给对象的属性从而实现动画；是 直接 对对象属性进行操作；
 */

public class PropertyValueAnimationActivity extends AppCompatActivity {

    private ImageView propertyAnimIv;
    private Button valueAnimTv;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        initView();
        setListener();
    }

    public void initView(){
        valueAnimTv = findViewById(R.id.btn_property_value_anim);
        propertyAnimIv = findViewById(R.id.iv_property_tween_anim);
        mButton = findViewById(R.id.btn);
    }

    public void setListener(){
        valueAnimTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAnimator();
//                valueAnimator1();
            }
        });
    }


    /**
     * ===============================================================================================
     * ValueAnimator使用java代码：因为属性动画就是通过不断的改变对象的属性值来实现的动画效果，初始值和结束值之间的动画过渡就是由ValueAnimator这个类来完成计算的。
     * ValueAnimator的用法还是比较简单的，比如想要把一个值从0平滑的过渡到1，间隔300ms
     */
    public void valueAnimator(){
        ValueAnimator animator = ValueAnimator.ofInt(mButton.getLayoutParams().width,500);
//        animator =  ValueAnimator.ofInt(0,3);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);   // 直接传入int型数值，INFINITE代表无限循环
        //animator.setStartDelay(1000);   // 设置动画的延迟播放时间
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                mButton.getLayoutParams().width = currentValue;
                mButton.requestLayout();
                Log.d("onAnimationUpdate","currentValue:"+ currentValue);
            }
        });
        animator.start();
    }
    //================================================================================================


    /**
     * ===============================================================================================
     * ValueAnimatorxml资源文件设置valueanimator   ???????
     * */
    public void valueAnimator1(){
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.property_value_anim);
        animator.setTarget(valueAnimTv);
        animator.start();
    }
    //================================================================================================



}
