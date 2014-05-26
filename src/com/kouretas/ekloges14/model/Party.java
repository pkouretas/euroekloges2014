package com.kouretas.ekloges14.model;

import java.util.ArrayList;

public class Party {

	private int politicalPartyId;
	private ArrayList<Candidate> ourBoys = new ArrayList<Candidate>();
	private ArrayList<Ballot> ourVotes = new ArrayList<Ballot>();

	public int getPoliticalPartyId() {
		return politicalPartyId;
	}
	public void setPoliticalPartyId(int politicalPartyId) {
		this.politicalPartyId = politicalPartyId;
	}

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Party(int id, String name) {
		this.setPoliticalPartyId(id);
		this.setName(name);
	}

	public void addCandidate(Candidate c) {
		ourBoys.add(c);
	}

	public ArrayList<Candidate> getListOfCandidates() {
		return ourBoys;
	}
	public void addVote(Ballot ballot) {
		this.ourVotes.add(ballot);
	}
	public ArrayList<Ballot> getBallots() {
		return ourVotes;
	}
}
