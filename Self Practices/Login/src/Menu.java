import java.util.Scanner;

public class Menu {

	public static void main(String[] args)
	{
		Scanner sc =  new Scanner(System.in);
		int choice = sc.nextInt();
		do {
			printMenu();
			switch (choice)
			{
			case 1:
				Signup();
				break;
			case 2:
				Login();
				break;
			}
		}while(choice>1 && choice <2)
	}
	public static void printMenu()
	{
		System.out.println ( "----Welcome----");
		System.out.println ("1. Signup");
		System.out.println("2. Login");
	}
}
