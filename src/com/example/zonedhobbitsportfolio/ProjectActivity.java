package com.example.zonedhobbitsportfolio;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class ProjectActivity extends Activity {

	//Declare objects.
	TextView header;
	TextView desc;
	ListView lvImg;
	
	String header_text;
	String desc_text;
	Bitmap[] shots;
	Intent i;
	Project p;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project);
		
		header = (TextView) findViewById(R.id.text_header_project);
		desc = (TextView) findViewById(R.id.text_desc_project);
		lvImg = (ListView) findViewById(R.id.list_project);
		
		//Recover he extras sent to the activity from ProfileActivity.
		i = getIntent();
		p = ProfileActivity.returnProject(i.getIntExtra("pos", 0));
		
		Log.i("P.SHOTS", p.toString());
		
		//Set the adapter to the ListView
		CustomAdapter imgAdapter = new CustomAdapter(this, lvImg.getId(), p.getShots());
		lvImg.setAdapter(imgAdapter);
		
		//	Set values
		setValues();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.project, menu);
		return true;
	}
	
	public void setValues() {
		header.setText(p.getName());
		desc.setText(p.getDesc());
	}

}
