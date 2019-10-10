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

        amEditor = (AMEditor) findViewById(R.id.ameditor);

        findViewById(R.id.bold_img).setOnClickListener(this);
        findViewById(R.id.italic_img).setOnClickListener(this);
        findViewById(R.id.strike_img).setOnClickListener(this);
        findViewById(R.id.quote_img).setOnClickListener(this);
        findViewById(R.id.line_img).setOnClickListener(this);
        findViewById(R.id.h1_img).setOnClickListener(this);
        findViewById(R.id.h2_img).setOnClickListener(this);
        findViewById(R.id.h3_img).setOnClickListener(this);
        findViewById(R.id.h4_img).setOnClickListener(this);
        findViewById(R.id.h5_img).setOnClickListener(this);
        findViewById(R.id.h6_img).setOnClickListener(this);
        findViewById(R.id.link_img).setOnClickListener(this);
        findViewById(R.id.list_img).setOnClickListener(this);
        findViewById(R.id.ordered_img).setOnClickListener(this);
        findViewById(R.id.code_img).setOnClickListener(this);
        findViewById(R.id.inlinecode_img).setOnClickListener(this);
        findViewById(R.id.undo_img).setOnClickListener(this);
        findViewById(R.id.redo_img).setOnClickListener(this);

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
        switch (view.getId()) {
            case R.id.bold_img: //加粗
                amEditor.setBold();
                break;
            case R.id.italic_img: //斜体
                amEditor.setItalic();
                break;
            case R.id.strike_img: //删除线
                amEditor.setStrike();
                break;
            case R.id.quote_img://引用
                amEditor.setQuote();
                break;
            case R.id.line_img: //分割线
                amEditor.setLine();
                break;
            case R.id.h1_img://H1
                amEditor.setH1();
                break;
            case R.id.h2_img://H2
                amEditor.setH2();
                break;
            case R.id.h3_img://H3
                amEditor.setH3();
                break;
            case R.id.h4_img://H4
                amEditor.setH4();
                break;
            case R.id.h5_img://H5
                amEditor.setH5();
                break;
            case R.id.h6_img://H6
                amEditor.setH6();
                break;
            case R.id.link_img: //链接
                amEditor.setLink();
                break;
            case R.id.list_img: //列表
                amEditor.setList();
                break;
            case R.id.ordered_img://有序
                amEditor.setOrdered();
                break;
            case R.id.code_img: //代码
                amEditor.setCode();
                break;
            case R.id.inlinecode_img://行内代码
                amEditor.setInlineCode();
                break;
            case R.id.undo_img://撤销
                amEditor.undo();
                break;
            case R.id.redo_img://重做
                amEditor.redo();
                break;
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


    public void goResult(String s) {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("result", s);
        startActivity(intent);
    }
}
