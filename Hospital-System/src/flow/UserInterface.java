package flow;

import java.util.List;
import java.util.Scanner;

import bed.enums.BedStatus;
import view.enums.UserActions;
import ward.Bed;
import ward.Doctor;
import ward.Patient;

public class UserInterface {
	Scanner in = new Scanner(System.in);
	Scanner spaces = new Scanner(System.in);

	public UserActions printMenu() {
		System.out.print("\n");
		String[] menu = { "Add a Patient", "Add a Doctor", "Assign a doctor to a Patient ", "Display the empty beds",
				"Assign a Patient to a Bed", "Release a Patient", "Drop Doctor-Patient Association",
				"Display Current System State", "Quit" };

		Helper.printList(menu);
		int choice = Helper.readInt(1, 9);

		switch (choice) {
		case 1:
			return UserActions.ADD_PATIENT;
		case 2:
			return UserActions.ADD_DOCTOR;
		case 3:
			return UserActions.ASSIGN_DOCTOR_TO_PATIENT;
		case 4:
			return UserActions.DISPLAY_EMPTY_BEDS;
		case 5:
			return UserActions.ASSIGN_PATIENT_BED;
		case 6:
			return UserActions.RELEASE_PATIENT;
		case 7:
			return UserActions.DROP_DOCTOR_PATIENT;
		case 8:
			return UserActions.DISPLAY_SYSTEM;
		case 9:
			return UserActions.QUIT;

		}
		return null; // impossible because of readInt()
	}

	public Patient patientDetails() {
		System.out.print("\nEnter the name of the patient:");
		String patientName = spaces.nextLine();
		Patient p = new Patient(patientName);
		System.out.println("Generated ID :" + p.getPatientId());

		return p;

	}

	public Doctor doctorDetails() {
		System.out.print("\nEnter the name of the doctor:");
		String doctorName = spaces.nextLine();
		System.out.print("Is the doctor a surgeon?(yes or no):");
		String choice;
		do {
			choice = in.next();
			if (!(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")
					|| choice.equalsIgnoreCase("no")))
				System.out.print("Wrong Input , Please try again:");

		} while (!(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")
				|| choice.equalsIgnoreCase("no")));
		Doctor d = new Doctor(doctorName, choice);
		System.out.println("Generated ID :" + d.getDocId());

		return d;

	}


	public int seachdoctorId(List<Doctor> doctors) {

		int counter = -1, res = -2;
		do {
			counter=-1;
			System.out.print("Enter doctorID :");
			String doctorId = in.next();

			for (Doctor doctor : doctors) {
				counter++;
				if (doctor.searchId(doctorId)) {
					res = counter;
					break;
				}
			}

			if (res == -2) {
				System.out.println("this doctor doesn't exist.\n");
				if (!Helper.ask())
					return -1;
			}

		} while (res == -2);

		return res;

	}

	public int seachPatientId(List<Patient> patients) {
		int counter = -1, res = -2;

		do {
			counter=-1;
			System.out.print("Enter patientID :");
			String patientId = in.next();

			for (Patient patient : patients) {
				counter++;
				if (patient.searchId(patientId)) {
					res = counter;
					break;
				}

			}

			if (res == -2) {
				System.out.println("this Patient doesn't exist.\n");
				if (!Helper.ask())
					return -1;
			}

		} while (res == -2);

		return res;

	}

	public void displayBeds(Bed[] beds) {
		System.out.print("The Empty beds are [");
		
		for(int i=0;i<beds.length;i++)
		{
			if(i==beds.length-1)
				System.out.println((i+1)+"]");
			else 
			System.out.print((i+1)+",");
			
			
		}
		
		
		
		
	}
	
	public int reserveBed(Bed[] beds) {
		System.out.println("Enter the bed number for the patient.");
		int bedIdx=Helper.readInt(1,beds.length)-1;
		if(beds[bedIdx].getBedStatus().equals(BedStatus.unavailable))
		{
			System.out.println("This Bed is not available.");
			return -1;
		}
		return bedIdx;
		
		
		
		
	}

}
