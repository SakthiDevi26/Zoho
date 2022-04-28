package File;
import java.io.File;
import java.io.IOException;
public class CreateFile {

	public static void main(String[] args)
	{
		try {
		File f = new File("firstfile1.txt");
		if(f.createNewFile())
		{
			System.out.println("File created Successfully :" +f.getAbsolutePath());
		}
		else
		{
			System.out.println("File already exists");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
