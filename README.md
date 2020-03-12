# Android-Markdown-Editor

墨璃编辑器(ame) --- Android Markdown 编辑器，基于[b3log/vditor](https://github.com/Vanessa219/vditor)
github: https://github.com/csfwff/Android-Markdown-Editor

## 更新记录
- 2020/3/12
	1. 升级vditor到2.2.19
	2. 增加wysiwyg模式
	3. 将getHTML和html2md改为同步
	4. insertValue增加是否渲染参数

## 背景

我就是闲的，感觉得整点东西，又不知道整啥，就整了个这个，然后结合之前做富文本是遇到的坑，稍微做了点修改

## 方法说明

由于基于 vditor，因此支持 vditor 的大部分方法

||说明|
|---|---|
|getValue(ValueCallback&lt;String&gt; callback)|获取编辑器内容|
|getHTML(ValueCallback&lt;String&gt; callback)|获取预览区内容。|
|insertValue(String value, boolean render)|在焦点处插入内容，是否进行markdown渲染|
|focus()|聚焦到编辑器|
|blur()|让编辑器失焦|
|disabled()|禁用编辑器|
|enable()|解除编辑器禁用|
|setSelection(int start，int end)|选中从 start 开始到 end 结束的字符串，不支持 wysiwyg 模式|
|getSelection(ValueCallback&lt;String&gt; callback)|获取选中的字符串|
|setValue(String value)|设置编辑器内容|
|getCursorPosition(ValueCallback&lt;String&gt; callback)|获取焦点位置，{top: number, left: number}|
|deleteValue()|删除选中内容|
|updateValue(String value)|更新选中内容|
|clearCache()|清除缓存|
|disabledCache()|禁用缓存|
|enableCache()|启用缓存|
|html2md(value: string,ValueCallback&lt;String&gt; callback)|HTML 转 md。|
|tip(String text,int time)|消息提示。time 为 0 将一直显示|
|setPreviewMode(PreviewMode previewMode)|设置预览模式。PreviewMode.both, PreviewMode.editor, PreviewMode.preview|
|setMode(Mode mode)|设置markdown模式或wysiwyg模式|

注：
1. `getHTML`返回的string会将`<`转义成`\u003C`，自行查找替换即可
2. `setPreviewMode`仅在markdown模式下有效
3. ~~wysiwyg下模式下`insertValue`渲染的时候会有部分标记未能联系上下文，未能正确渲染，可以采用插入的时候不渲染，换行后删除，即可正确渲染，参考[这里](https://github.com/Vanessa219/vditor/issues/218)~~


此外，为了方便自定义，砍掉了默认的工具栏，只提供方法，按钮怎么摆就是你的事了
另外以下方法仅支持markdown模式，wysiwyg模式下请使用`insertValue`

||说明|
|---|---|
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;undo()&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;撤销&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|
|redo()|重做|
|setBold()|加粗|
|setH1()|一级标题|
|setH2()|二级标题|
|setH3()|三级标题|
|setH4()|四级标题|
|setH5()|五级标题|
|setH6()|六级标题|
|setItalic()|斜体|
|setStrike()|删除线|
|setLine()|分割线|
|setQuote()|引用|
|setList()|无序列表|
|setOrdered()|有序列表|
|setCheck()|任务列表|
|setCode()|代码块|
|setInlineCode()|行内代码|
|setLink()|超链接|
|setTable()|表格|

## 食用方法

XML

```
<com.xiamo.ame.AMEditor
     android:id="@+id/ameditor"
     android:layout_width="match_parent"
     android:layout_height="200dp"
     />
```

Java

```
AMEditor amEditor = (AMEditor)findViewById(R.id.ameditor);

amEditor.focus();
amEditor.setPreviewMode(AMEditor.PreviewMode.preview);
...
```

## 截图预览
<img src=https://raw.githubusercontent.com/csfwff/Android-Markdown-Editor/03118b63cc9502b387fa453ed9faea0c1d40c5a6/screenshot/1.jpg width=200>  <img src=https://raw.githubusercontent.com/csfwff/Android-Markdown-Editor/03118b63cc9502b387fa453ed9faea0c1d40c5a6/screenshot/2.jpg width=200>
<img src=https://raw.githubusercontent.com/csfwff/Android-Markdown-Editor/03118b63cc9502b387fa453ed9faea0c1d40c5a6/screenshot/3.jpg width=200>
  <br/>
  <img src=https://raw.githubusercontent.com/csfwff/Android-Markdown-Editor/master/screenshot/4.jpg width=200>


 

## 鸣谢
* [Vditor](https://github.com/Vanessa219/vditor)： 浏览器端的 Markdown 编辑器

## 其他说明
稍微魔改下Vditor，改动可以看[这里](https://github.com/csfwff/vditor)
