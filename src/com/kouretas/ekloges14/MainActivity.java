package com.kouretas.ekloges14;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the action bar to show a dropdown list.
        final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		// actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        // Set up the dropdown list navigation in the action bar.
		/*
		 * actionBar.setListNavigationCallbacks( // Specify a SpinnerAdapter to
		 * populate the dropdown list. new ArrayAdapter<String>(
		 * actionBar.getThemedContext(), android.R.layout.simple_list_item_1,
		 * android.R.id.text1, new String[] {
		 * getString(R.string.title_section1),
		 * getString(R.string.title_section2),
		 * getString(R.string.title_section3), }), this);
		 */
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore the previously serialized current dropdown position.
		// if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
		// getActionBar().setSelectedNavigationItem(
		// savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		// }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Serialize the current dropdown position.
		// outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
		// getActionBar().getSelectedNavigationIndex());
    }

	public void gotoVoteParty(View v) {
		Intent i = new Intent(this, VoteParty.class);
		startActivity(i);
	}

	public void seeResultsParties(View v) {
		Intent i = new Intent(this, ResultsParties.class);
		startActivity(i);
	}

	public void seeResultsCandidates(View v) {
		Intent i = new Intent(this, ResultsChooseParty.class);
		startActivity(i);
	}

	public void seeBallots(View v) {
		Intent i = new Intent(this, DisplayBallots.class);
		startActivity(i);
	}

}
