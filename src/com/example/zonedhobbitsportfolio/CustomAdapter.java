package com.example.zonedhobbitsportfolio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CustomAdapter extends ArrayAdapter<Object> {
	
	private Context context;
	private Object[] values;

	public CustomAdapter(Context context, int resource, Object[] values) {
		super(context, resource, values);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.values = values;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.project_list_row, parent, false);
		
		return rowView;
		
	}

}
