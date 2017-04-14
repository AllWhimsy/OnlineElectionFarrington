package model;

//Michelle Farrington

public class ElectionTally {

	private int totalVotesOne;
	private int totalVotesTwo;
	private int totalVotesThree;
	private int allVotesTotal;
	private CandidateItem elect;

	public void votesForCandidateOne() {
		totalVotesOne++;
	}

	public int getTotalVotesOne() {
		return totalVotesOne;
	}

	public void votesForCandidateTwo() {
		totalVotesTwo++;

	}

	public int getTotalVotesTwo() {
		return totalVotesTwo;
	}

	public void votesForCandidateThree() {
		totalVotesThree++;

	}

	public int getTotalVotesThree() {
		return totalVotesThree;
	}

	public int getAllVotesTotal() {
		allVotesTotal = totalVotesOne + totalVotesTwo + totalVotesThree;
		return allVotesTotal;
	}

	public ElectionTally() {

	}
	
	public ElectionTally(CandidateItem c){
		elect = c;
	}

	public CandidateItem getElect() {
		return elect;
	}

	public void setElect(CandidateItem elect) {
		this.elect = elect;
	}
}
