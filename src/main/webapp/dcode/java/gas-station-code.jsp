 <script type="text/javascript">
var defaultCode="//Plese write code here";
	defaultCode=defaultCode+"\nimport java.util.*;";
	defaultCode=defaultCode+"\n";
	defaultCode=defaultCode+"\n	public class Main {";
	defaultCode=defaultCode+"\n";
	defaultCode=defaultCode+"\n	    private static int canCompleteCircuit(int[] gas, int[] cost){";
	defaultCode=defaultCode+"\n	         //Write your code here";
	defaultCode=defaultCode+"\n	         return 0;";
	defaultCode=defaultCode+"\n	    }          ";
	defaultCode=defaultCode+"\n	      ";
	defaultCode=defaultCode+"\n	    public static void main(String[] args) throws Exception {";
	defaultCode=defaultCode+"\n	            // Your code here!";
	defaultCode=defaultCode+"\n	            Scanner g = new Scanner(System.in);";
	defaultCode=defaultCode+"\n	            String gline=g.nextLine();";
	defaultCode=defaultCode+"\n	            String[] gasstring=gline.split(\"[ ]+\");";
	defaultCode=defaultCode+"\n	            int gas[]=new int[gasstring.length];";
	defaultCode=defaultCode+"\n	            int count=0;";
	defaultCode=defaultCode+"\n	            for(String s:gasstring){";
	defaultCode=defaultCode+"\n	            	gas[count++]=Integer.parseInt(s);";
	defaultCode=defaultCode+"\n	            }";
	
	defaultCode=defaultCode+"\n	            Scanner c = new Scanner(System.in);";
	defaultCode=defaultCode+"\n	            String cline=c.nextLine();";
	defaultCode=defaultCode+"\n	            String[] coststring=cline.split(\"[ ]+\");";
	defaultCode=defaultCode+"\n	            int cost[]=new int[coststring.length];";
	defaultCode=defaultCode+"\n	            count=0;";
	defaultCode=defaultCode+"\n	            for(String s:coststring){";
	defaultCode=defaultCode+"\n	            	cost[count++]=Integer.parseInt(s);";
	defaultCode=defaultCode+"\n	            }";
	
	defaultCode=defaultCode+"\n	            int result=canCompleteCircuit(gas,cost);";
	defaultCode=defaultCode+"\n	            System.out.println(result);";
	defaultCode=defaultCode+"\n	       ";
	defaultCode=defaultCode+"\n	      }";
	defaultCode=defaultCode+"\n	}";
	editor.setValue(defaultCode);
	editor.getSelection().clearSelection();
</script>	