package com.virgil.gendertogglebutton;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImage_male = null;
    private ImageView mImage_female = null;
    private TextView mTv_sex = null;
    private Button mBtn_male;
    private Button mBtn_female;
    private Context mCtx = this;
    private String sex = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        //假设性别初始值为male
        sex = "female";
    }

    private void initView() {
        mBtn_male = (Button) findViewById(R.id.btn_male);
        mBtn_female = (Button) findViewById(R.id.btn_female);
        mTv_sex = (TextView) findViewById(R.id.tv_sex);
        mImage_male = (ImageView) findViewById(R.id.image_main_male);
        mImage_female = (ImageView) findViewById(R.id.image_main_female);
        if ("male".equals(sex)) {
            mImage_male.setVisibility(View.VISIBLE);
            mImage_female.setVisibility(View.GONE);
            mTv_sex.setText("MALE");
        } else {
            mImage_male.setVisibility(View.GONE);
            mImage_female.setVisibility(View.VISIBLE);
            mTv_sex.setText("FEMALE");
        }

        mBtn_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatorSet animator_alpha_xml = null;
                if ("male".equals(sex)) {
                    animator_alpha_xml = (AnimatorSet) AnimatorInflater.loadAnimator(mCtx,
                            R.animator.animator_male2);
                } else {
                    animator_alpha_xml = (AnimatorSet) AnimatorInflater.loadAnimator(mCtx,
                            R.animator.animator_male);
                }

                if ("male".equals(sex)) {
                    animator_alpha_xml.setTarget(mImage_male);
                } else {
                    animator_alpha_xml.setTarget(mImage_female);
                }

                animator_alpha_xml.start();
                mTv_sex.setText("MALE");

                if ("male".equals(sex)) {
                    mImage_male.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.boy));
                } else {
                    mImage_female.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.boy));
                }

                //mImage.startAnimation(AnimationUtils.loadAnimation(mCtx, R.anim.animation_male));
            }
        });

        mBtn_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatorSet animator_alpha_xml = null;
                if ("male".equals(sex)) {
                    animator_alpha_xml = (AnimatorSet) AnimatorInflater.loadAnimator(mCtx,
                            R.animator.animator_female2);
                } else {
                    animator_alpha_xml = (AnimatorSet) AnimatorInflater.loadAnimator(mCtx,
                            R.animator.animator_female);
                }

                if ("male".equals(sex)) {
                    animator_alpha_xml.setTarget(mImage_male);
                } else {
                    animator_alpha_xml.setTarget(mImage_female);
                }

                animator_alpha_xml.start();
                mTv_sex.setText("FEMALE");

                if ("male".equals(sex)) {
                    mImage_male.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.girl));
                } else {
                    mImage_female.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.girl));
                }

                //mImage.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.girl));
                //mImage.startAnimation(AnimationUtils.loadAnimation(mCtx, R.anim.animation_male));
            }
        });
    }
}

