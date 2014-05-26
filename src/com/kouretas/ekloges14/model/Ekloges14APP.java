package com.kouretas.ekloges14.model;

import java.util.ArrayList;

import android.app.Application;
import android.util.Log;

public class Ekloges14APP extends Application {

	public static ArrayList<Party> parties = new ArrayList<Party>();
	public static ArrayList<Candidate> candidates = new ArrayList<Candidate>();
	public static ArrayList<Ballot> ballots = new ArrayList<Ballot>();

	public static ArrayList<String[]> candidates_by_party = new ArrayList<String[]>();

	@Override
	public void onCreate() {
		super.onCreate();
		 initializeCandidatesByParty();
		
		 // Construct Parties POJO in memory
		 registerParties();
		
		 // Construct Candidates POJO in memory
		 registerCandidates();
	}


	/*  */
	private void registerParties() {
		for (int i = 0; i < EklogesHelper.POLITICAL_PARTY_NAMES.length; i++) {
			parties.add(new Party(i + 1, EklogesHelper.POLITICAL_PARTY_NAMES[i]));
		}
	}


	private void registerCandidates() {
		for (int i = 0; i < parties.size(); i++) {
			Party thisParty = parties.get(i);
			String[] partyCandidates = candidates_by_party.get(i);
			if (i == 16) {
				Log.d("", "");
			}
			for (String candidateName : partyCandidates) {
				Candidate c = new Candidate(candidateName, thisParty);
				candidates.add(c);
				thisParty.addCandidate(c);
			}
		}
	}


	private void initializeCandidatesByParty() {
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_01);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_02);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_03);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_04);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_05);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_06);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_07);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_08);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_09);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_10);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_11);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_12);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_13);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_14);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_15);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_16);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_17);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_18);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_19);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_20);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_21);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_22);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_23);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_24);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_25);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_26);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_27);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_28);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_29);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_30);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_31);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_32);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_33);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_34);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_35);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_36);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_37);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_38);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_39);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_40);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_41);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_42);
		candidates_by_party.add(EklogesHelper.CANDIDATES_PARTY_43);
	}
}