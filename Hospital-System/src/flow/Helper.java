package flow;
import java.util.Scanner;

public class Helper {

	private static Scanner in = new Scanner(System.in);

	// print Menu
	public static void printList(String arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.println("[" + (i + 1) + "] " + arr[i] + "\n");
	}

	// read a period and validate wrong input
	public static int readInt(int low, int high) {

		System.out.print("Enter Your Choice:");
		int choice = 0;

		try {

			choice = in.nextInt();

			if (choice < low || choice > high) {
				choice=0;
				throw new Exception();
			}
		} catch (Exception e) {

			System.out.println("Invalid Input , Please Enter an integer in range [" + low + "," + high + "]");
			in.nextLine();
			choice+=readInt(low, high);

		}
		return choice;

	}

	// read integer and validate wrong input
	public static int readInt() {

		int choice = 0;

		try {

			choice = in.nextInt();
			
			if(choice<=0)
			{
				choice=0;
				throw new Exception();

			}
			
			

		} catch (Exception e) {

			System.out.print("Invalid Input , Please try again:");
			in.nextLine();
			choice+=readInt();

		}
		return choice;

	}

	// read double and validate wrong input

	public static double readDouble() {

		double choice = 0;

		try {

			choice = in.nextInt();

		} catch (Exception e) {

			System.out.print("Invalid Input , Please try again:");
			in.nextLine();
			readDouble();

		}

		return choice;

	}

	/*
	// check password is correct or not
	public static boolean checkAdmin(String password) {
		System.out.print("Please Enter your Administrator password:");
		String pass = in.next();
		while(!pass.equals(password))
		{
			System.out.println("Wrong Password.\n");
			if(ask())
			{
				System.out.print("Please Enter your Administrator password:");
				pass=in.next();
			}
			else 
				break;
			
			
			
		}
		boolean correctPass=pass.equals(password);
		
		if(correctPass)
			return true;
		return false;
		
		
		
	}
*/
	// ask user to back or continue
	public static boolean ask() {

		System.out.print("Continue(Y/N):");
		String choice = "Y";
		do {
			if (!(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("y")
					|| choice.equalsIgnoreCase("n")))
				System.out.print("Wrong Input , please Enter Y or N :");

			choice = in.next();

		} while (!(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("y")
				|| choice.equalsIgnoreCase("n")));
		System.out.println();//new line
		if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("Y"))
			return true;
		else
			return false;

	}

	
}
