  <script type="text/javascript">	
 	'use strict';
   //trigger extension
    ace.require("ace/ext/language_tools");
    var editor = ace.edit("javacode");
    editor.session.setMode("ace/mode/java");
   	//editor.setTheme("ace/theme/tomorrow");
	// editor.setTheme("ace/theme/Cobalt");
	 editor.setTheme("ace/theme/monokai");
	// editor.setTheme("ace/theme/tomorrow_night_blue");
    document.getElementById('javacode').style.fontSize='16px';
    document.getElementById("javacode").style.fontStyle = "rockwell";
    // enable autocompletion and snippets
    editor.setOptions({enableBasicAutocompletion: true,
        enableSnippets: true, enableLiveAutocompletion: true});
    //////////////////000110011
    $(function(){
    	$("#codebt").click(function(){
    		var code = editor.getValue();
    		    console.log(code);
    	});
    	
    });
 </script>   