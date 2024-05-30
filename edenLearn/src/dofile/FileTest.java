package dofile;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		

		File f=new File("c:\\edenTeach\\bb\\cc");
		
		boolean mkdir = f.mkdir();
		//f.delete();
		System.out.println(mkdir);
		
		File f1=new File("c:\\edenTeach\\aa\\2.txt");
		
		 f1.createNewFile();
		//System.out.println(newFile);
		//f1.delete();

	}

}
