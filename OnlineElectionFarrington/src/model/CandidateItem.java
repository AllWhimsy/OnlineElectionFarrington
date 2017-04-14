package model;
//Michelle Farrington

public class CandidateItem {
	private String election;
	private String cand1Name;
	private String cand2Name;
	private String cand3Name;
	
	public CandidateItem(String election, String cand1Name, String cand2Name, String cand3Name) {
		this.election = election;
		this.cand1Name = cand1Name;
		this.cand2Name = cand2Name;
		this.cand3Name = cand3Name;
	}
	
	public String getElection() {
		return election;
	}
	
	public String getCand1Name() {
		return cand1Name;
	}
	public void setCand1Name(String cand1Name) {
		this.cand1Name = cand1Name;
	}
	
	public String getCand2Name() {
		return cand2Name;
	}
	public void setCand2Name(String cand2Name) {
		this.cand2Name = cand2Name;
	}
	
	public String getCand3Name() {
		return cand3Name;
	}
	public void setCand3Name(String cand3Name) {
		this.cand3Name = cand3Name;
	}
	
	public String toString(){
		return this.election + ": " + cand1Name + ", " + cand2Name + ", " + cand3Name;
	}
	
	public CandidateItem() {

	}
	
}
