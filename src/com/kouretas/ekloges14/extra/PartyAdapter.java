package com.kouretas.ekloges14.extra;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kouretas.ekloges14.model.Party;

public class PartyAdapter extends ArrayAdapter<Party> {

	Context context;
	int layoutResourceId;
	List<Party> data = null;
	    
	public PartyAdapter(Context context, int layoutResourceId, List<Party> objects) {
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
		
		((TextView) convertView.findViewById(android.R.id.text1)).setText(data.get(position)
				.getPoliticalPartyId() + ". " + data.get(position).getName());
		
		return convertView;
	}
	
}
