package com.yjh.animator.animatorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.yjh.svg.SvgTestActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }


    public void setListener(){
        findViewById(R.id.btn_frame_animation).setOnClickListener(this);
        findViewById(R.id.btn_property_value_animation).setOnClickListener(this);
        findViewById(R.id.btn_property_Object_animation).setOnClickListener(this);
        findViewById(R.id.btn_tween_animation).setOnClickListener(this);
        findViewById(R.id.btn_svg_animation).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_frame_animation){
            Intent intent = new Intent(this,FrameAnimationActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_property_value_animation){
            Intent intent = new Intent(this,PropertyValueAnimationActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_tween_animation){
            Intent intent = new Intent(this,TweenAnimationActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_property_Object_animation){
            Intent intent = new Intent(this,PropertyObjectAnimActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_svg_animation){
            Intent intent = new Intent(this,SvgTestActivity.class);
            startActivity(intent);
        }
    }

    public void haha(){
        Log.e("haha---","哈哈哈哈");
        test();
    }

    public void test(){
        Log.e("haha---","我是测试测试");

    }
}
