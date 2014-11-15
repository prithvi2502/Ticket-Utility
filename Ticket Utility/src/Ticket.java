
public class Ticket {
	private String id;
	private String problemName;
	private String Discription;
	private String dateIssued;
	private String DateDoneBy;
	private String FixType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProblemName() {
		return problemName;
	}
	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
	public String getDateIssued() {
		return dateIssued;
	}
	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}
	public String getDateDoneBy() {
		return DateDoneBy;
	}
	public void setDateDoneBy(String dateDoneBy) {
		DateDoneBy = dateDoneBy;
	}
	public String getFixType() {
		return FixType;
	}
	public void setFixType(String fixType) {
		FixType = fixType;
	}
	
}
