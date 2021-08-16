 <script type="text/javascript">
 'use strict';
   //trigger extension
    ace.require("ace/ext/language_tools");
    var editor = ace.edit("javacode");
    editor.session.setMode("ace/mode/java");
   	//editor.setTheme("ace/theme/tomorrow");
	// editor.setTheme("ace/theme/Cobalt");
	// editor.setTheme("ace/theme/monokai");
	 editor.setTheme("ace/theme/tomorrow_night_blue");
	var defaultCode="//Plese write code here";
	defaultCode=defaultCode+"\nimport java.util.Scanner;";
	defaultCode=defaultCode+"\n";
	defaultCode=defaultCode+"\n	public class Main {";
	defaultCode=defaultCode+"\n";
	defaultCode=defaultCode+"\n	    private static int factorial(int num){";
	defaultCode=defaultCode+"\n	         //Write your code here";
	defaultCode=defaultCode+"\n	         return 0;";
	defaultCode=defaultCode+"\n	    }          ";
	defaultCode=defaultCode+"\n	      ";
	defaultCode=defaultCode+"\n	    public static void main(String[] args) throws Exception {";
	defaultCode=defaultCode+"\n	            // Your code here!";
	defaultCode=defaultCode+"\n	              Scanner scan=new Scanner(System.in);";
	defaultCode=defaultCode+"\n	            int num=0;";
	defaultCode=defaultCode+"\n	            num=scan.nextInt();";
	defaultCode=defaultCode+"\n	            int result=factorial(num);";
	defaultCode=defaultCode+"\n	            System.out.println(result);";
	defaultCode=defaultCode+"\n	       ";
	defaultCode=defaultCode+"\n	      }";
	defaultCode=defaultCode+"\n	}";
	editor.setValue(defaultCode);
	editor.getSelection().clearSelection();
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