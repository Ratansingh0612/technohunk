 <script type="text/javascript">
var defaultCode="//Plese write code here";
	defaultCode=defaultCode+"\nimport java.util.*;";
	defaultCode=defaultCode+"\n";
	defaultCode=defaultCode+"\n	public class Main {";
	defaultCode=defaultCode+"\n";
	defaultCode=defaultCode+"\n	    private static boolean validateStackSequences(int[] pushed, int[] popped){";
	defaultCode=defaultCode+"\n	         //Write your code here";
	defaultCode=defaultCode+"\n	         return false;";
	defaultCode=defaultCode+"\n	    }          ";
	defaultCode=defaultCode+"\n	      ";
	defaultCode=defaultCode+"\n	    public static void main(String[] args) throws Exception {";
	defaultCode=defaultCode+"\n	            // Your code here!";
	defaultCode=defaultCode+"\n	            Scanner g = new Scanner(System.in);";
	defaultCode=defaultCode+"\n	            String gline=g.nextLine();";
	defaultCode=defaultCode+"\n	            String[] pushedstring=gline.split(\"[ ]+\");";
	defaultCode=defaultCode+"\n	            int pushed[]=new int[pushedstring.length];";
	defaultCode=defaultCode+"\n	            int count=0;";
	defaultCode=defaultCode+"\n	            for(String s:pushedstring){";
	defaultCode=defaultCode+"\n	            	pushed[count++]=Integer.parseInt(s);";
	defaultCode=defaultCode+"\n	            }";
	
	defaultCode=defaultCode+"\n	            Scanner c = new Scanner(System.in);";
	defaultCode=defaultCode+"\n	            String cline=c.nextLine();";
	defaultCode=defaultCode+"\n	            String[] poppedstring=cline.split(\"[ ]+\");";
	defaultCode=defaultCode+"\n	            int popped[]=new int[poppedstring.length];";
	defaultCode=defaultCode+"\n	            count=0;";
	defaultCode=defaultCode+"\n	            for(String s:poppedstring){";
	defaultCode=defaultCode+"\n	            	popped[count++]=Integer.parseInt(s);";
	defaultCode=defaultCode+"\n	            }";
	
	defaultCode=defaultCode+"\n	            boolean result=validateStackSequences(pushed,popped);";
	defaultCode=defaultCode+"\n	            System.out.println(result);";
	defaultCode=defaultCode+"\n	       ";
	defaultCode=defaultCode+"\n	      }";
	defaultCode=defaultCode+"\n	}";
	editor.setValue(defaultCode);
	editor.getSelection().clearSelection();
</script>	