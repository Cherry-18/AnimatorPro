package com.yjh.animator.animatorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        }
    }
}