package 입출력;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamMain {

	public static void main(String[] args) throws Exception{
		PrintStream pout=new PrintStream(new FileOutputStream("printMethod.txt"));
		pout.write(65);
		pout.print("A");
		
		
		
	}

}
