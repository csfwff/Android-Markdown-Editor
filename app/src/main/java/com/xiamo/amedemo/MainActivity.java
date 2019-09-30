package com.xiamo.amedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.Button;

import com.xiamo.ame.AMEditor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AMEditor amEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amEditor = (AMEditor)findViewById(R.id.ameditor);

        findViewById(R.id.focus_btn).setOnClickListener(this);
        findViewById(R.id.blur_btn).setOnClickListener(this);
        findViewById(R.id.enable_btn).setOnClickListener(this);
        findViewById(R.id.disabled_btn).setOnClickListener(this);
        findViewById(R.id.getValue_btn).setOnClickListener(this);
        findViewById(R.id.insertValue_btn).setOnClickListener(this);
        findViewById(R.id.editor_btn).setOnClickListener(this);
        findViewById(R.id.preview_btn).setOnClickListener(this);
        findViewById(R.id.both_btn).setOnClickListener(this);
        findViewById(R.id.getSelection_btn).setOnClickListener(this);
        findViewById(R.id.setValue_btn).setOnClickListener(this);
        findViewById(R.id.updateValue_btn).setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.focus_btn:  //聚焦
                amEditor.focus();
                break;
            case R.id.blur_btn: //失焦
                amEditor.blur();
                break;
            case R.id.enable_btn: //启用
                amEditor.enable();
                break;
            case R.id.disabled_btn: //禁用
                amEditor.disable();
                break;
            case R.id.getValue_btn: //获取编辑器内容
                amEditor.getValue(new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String s) {
                        goResult(s);
                    }
                });
                break;
            case R.id.insertValue_btn://插入内容
                amEditor.insertValue("这是在焦点处插入内容");
                break;
            case R.id.editor_btn: //设置预览模式。mode: 'both', 'editor', 'preview
                amEditor.setPreviewMode(AMEditor.PreviewMode.editor);
                break;
            case R.id.preview_btn:
                amEditor.setPreviewMode(AMEditor.PreviewMode.preview);
                break;
            case R.id.both_btn:
                amEditor.setPreviewMode(AMEditor.PreviewMode.both);
                break;
            case R.id.getSelection_btn:  //返回选中的字符串
                amEditor.getSelection(new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String s) {
                        goResult(s);
                    }
                });
                break;
            case R.id.setValue_btn://设置编辑器内容
                amEditor.setValue("这是设置编辑器内容");
                break;
            case R.id.updateValue_btn:// 更新选中内容
                amEditor.updateValue("这是更新选中内容");
                break;


        }
    }


    public void goResult(String s){
        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
        intent.putExtra("result",s);
        startActivity(intent);
    }
}
