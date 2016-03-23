CKEDITOR.editorConfig = function( config ) {
	config.height = 300;
	config.enterMode = CKEDITOR.ENTER_BR;// 以<br>换行替换<p>换行
	config.shiftEnterMode = CKEDITOR.ENTER_BR;// 以<br>换行替换<p>换行
	config.skin = 'bootstrapck';
	
	config.toolbarGroups = [
		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
		{ name: 'forms', groups: [ 'forms' ] },
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
		{ name: 'insert', groups: [ 'insert' ] },
		'/',
		{ name: 'styles', groups: [ 'styles' ] },
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'colors', groups: [ 'colors' ] },
		
		{ name: 'others', groups: [ 'others' ] },
		{ name: 'links', groups: [ 'links' ] },
		{ name: 'about', groups: [ 'about' ] },
		{ name: 'tools', groups: [ 'tools' ] }
	];

	config.removeButtons = 'About,Flash,Form,Checkbox,Radio,TextField,Textarea,Select,Button,ImageButton,HiddenField,NewPage,Templates,Scayt,Language,Smiley,Iframe,SelectAll,CreateDiv,BidiRtl,BidiLtr,ShowBlocks';
};