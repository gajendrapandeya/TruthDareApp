package com.codermonkeys.truthdareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private int lastDirection;
    private Random random  = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int   newDirection = random.nextInt(3600);
               float pivotX = imageView.getWidth()/2;
               float pivotY = imageView.getHeight()/2;

                final Animation rotate =new RotateAnimation(lastDirection, newDirection, pivotX, pivotY);
                rotate.setDuration(2000);
                rotate.setFillAfter(true);

                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        button.setEnabled(false);
                       // button.animate();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        button.setEnabled(true);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                lastDirection = newDirection;

                imageView.startAnimation(rotate);
            }
        });
    }
}
