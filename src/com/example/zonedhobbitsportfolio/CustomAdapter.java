package com.example.zonedhobbitsportfolio;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class CustomAdapter extends ArrayAdapter<Object> {
	
	private Context context;
	private Object[] values;
	
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
		
		Object rowItem = getItem(position);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(setLayout(), parent, false);
		
		// Fill fields
		fillLayout(rowView, rowItem, parent);
		
		Log.i("FU", values.toString());
		
		return rowView;
	}
	
	public int setLayout(){
		
		if(checkId == R.id.list_main) {
			return R.layout.main_list_row;
		}
		else if(checkId == R.id.list_selectedwork) {
			return R.layout.project_list_row;
		}
		else if(checkId == R.id.list_project){
			return R.layout.project_img_row;
		}
		
		
		return 0;
	}
	
	public void fillLayout(View rowView, Object rowItem, final ViewGroup parent){
		
		if(checkId == R.id.list_main) {
			//FILL FIELDS
			
			ImageView normalImg = (ImageView) rowView.findViewById(R.id.imageView);
			TextView name = (TextView) rowView.findViewById(R.id.name);
			TextView nickName = (TextView) rowView.findViewById(R.id.nickName);
			
			Typeface font = Typeface.createFromAsset(context.getAssets(),"fonts/Edmondsans-Medium.otf");
			
			normalImg.setImageBitmap(((Person) rowItem).getNormal_img());
			
			name.setText(((Person) rowItem).getName().replaceFirst(" ", "\n").toUpperCase());
			
			nickName.setText("A.K.A "+((Person) rowItem).getNickName().toUpperCase());
			
			name.setTypeface(font);
			nickName.setTypeface(font);
						
			//normalImg.setImageBitmap(values[0]);

		} else if(checkId == R.id.list_selectedwork) {
			//FILL FIELDS
			ImageView thumbholder = (ImageView) rowView.findViewById(R.id.thumbholder);
			//TextView projectName = (TextView) rowView.findViewById(R.id.projectname);
			//TextView projectType = (TextView) rowView.findViewById(R.id.projecttype);

			//projectName.setText(((Project) rowItem).getName());
			//projectType.setText(((Project) rowItem).getType());
			thumbholder.setImageBitmap(((Project) rowItem).getThumbnail());
			

		} else if(checkId == R.id.list_project) {
			//CONTINUE HERE.
			int position = getPosition(rowItem);
			
			final ImageView projectImage = (ImageView) rowView.findViewById(R.id.projectImageView);
			final ListView list_p = (ListView) parent;
			
			
				projectImage.setImageBitmap(((Bitmap) rowItem));
				
				
				
		}
			
	}
		
}


