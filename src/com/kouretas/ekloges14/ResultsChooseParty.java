package com.kouretas.ekloges14;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.kouretas.ekloges14.extra.PartyAdapter;
import com.kouretas.ekloges14.model.Ekloges14APP;

public class ResultsChooseParty extends Activity implements OnItemClickListener {

	private ListView partyListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results_choose_party);

		// ballotsCount = (TextView) findViewById(R.id.ballots_count);
		
		// setup ArrayAdapter for the Political Parties
		PartyAdapter adapter = new PartyAdapter(this, R.layout.list_item_party,
				Ekloges14APP.parties);

		partyListView = (ListView) findViewById(R.id.party_listview);
		partyListView.setAdapter(adapter);
		partyListView.setOnItemClickListener(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		Intent i = new Intent(this, ResultsCandidates.class);
		i.putExtra("partyId", Ekloges14APP.parties.get(position).getPoliticalPartyId());
		startActivity(i);
	}

}
