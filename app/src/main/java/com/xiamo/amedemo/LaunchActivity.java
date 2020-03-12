package com.xiamo.amedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        findViewById(R.id.btn_wys).setOnClickListener(this);
        findViewById(R.id.btn_mark).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_wys:
                startActivity(new Intent(this,Main2Activity.class));
                break;
            case R.id.btn_mark:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
