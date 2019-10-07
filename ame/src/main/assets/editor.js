const vditor = new Vditor('vditor', {
  mode: 'markdown-show',
  height: 'auto',
  // hint: {
  //     emojiPath: 'https://cdn.jsdelivr.net/npm/vditor@1.8.3/dist/images/emoji',
  //     emojiTail: '<a href="https://hacpai.com/settings/function" target="_blank">设置常用表情</a>',
  //     emoji: {
  //         'sd': '💔',
  //         'j': 'https://unpkg.com/vditor@1.3.1/dist/images/emoji/j.png',
  //     },
  // },
  toolbar: ['preview'],
  tab: '\t',
  preview: {
    mode: 'editor'
  },
  // upload: {
  //     accept: 'image/*,.wav',
  //     token: 'test',
  //     url: '/api/upload/editor',
  //     linkToImgUrl: '/api/upload/fetch',
  //     filename(name) {
  //         return name.replace(/[^(a-zA-Z0-9\u4e00-\u9fa5\.)]/g, '').
  //             replace(/[\?\\/:|<>\*\[\]\(\)\$%\{\}@~]/g, '').
  //             replace('/\\s/g', '')
  //     },
  // },
})
//获取编辑器内容
ameGetValue = () => {
  return vditor.getValue()
}

//在焦点处插入内容
ameInsertValue = (value) => {
  vditor.insertValue(value)
}

//聚焦到编辑器
ameFocus = () => {
  vditor.focus()
}

//失焦
ameBlur = () => {
  vditor.blur()
}

//禁用
ameDisabled = () => {
  vditor.disabled()
}

//解除编辑器禁用
ameEnable = () => {
  vditor.enable()
}

//选中从 start 开始到 end 结束的字符串
ameSetSelection = (start, end) => {
  vditor.setSelection(start, end)
}

//返回选中的字符串
ameGetSelection = () => {
  return vditor.getSelection()
}

//设置编辑器内容
ameSetValue = (value) => {
  vditor.setValue(value)
}

//获取焦点位置
ameGetCursorPosition = () => {
  return JSON.stringify(vditor.getCursorPosition())
}

//删除选中内容
ameDeleteValue = () => {
  vditor.deleteValue()
}

//更新选中内容
ameUpdateValue = (value) => {
  vditor.updateValue(value)
}

//清除缓存
ameClearCache = () => {
  vditor.clearCache()
}

//禁用缓存
ameDisabledCache = () => {
  vditor.disabledCache()
}

//启用缓存
ameEnableCache = () => {
  vditor.enableCache()
}

//设置预览模式
ameSetPreviewMode = (mode) => {
  //alert(mode);
  console.log(mode);

  vditor.setPreviewMode(mode)
}

//消息提示
ameTip = (text, time) => {
  vditor.tip(text, time)
}

ameUndo = () => {
  vditor.undo()
}

ameRedo = () => {
  vditor.redo()
}

ameSetBold = () => {
  vditor.setBold()
}

ameSetH1 = () => {
  vditor.setH1()
}

ameSetH2 = () => {
  vditor.setH2()
}

ameSetH3 = () => {
  vditor.setH3()
}

ameSetH4 = () => {
  vditor.setH4()
}

ameSetH5 = () => {
  vditor.setH5()
}

ameSetH6 = () => {
  vditor.setH6()
}

ameSetItalic = () => {
  vditor.setItalic()
}

ameSetStrike = () => {
  vditor.setStrike()
}

ameSetLine = () => {
  vditor.setLine()
}

ameSetQuote = () => {
  vditor.setQuote()
}

ameSetList = () => {
  vditor.setList()
}

ameSetOrdered = () => {
  vditor.setOrdered()
}

ameSetCheck = () => {
  vditor.setCheck()
}

ameSetCode = () => {
  vditor.setCode()
}

ameSetInlineCode = () => {
  vditor.setInlineCode()
}

ameSetLink = () => {
  vditor.setLink()
}

ameSetTable = () => {
  vditor.setTable()
}
























