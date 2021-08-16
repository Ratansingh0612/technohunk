import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class DataLoader {
	 public static void main(String[] args) throws Exception {
		 FileInputStream fileInputStream;
			try {
				//"input.txt"
				fileInputStream = new FileInputStream(args[0]);
				System.setIn(fileInputStream);
				//"output.txt"
				PrintStream output = new PrintStream(new File(args[1]));
		        // Store current System.out before assigning a new value
		        PrintStream console = System.out;
				System.setOut(output);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			Main.main(args);
	 }

}
