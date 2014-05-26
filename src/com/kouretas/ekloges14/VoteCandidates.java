package com.kouretas.ekloges14;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kouretas.ekloges14.extra.CandidateAdapter;
import com.kouretas.ekloges14.model.Ballot;
import com.kouretas.ekloges14.model.Candidate;
import com.kouretas.ekloges14.model.Ekloges14APP;
import com.kouretas.ekloges14.model.Party;

public class VoteCandidates extends Activity implements OnItemClickListener {

	private int partyId;
	private Party party;
	private ArrayList<Boolean> candidateSelected;
	private TextView partyName;
	private ListView candidatesListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vote_candidates);
		partyName = (TextView) findViewById(R.id.party_name);
		candidatesListView = (ListView) findViewById(R.id.check_candidates);
		// candidatesList.setOnItemClickListener(this);

		Intent startingIntent = getIntent();
		partyId = startingIntent.getExtras().getInt("partyId", 0);
		for (Party p : Ekloges14APP.parties) {
			if (partyId == p.getPoliticalPartyId()) {
				party = p;
				break;
			}
		}

		if (party != null) {
			candidateSelected = new ArrayList<Boolean>();
			for (int i = 0; i < party.getListOfCandidates().size(); i++) {
				candidateSelected.add(Boolean.valueOf(false));
			}

			partyName.setText(party.getName());
			CandidateAdapter adapter = new CandidateAdapter(this, R.layout.list_item_candidate,
					party.getListOfCandidates());
			candidatesListView.setAdapter(adapter);
			candidatesListView.setOnItemClickListener(this);
		}

	}

	public void registerBallot(View v) {
		int id = Ekloges14APP.ballots.size() + 1;
		ArrayList<Candidate> stavromenoi = new ArrayList<Candidate>();
		for (int j = 0; j < candidateSelected.size(); j++) {
			if (candidateSelected.get(j)) {
				stavromenoi.add(party.getListOfCandidates().get(j));
			}
		}
		if (stavromenoi.size() > 4) {
			Toast.makeText(this, "TOO MANY candidates", Toast.LENGTH_SHORT).show();
		} else {
			Ballot thisBallot = new Ballot(id, party, stavromenoi);
			party.addVote(thisBallot);
			for (Candidate candidate : stavromenoi) {
			candidate.addVote(thisBallot);
			}
			Ekloges14APP.ballots.add(thisBallot);

			finish();
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		boolean isSelected = candidateSelected.get(position);

		if (isSelected) {
			Toast.makeText(this, "candidate " + (position + 1) + " de-selected",
					Toast.LENGTH_SHORT).show();
		} else {
			// Toast.makeText(this, "candidate " + (position + 1) + " selected",
			// Toast.LENGTH_SHORT).show();
		}
		candidateSelected.set(position, Boolean.valueOf(!isSelected));

		String currentSelections = "";
		for (int i = 0; i < candidateSelected.size(); i++) {
			if (candidateSelected.get(i)) {
				currentSelections += String.valueOf(i + 1) + " - ";
			}
		}
		((TextView) findViewById(R.id.candidates_selections)).setText(currentSelections);
	}

}
