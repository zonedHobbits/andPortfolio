package com.example.zonedhobbitsportfolio;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ProjectActivity extends Activity {

	//Declare objects.
	TextView header;
	TextView tagline;
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
		tagline = (TextView) findViewById(R.id.text_tagline_project);
		desc = (TextView) findViewById(R.id.text_desc_project);
		lvImg = (ListView) findViewById(R.id.list_project);
		
		//Recover he extras sent to the activity from ProfileActivity.
		i = getIntent();
		p = ProfileActivity.returnProject(i.getIntExtra("pos", 0));
		
		Log.i("P.SHOTS", p.getShots().toString());
		
		//Set the adapter to the ListView
		CustomAdapter imgAdapter = new CustomAdapter(this, lvImg.getId(), p.getShots());
		lvImg.setAdapter(imgAdapter);
		
		setListViewHeightBasedOnChildren(lvImg);
		
		//	Set values
		setValues();
		
		//	Test fonts        		
        Typeface EdmondBold = Typeface.createFromAsset(getAssets(),"fonts/Edmondsans-Bold.otf");
        Typeface EdmondMed = Typeface.createFromAsset(getAssets(), "fonts/Edmondsans-Medium.otf");
        Typeface Edmond = Typeface.createFromAsset(getAssets(), "fonts/Edmondsans-Regular.otf");
        
        Typeface PTSans = Typeface.createFromAsset(getAssets(), "fonts/PTSans.ttc");
        
        header.setTypeface(EdmondBold);
        tagline.setTypeface(PTSans, Typeface.ITALIC);
        desc.setTypeface(PTSans);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.project, menu);
		return true;
	}
	
	public void setValues() {
		header.setText(p.getName());
		tagline.setText(p.getTagline());
		desc.setText(p.getDesc());
	}
	
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter(); 
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

}
