package com.xiamo.amedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.xiamo.ame.AMEditor;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private AMEditor amEditor;
    private boolean isRender = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        amEditor = (AMEditor) findViewById(R.id.ameditor);

        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);
        findViewById(R.id.btn_10).setOnClickListener(this);
        findViewById(R.id.btn_11).setOnClickListener(this);

        CheckBox cb = findViewById(R.id.render_cb);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isRender = b;
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_0:
                amEditor.insertValue("#",isRender);
                break;
            case R.id.btn_1:
                amEditor.insertValue("*",isRender);
                break;
            case R.id.btn_2:
                amEditor.insertValue("~",isRender);
                break;
            case R.id.btn_3:
                amEditor.insertValue("-",isRender);
                break;
            case R.id.btn_4:
                amEditor.insertValue("[",isRender);
                break;
            case R.id.btn_5:
                amEditor.insertValue("(",isRender);
                break;
            case R.id.btn_6:
                amEditor.insertValue(".",isRender);
                break;
            case R.id.btn_7:
                amEditor.insertValue("`",isRender);
                break;
            case R.id.btn_8:
                amEditor.insertValue(">",isRender);
                break;
            case R.id.btn_9:
                amEditor.insertValue("!",isRender);
                break;
            case R.id.btn_10:
                amEditor.insertValue("]",isRender);
                break;
            case R.id.btn_11:
                amEditor.insertValue(")",isRender);
                break;
        }
    }
}
