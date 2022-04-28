package File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class ReadFile {
	public static void main(String[] args) throws FileNotFoundException
	{
		try {
			
		FileReader fr = new FileReader("firstfile.txt");
		Scanner sc = new Scanner(fr);
		while(sc.hasNextLine())
		{
			String data = sc.nextLine();
			System.out.println(data);
		}
		fr.close();
		}
		catch (Exception e)
		{
			System.out.println("Cannot read");
			e.printStackTrace();
		}
	}

}
