package com.yjh.svg;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.yjh.animator.animatorproject.R;

public class SvgTestActivity extends AppCompatActivity {


    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg_test);
        imageView = findViewById(R.id.iv_svg_test);
        Drawable drawable = imageView.getDrawable();
        if(drawable instanceof Animatable){
            ((Animatable)drawable).start();
        }

    }
}
