package com.example.zonedhobbitsportfolio;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Object> {
	
	private Context context;
	private Object[] values;
	private int Iterator;
	
	private int checkId;
	private int setLayout;

	public CustomAdapter(Context context, int resource, Object[] values) {
		super(context, resource, values);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.values = values;
		
		checkId = resource;
		
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(setLayout(), parent, false);
		
		Log.i("*****VALUES****", values.toString());
		// Fill fields
		fillLayout(rowView);
		
		if(Integer.toString(Iterator) == null) {
			Iterator = 0;
		}
		if(Iterator <= (values.length - 2)) {
			Iterator++;
		}
		
		return rowView;
		
	}
	
	
	public int setLayout(){
		
		if(checkId == R.id.list_main) {
			return R.layout.main_list_row;
		}
		/*else if(checkId == R.id.list_profile) {
			return R.layout.project_list_row;
		}
		else{
			
		}
		*/
		
		return 0;
	}
	
	public void fillLayout(View rowView){
		
		if(checkId == R.id.list_main) {
			//FILL FIELDS
			
			ImageView normalImg = (ImageView) rowView.findViewById(R.id.imageView);
			TextView name = (TextView) rowView.findViewById(R.id.name);
			TextView nickName = (TextView) rowView.findViewById(R.id.nickName);
			
			Log.i("******Values["+String.valueOf(Iterator)+"]", ((Person) values[Iterator]).getName());
						
			//normalImg.setImageBitmap(values[0]);

		}
		/*
		else if(checkId == R.id.list_profile) {
			//FILL FIELDS
		}
		*/
		
	}

}
