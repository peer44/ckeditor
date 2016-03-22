/**
 * index.jsp的js
 */

// When the CKEDITOR instance is created, fully initialized and ready for interaction. 
// 当id为content的那个ckeditor被创建，并初始化完成之后
CKEDITOR.instances["content"].on("instanceReady", function() {
	

	this.addCommand("save", {
		modes : {
			wysiwyg : 1,
			source : 1
		},
		exec : function(editor) {
			save();
		}
	});
	this.addCommand("print", {
		modes : {
			wysiwyg : 1,
			source : 1
		},
		exec : function(editor) {
			alert("print button");
		}
	});
	this.addCommand("preview", {
		modes : {
			wysiwyg : 1,
			source : 1
		},
		exec : function(editor) {
			//alert("print button");
		}
	});
	
	// set keyup event  
    // this.on("keyup", AutoSave());  
    //and click event  
    // this.document.on("click", AutoSave); 
    //and select event  
    // this.document.on("select", AutoSave);  
    // 失去焦点
    this.on('blur', addTips);
    // 获得焦点
    this.on('focus', deleteTips);
	
});

// 自动保存
function AutoSave() {// 相应的操作过程，可以按下面写，也可以按一般javascript过程写。
	CKEDITOR.tools.setTimeout(function() {
		alert("hello");
	}, 0);
}

// 保存方法
function save() {
	// 获取到editor中的内容
	var content = editor.document.getBody().getHtml();
	alert(content);
}

/*
 * 点击时清除提示信息
 */
function deleteTips() {// 相应的操作过程，可以按下面写，也可以按一般javascript过程写。
	// alert(editor.document.getBody().getText()); //弹出内容
	console.log("focus");
	var tips = editor.document.getBody().getText().trim();
	//console.log("tips: " + tips);
	var mytip = "如果想让图片居中，请先选择居中，然后再插入图片!".trim();
	//console.log("mytip: " + mytip);
	//console.log(tips == mytip);
	if (tips == mytip) {
		CKEDITOR.instances['content'].setData('');
	}

}

/*
 * 如果没有输入，失去焦点时给出提示信息
 */
function addTips() {// 相应的操作过程，可以按下面写，也可以按一般javascript过程写。
	// alert(editor.document.getBody().getText()); //弹出内容
	console.log("blur");
	var tips = editor.document.getBody().getText().trim();
	//console.log("tips: " + tips);
	var mytip = "如果想让图片居中，请先选择居中，然后再插入图片!".trim();
	//console.log("mytip: " + mytip);
	//console.log(tips == mytip);
	if (tips.length==0) {
		CKEDITOR.instances['content'].setData(mytip);
	}

}
