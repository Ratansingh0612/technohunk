package test;
import java.io.*;

public class ReadFile {

	public static void main(String[] args)throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("C:\\try\\a.txt"));
		String line = in.readLine();
		while(line != null)
		{
		  System.out.println(line);
		  line = in.readLine();
		}
		in.close();
	}
}
