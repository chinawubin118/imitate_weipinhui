package com.lotte.imitate_weipinhui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lotte.imitate_weipinhui.support.Utils;
import com.lotte.imitate_weipinhui.support.view.MyScrollView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyScrollView.ScrollingListener {

    private Toolbar toolbar;
    private MyScrollView my_scroll_view;
    private View divider0;
    private ImageView iv_back, iv_settings;//返回,设置

    private float alphaHeight = 0;//透明度渐变的高度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        my_scroll_view = (MyScrollView) findViewById(R.id.my_scroll_view);
        divider0 = findViewById(R.id.divider0);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_settings = (ImageView) findViewById(R.id.iv_settings);

        alphaHeight = Utils.dip2px(this, 160);

        setToolbar();
        setListeners();
    }

    private void setListeners() {
        iv_back.setOnClickListener(this);
        iv_settings.setOnClickListener(this);
        my_scroll_view.setScrollingListener(this);
    }

    private void setToolbar() {
        toolbar.setTitle("");
        toolbar.setSubtitle("");

        //设置导航图标要在setSupportActionBar方法之后
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(null);
        toolbar.setAlpha(0);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.iv_settings:
                Toast.makeText(getApplicationContext(), "设置...", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onScrolling(int l, int t, int oldl, int oldt) {
        float alpha = t * 1.0f / alphaHeight;
        if (alpha < 0.4f) {
            alpha = 0;
            if (divider0.getVisibility() == View.VISIBLE) {
                divider0.setVisibility(View.INVISIBLE);
            }
        } else {
            if (divider0.getVisibility() == View.INVISIBLE) {
                divider0.setVisibility(View.VISIBLE);
            }
        }
        toolbar.setAlpha(alpha);
    }
}
