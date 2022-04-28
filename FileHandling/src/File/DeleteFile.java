package File;
import java.io.File;
public class DeleteFile {
	public static void main(String[] args)
	{
		File f = new File("C:\\Users\\EB197TS\\eclipse-workspace\\zoho\\FileHandling\\folderdeletetest");
		if(f.delete())
		{
			System.out.println("Folder deleted successfully");
		}
		else
		{
			System.out.println("Cannot delete");
		}
		
	}

}
