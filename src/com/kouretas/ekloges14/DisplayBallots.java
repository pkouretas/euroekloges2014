package com.kouretas.ekloges14;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kouretas.ekloges14.extra.BallotsAdapter;
import com.kouretas.ekloges14.model.Ballot;
import com.kouretas.ekloges14.model.Candidate;
import com.kouretas.ekloges14.model.Ekloges14APP;

public class DisplayBallots extends Activity
		implements
			OnItemClickListener,
			OnItemLongClickListener {

	private TextView ballotsCount;
	private ListView mListView;
	private BallotsAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_ballots);

		ballotsCount = (TextView) findViewById(R.id.total_numof_ballots);

		// setup ArrayAdapter for the Political Parties
		adapter = new BallotsAdapter(this, R.layout.list_item_ballot,
				Ekloges14APP.ballots);

		mListView = (ListView) findViewById(R.id.ballots_list);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(this);
		mListView.setOnItemLongClickListener(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
		ballotsCount.setText("Συνολικός αριθμός έγκυρων ψηφοδελτίων: "
				+ Ekloges14APP.ballots.size());
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		String theChosenOnes = "";
		if (Ekloges14APP.ballots.get(position).getPeople() == null
				|| Ekloges14APP.ballots.get(position).getPeople().size() == 0) {
			theChosenOnes = "Το συγκεκριμένο ψηφοδέλτιο δεν περιείχε σταυρούς";
		} else {
			for (Candidate person : Ekloges14APP.ballots.get(position).getPeople()) {
				theChosenOnes += "\n" + person.getName();
			}
		}

		Toast.makeText(this, theChosenOnes, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {

		// which Ballot we're going to remove
		Ballot deadBallot = Ekloges14APP.ballots.get(pos);

		// remove the dead Ballot from the Party's ballots
		deadBallot.getParty().getBallots().remove(deadBallot);

		// also remove from each Candidate's ballots
		for (Candidate mourningCandidate : deadBallot.getPeople()) {
			mourningCandidate.getBallots().remove(deadBallot);
		}

		// remove from the Ballot repository
		Ekloges14APP.ballots.remove(deadBallot);

		adapter.notifyDataSetChanged();
		Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
		ballotsCount.setText("Συνολικός αριθμός έγκυρων ψηφοδελτίων: "
				+ Ekloges14APP.ballots.size());
		return true;
	}

}
