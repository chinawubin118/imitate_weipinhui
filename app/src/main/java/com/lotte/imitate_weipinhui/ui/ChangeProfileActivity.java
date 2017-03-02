package com.lotte.imitate_weipinhui.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lotte.imitate_weipinhui.R;
import com.lotte.imitate_weipinhui.model.EventModel;
import com.lotte.imitate_weipinhui.support.Utils;

import org.greenrobot.eventbus.EventBus;

public class ChangeProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView tv_login, tv_un_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);

        initViews();
        setListeners();

        Utils.initToolbar(this, toolbar, "", "", R.mipmap.back, null);
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv_login = (TextView) findViewById(R.id.tv_login);
        tv_un_login = (TextView) findViewById(R.id.tv_un_login);
    }

    private void setListeners() {
        tv_login.setOnClickListener(this);
        tv_un_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                EventBus.getDefault().post(new EventModel(EventModel.CODE_LOGIN));
                Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.tv_un_login:
                EventBus.getDefault().post(new EventModel(EventModel.CODE_LOGOUT));
                Toast.makeText(getApplicationContext(), "退出登录", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
