package com.kouretas.ekloges14.model;

import java.util.ArrayList;

public class Candidate {

	private final String name;
	private final Party parataxi;
	private ArrayList<Ballot> myVotes = new ArrayList<Ballot>();

	public String getName() {
		return name;
	}
	public Party getParty() {
		return parataxi;
	}

	public Candidate(String name, Party parataxi) {
		this.name = name;
		this.parataxi = parataxi;
	}

	public ArrayList<Ballot> getBallots() {
		return myVotes;
	}

	public void addVote(Ballot ballot) {
		this.myVotes.add(ballot);
	}

}
