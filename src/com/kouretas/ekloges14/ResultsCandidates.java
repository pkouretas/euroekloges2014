package com.kouretas.ekloges14;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import com.kouretas.ekloges14.model.Candidate;
import com.kouretas.ekloges14.model.Ekloges14APP;
import com.kouretas.ekloges14.model.Party;

public class ResultsCandidates extends Activity{

	private LinearLayout rootView;
	//private String computedResults = "";
	private int partyId;
	private Party thisParty;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results_candidates);
			
		rootView = (LinearLayout) findViewById(R.id.candidate_results_container);
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
		TableRow.LayoutParams mTableRowParams = new TableRow.LayoutParams(31,
					LayoutParams.WRAP_CONTENT);
		mTableRowParams.setMargins(1, 1, 0, 0);

		TableLayout.LayoutParams mTableLayoutParams = new TableLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, 45);
		mTableLayoutParams.setMargins(0, 0, 0, 0);


		Intent startingIntent = getIntent();
		partyId = startingIntent.getExtras().getInt("partyId", 0);
		for (Party p : Ekloges14APP.parties) {
			if (partyId == p.getPoliticalPartyId()) {
				thisParty = p;
				break;
			}
		}

		for (Candidate candidate : thisParty.getListOfCandidates()) {

				LinearLayout candidateResultTable = (LinearLayout) inflater.inflate(
						R.layout.grid_result_table, rootView, false);
				((TextView) candidateResultTable.findViewById(R.id.grid_result_table_header)).setText(candidate.getName());
				TableLayout ballotsTable = (TableLayout) candidateResultTable
						.findViewById(R.id.ballot_id_list);

				/*
				 * Add rows
				 */
				TableRow row = new TableRow(this);
				int i = 0;
				for (i = 0; i < candidate.getBallots().size(); i++) {
					TextView ballotNum = new TextView(this);
					ballotNum.setBackgroundColor(getResources().getColor(android.R.color.white));
					ballotNum.setText(candidate.getBallots().get(i) != null ? String.valueOf(candidate
							.getBallots().get(i).getId() + 00) : "--");
					row.addView(ballotNum, mTableRowParams);

					if ((i + 1) % 15 == 0 && i != 0) {
						ballotsTable.addView(row, mTableLayoutParams);
						row = new TableRow(this);
					}
				}

				// fill up the remaining of the last row, if any
				if ((i + 1) % 15 != 0) {
					for (int j = (i + 1) % 15; j <= 15; j++) {
						TextView ballotNum = new TextView(this);
						ballotNum.setBackgroundColor(getResources().getColor(android.R.color.white));
						ballotNum.setText("");
						row.addView(ballotNum, mTableRowParams);
					}
				}
				ballotsTable.addView(row, mTableLayoutParams);

				// Add 2 extra lines rows, for pretty looks only
				row = new TableRow(this);
				for (int k = 0; k < 30; k++) {
					TextView ballotNum = new TextView(this);
					ballotNum.setBackgroundColor(getResources().getColor(android.R.color.white));
					ballotNum.setText("");
					row.addView(ballotNum, mTableRowParams);
					if ((k + 1) % 15 == 0 && k != 0) {
						ballotsTable.addView(row, mTableLayoutParams);
						row = new TableRow(this);
					}
				}

			rootView.addView(candidateResultTable);
		}

			// mTextView.setText(computedResults);

	}


}