package ward;

import java.util.ArrayList;
import java.util.List;

public class Doctor {

	private String name;
	private String isSurgeon;
	private List<Patient> patientList;
	private static int numOfDoctors;
	private String docId;

	public List<Patient> getPatientList() {
		return patientList;
	}


	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public Doctor(String name, String isSurgeon) {
		patientList = new ArrayList<>();
		numOfDoctors++;
		this.name = name;
		this.isSurgeon = isSurgeon;
		docId="Doc"+numOfDoctors;

	}


	public String getDocId() {
		return docId;
	}


	public void setDocId(String docId) {
		this.docId = docId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String isSurgeon() {
		return isSurgeon;
	}

	public void setSurgeon(String isSurgeon) {
		this.isSurgeon = isSurgeon;
	}

	public void addPatient(Patient p) {
		patientList.add(p);
	}

	public void removePatient(Patient p) {
		patientList.remove(p);
	}
	public boolean searchId(String id) {
		
		return this.docId.equals(id);
		
	}

	public void printDetails() {
		System.out.print("Name:" + name + "\nSurgeon?" + isSurgeon + "\npatients:[");
		for (int i = 0; i < patientList.size(); i++) {
			if (i == patientList.size() - 1)
				System.out.println(patientList.get(i).getPatientId() + "]");
			else
				System.out.print(patientList.get(i).getPatientId() + ",");
		}
		System.out.println();

	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null||!(obj instanceof Doctor))
			return false;
		
		return (((Doctor)(obj)).isSurgeon.equals(isSurgeon)&&((Doctor)(obj)).name.equals(name)&&((Doctor)(obj)).patientList.equals(patientList)&&((Doctor)(obj)).docId.equals(docId));
		
	}

}
