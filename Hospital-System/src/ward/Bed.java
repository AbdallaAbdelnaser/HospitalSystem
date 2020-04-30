package ward;
import bed.enums.BedStatus;

public class Bed {
	
	private Patient patient;
	private BedStatus bedStatus;
	private int bedIdx;
	public int getBedIdx() {
		return bedIdx;
	}
	
	public void setBedIdx(int bedIdx) {
		this.bedIdx = bedIdx;
	}

	public Bed() {
		this.bedStatus=BedStatus.available;
	}
	public Bed(Patient patient,BedStatus bedStatus,int bedIdx) {
		this.patient=patient;
		this.bedIdx=bedIdx;
		this.bedStatus=bedStatus;
	}

	public BedStatus getBedStatus() {
		return bedStatus;
	}

	public void setBedStatus(BedStatus bedStatus) {
		this.bedStatus = bedStatus;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null||!(obj instanceof Bed))
			return false;
		return (((Bed)(obj)).bedStatus.equals(bedStatus)&&((Bed)(obj)).bedIdx==bedIdx&&((Bed)(obj)).patient.equals(patient));

		
	}
	
	
	
	
	
}
