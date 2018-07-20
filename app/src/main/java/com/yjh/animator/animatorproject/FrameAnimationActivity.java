package com.yjh.animator.animatorproject;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


/**
 * 帧动画
 * 把一个动画分成多张图片，然后把这些图片连贯起来播放，原理和动画片类似。
 */

public class FrameAnimationActivity extends AppCompatActivity {

    private AnimationDrawable animationDrawable;
    private ImageView animIv;
    private Button animStartBtn;
    private Button animStopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        animIv = findViewById(R.id.iv_frame_anim);
        animStartBtn = findViewById(R.id.btn_frame_start);
        animStopBtn = findViewById(R.id.btn_frame_stop);
//        animStart1();
        createFrameAnim();
        setListener();
    }


    /**
     * ==========================================================================================
     * xml资源文件设置动画帧，在imageview中设置src
     */
    public void animStart1(){
        animationDrawable = (AnimationDrawable)animIv.getDrawable();
        animationDrawable.start();
    }

    /**
     * xml资源文件设置动画帧，未在imageview中设置src
     */
    public void animStart2(){
        // 通过逐帧动画的资源文件获得AnimationDrawable示例
        animationDrawable = (AnimationDrawable)getResources().getDrawable(R.drawable.frame_anim);
        // 把AnimationDrawable设置为ImageView的背景
        animIv.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();
    }
    //===========================================================================================




    /**
     * ==========================================================================================
     * 使用java代码创建逐帧动画
     */
    public void createFrameAnim(){
        animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.m1),500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.m2),500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.m3),500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.m4),500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.m5),500);
        animationDrawable.setOneShot(true);
        animIv.setBackgroundDrawable(animationDrawable);
    }

    public void setListener(){
        animStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(animationDrawable != null && !animationDrawable.isRunning()){
                    animationDrawable.start();
                }
            }
        });
        animStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(animationDrawable!= null && animationDrawable.isRunning()){
                    animationDrawable.stop();
                }
            }
        });
    }
    //===========================================================================================


}
