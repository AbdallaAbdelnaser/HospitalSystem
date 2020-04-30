package ward;

import java.util.ArrayList;
import java.util.List;

public class Patient {

	private int bedIdx;
	private String name;
	private String patientId;
	private static int numOfPatients;
	private List<Doctor> doctorsList;

	public List<Doctor> getDoctorsList() {
		return doctorsList;
	}

	public void setDoctorsList(List<Doctor> doctorsList) {
		this.doctorsList = doctorsList;
	}

	public Patient(String name) {
		this.name = name;
		numOfPatients++;
		patientId = "P0" + numOfPatients;
		doctorsList = new ArrayList<>();
		bedIdx = -1;
	}

	public int getBedIdx() {
		return bedIdx;
	}

	public void setBedIdx(int b) {
		this.bedIdx = b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public boolean searchId(String id) {

		return this.patientId.equals(id);

	}

	public void addDoctor(Doctor d) {
		doctorsList.add(d);
	}

	public void removeDoctor(Doctor d) {
		doctorsList.remove(d);
	}

	public void printDetails() {
		System.out.print("Name:" + name + "\nID:" + patientId + "\nBed:" + ((bedIdx==-1)?"doesn't have":bedIdx) + "\nDoctors:[");
		for (int i = 0; i < doctorsList.size(); i++) { 
			if (i == doctorsList.size() - 1)
				System.out.println(doctorsList.get(i).getName() + "]");
			else
				System.out.print(doctorsList.get(i).getName() + ",");
		}
		System.out.println();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Patient))
			return false;

		return (((Patient) (obj)).name.equals(name) && ((Patient) (obj)).patientId.equals(patientId)
				&& ((Patient) (obj)).doctorsList.equals(doctorsList) && ((Patient) (obj)).bedIdx == (bedIdx));

	}

}
