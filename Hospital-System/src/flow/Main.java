package flow;
import controller.Ward;

public class Main {

	public static void main(String[] args) {

		System.out.print("Enter Number of Beds:");
		int choice=Helper.readInt();
		Ward ward=new Ward(choice);
		ward.run();
		
		
		
		
		
		
	}

}
