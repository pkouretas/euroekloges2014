package com.kouretas.ekloges14.extra;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kouretas.ekloges14.model.Candidate;

public class CandidateAdapter extends ArrayAdapter<Candidate> {

	Context context;
	int layoutResourceId;
	List<Candidate> data = null;
	    
	public CandidateAdapter(Context context, int layoutResourceId, List<Candidate> objects) {
		super(context, layoutResourceId, objects);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.data = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			convertView = inflater.inflate(layoutResourceId, parent, false);
		}
		
		((TextView) convertView.findViewById(android.R.id.text1)).setText(String
				.valueOf(position + 1) + ". " + data.get(position).getName());
		
		return convertView;
	}
	
}
