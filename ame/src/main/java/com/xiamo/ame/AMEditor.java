package com.xiamo.ame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AMEditor extends WebView {
    private static final String TAG = "----AME-----";
    private static final String SETUP_HTML = "file:///android_asset/editor.html";


    public AMEditor(Context context) {
        this(context, null);
    }

    public AMEditor(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.webViewStyle);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public AMEditor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.e(TAG, "-------");
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        getSettings().setDomStorageEnabled(true);
        getSettings().setDatabaseEnabled(true);
        setWebChromeClient(new WebChromeClient());
        setWebViewClient(new WebViewClient());
        loadUrl(SETUP_HTML);

    }

    //获取编辑器内容
    public void getValue(ValueCallback<String> callback) {
        evaluateJavascript("javascript:ameGetValue()", callback);
    }

    //在焦点处插入内容
    public void insertValue(String value) {
        String script = "javascript:ameInsertValue('" + value + "')";
        evaluateJavascript(script, null);
    }

    //聚焦到编辑器
    public void focus() {
        evaluateJavascript("javascript:ameFocus()", null);
    }

    //失焦
    public void blur(){
        evaluateJavascript("javascript:ameBlur()", null);
    }

    //禁用
    public void disable(){
        evaluateJavascript("javascript:ameDisabled()", null);
    }

    //解除编辑器禁用
    public void enable(){
        evaluateJavascript("javascript:ameEnable()", null);
    }

    //选中从 start 开始到 end 结束的字符串
    public void setSelection(int start,int end){
        String script = "javascript:ameSetSelection(" + start + ","+end+")";
        evaluateJavascript(script,null);
    }

    //返回选中的字符串
    public void getSelection(ValueCallback<String> callback){
        evaluateJavascript("javascript:ameGetSelection()", callback);
    }

    //设置编辑器内容
    public void setValue(String value){
        String script = "javascript:ameSetValue('" + value + "')";
        evaluateJavascript(script,null);
    }

    //获取焦点位置
    public void getCursorPosition(ValueCallback<String> callback){
        evaluateJavascript("javascript:ameGetCursorPosition()", callback);
    }

    //删除选中内容
    public void deleteValue(){
        evaluateJavascript("javascript:ameDeleteValue()", null);
    }

    //更新选中内容
    public void updateValue(String value){
        String script = "javascript:ameUpdateValue('" + value + "')";
        evaluateJavascript(script,null);
    }

    //清除缓存
    public void clearCache(){
        evaluateJavascript("javascript:ameClearCache()", null);
    }

    //禁用缓存
    public void disabledCache(){
        evaluateJavascript("javascript:ameDisabledCache()", null);
    }

    //启用缓存
    public void enableCache(){
        evaluateJavascript("javascript:ameEnableCache()", null);
    }

    //设置预览模式
    public void setPreviewMode(PreviewMode previewMode){
        Log.e(TAG, "setPreviewMode: "+ previewMode);
        evaluateJavascript("javascript:ameSetPreviewMode('"+ previewMode+"')", null);
    }

    //消息提示
    public void tip(String text,int time){
        String script = "javascript:ameTip('" + text + "',"+time+")";
        evaluateJavascript(script,null);
    }

    public enum PreviewMode {
        both,editor,preview;
    }



}
