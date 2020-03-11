package com.xiamo.ame;

import android.util.Log;
import android.webkit.JavascriptInterface;

@Deprecated
public class JsInterface {

    AMEditor amEditor;

    public JsInterface(AMEditor amEditor){
        this.amEditor = amEditor;
    }

    @JavascriptInterface
    public void getHtml(String result){
        this.amEditor.getHtmlFinished(result);
    }

    @JavascriptInterface
    public void html2md(String result){
        Log.e("------", "html2md: "+result );
        this.amEditor.html2mdFinished(result);
    }
}
