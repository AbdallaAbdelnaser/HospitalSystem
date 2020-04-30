package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bed.enums.BedStatus;
import flow.Helper;
import flow.UserInterface;
import view.enums.UserActions;
import ward.Bed;
import ward.Doctor;
import ward.Patient;

public class Ward {
	private List<Doctor> doctorList;
	private List<Patient> patientList;
	private UserInterface userInterface;
	private Bed[] beds;

	public Ward(int numOfBeds) {
		beds = new Bed[numOfBeds];
		Arrays.fill(beds, new Bed());
		doctorList = new ArrayList<>();
		patientList = new ArrayList<>();
		userInterface = new UserInterface();
	}

	public void run() {

		UserActions userActions = userInterface.printMenu();

		switch (userActions) {
		case ADD_PATIENT:
			addPatient();
			break;
		case ADD_DOCTOR:
			addDoctor();
			break;
		case ASSIGN_DOCTOR_TO_PATIENT:
			assignDoctor();
			break;
		case DISPLAY_EMPTY_BEDS:
			userInterface.displayBeds(beds);
			break;
		case ASSIGN_PATIENT_BED:
			assignPatientBed();
			break;
		case RELEASE_PATIENT:
			releasePatient();
			break;
		case DROP_DOCTOR_PATIENT:
			dropDoctorPatient();
			break;
		case DISPLAY_SYSTEM:
			displaySystem();
		case QUIT:
			return;
		}

		run();// invoke main menu again.
	}

	private void addPatient() {

		patientList.add(userInterface.patientDetails());

	}

	private void addDoctor() {

		doctorList.add(userInterface.doctorDetails());

	}

	private void assignDoctor() {

		int patientIdx = userInterface.seachPatientId(patientList);
		if (patientIdx == -1)
			return;
		Patient chosenPatient = patientList.get(patientIdx);
		int doctorIdx = userInterface.seachdoctorId(doctorList);
		if (doctorIdx == -1)
			return;
		Doctor chosenDoctor = doctorList.get(doctorIdx);

		if (chosenPatient.getDoctorsList().contains(chosenDoctor)) {
			System.out.println(chosenDoctor.getName() + " is already a doctor for this patient.");
			return;
		}

		chosenPatient.addDoctor(chosenDoctor);
		chosenDoctor.addPatient(chosenPatient);

	}

	private void dropDoctorPatient() {

		int patientIdx = userInterface.seachPatientId(patientList);
		if (patientIdx == -1)
			return;
		Patient chosenPatient = patientList.get(patientIdx);

		int doctorIdx = userInterface.seachdoctorId(chosenPatient.getDoctorsList());
		if (doctorIdx == -1)
			return;
		Doctor chosenDoctor = doctorList.get(doctorIdx);

		chosenDoctor.removePatient(chosenPatient);
		chosenPatient.removeDoctor(chosenDoctor);

	}

	private void assignPatientBed() {
		int patientIdx = userInterface.seachPatientId(patientList);
		if (patientIdx == -1)
			return;
		Patient chosenPatient = patientList.get(patientIdx);
		if (chosenPatient.getBedIdx() != -1) {
			System.out.println("This patien is already in a bed so cannot be assigned a new bed");
			return;
		}
		int bedIdx = userInterface.reserveBed(beds);
		if (bedIdx == -1)
			return;
		chosenPatient.setBedIdx(bedIdx);
		Bed chosenBed = new Bed(chosenPatient, BedStatus.unavailable, bedIdx);
		beds[bedIdx] = chosenBed;

	}

	private void releasePatient() {

		int patientIdx = userInterface.seachPatientId(patientList);
		if (patientIdx == -1)
			return;
		Patient chosenPatient = patientList.get(patientIdx);
		if (chosenPatient.getBedIdx() == -1) {
			System.out.println("The patient is not assigned to any bed.");
			return;
		}
		int bedIdx = chosenPatient.getBedIdx();
		chosenPatient.setBedIdx(-1);
		beds[bedIdx] = new Bed();

	}

	private void displaySystem() {
		if (patientList.size() != 0) {

			System.out.println("Patients in System.\n");
			for (Patient patient : patientList)
				patient.printDetails();

		} else
			System.out.println("There aren't any Patients.\n");

		if (doctorList.size() != 0) {
			System.out.println("Doctors in System.\n");
			for (Doctor doctor : doctorList)
				doctor.printDetails();

		} else
			System.out.println("There aren't any Doctors.\n");

		System.out.println("The Ward has " + beds.length + " beds.\n");
		for (int i=0;i<beds.length;i++) {
			System.out.print("Bed "+(i+1)+":");
			if(beds[i].getBedStatus().equals(BedStatus.available))
				System.out.println("Empty");
			else 
				System.out.println(beds[i].getPatient().getName());

		}

	}

}
