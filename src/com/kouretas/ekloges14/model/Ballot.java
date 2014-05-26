package com.kouretas.ekloges14.model;

import java.util.ArrayList;

public class Ballot {

	private int id;
	private Party party;
	private ArrayList<Candidate> people = new ArrayList<Candidate>();

	public Ballot(int id, Party p, ArrayList<Candidate> stavromenoi) {
		this.id = id;
		this.party = p;
		if (stavromenoi != null && stavromenoi.size() > 0) {
			for (Candidate candidate : stavromenoi) {
				this.people.add(candidate);
			}
		}
	}
	public int getId() {
		return id;
	}
	public Party getParty() {
		return this.party;
	}
	public ArrayList<Candidate> getPeople() {
		return this.people;
	}

}
