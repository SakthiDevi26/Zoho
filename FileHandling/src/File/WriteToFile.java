package File;
import java.io.FileWriter;
public class WriteToFile {
	public static void main(String[] args)
	{
		try {
		FileWriter fw = new FileWriter("firstfile.txt");
		fw.write("This is the first text in file");
		fw.close();
		 System.out.println("Successfully wrote to the file.");
		}
		catch(Exception e)
		{
			 System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}
}
