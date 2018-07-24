package com.yjh.svg;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yjh.animator.animatorproject.R;

public class SvgTestActivity extends AppCompatActivity {


    ImageView imageView;
    TextView textView;
    AnimatedVectorDrawable drawable;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg_test);
        imageView = findViewById(R.id.iv_svg_test);
        textView = findViewById(R.id.tv_svg_start);
        drawable = (AnimatedVectorDrawable)imageView.getResources().getDrawable(R.drawable.animated_svg);
        imageView.setImageDrawable(drawable);

        setListener();
    }

    public void setListener(){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawable.start();
            }
        });
    }
}
