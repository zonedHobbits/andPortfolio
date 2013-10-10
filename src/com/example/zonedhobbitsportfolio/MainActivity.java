package com.example.zonedhobbitsportfolio;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	ListView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        test = (ListView) findViewById(R.id.list_main);
        
        test.setScrollContainer(false);
        
        Person[] arraypersons = new Person[3];
        
        // Just for test purposes
        
        //arraypersons[0] = new Person("Albin", null, null, null, null, null, null, null, null, null, null, null);
        //arraypersons[1] = new Person("Fredrik", null, null, null, null, null, null, null, null, null, null, null);
        //arraypersons[2] = new Person("Martin", null, null, null, null, null, null, null, null, null, null, null);
        
        CustomAdapter test1 = new CustomAdapter(this, test.getId(), arraypersons);
        
        test.setAdapter(test1);
        
        //Test fonts
        
<<<<<<< HEAD
        Log.i("***HEIGHT", String.valueOf(height));

        Person martin = null;
        this.setUpInfo("http://puertosur.com.ar/Martin/andPorfolio/zhPortfolioAPI.php", martin);
        //this.setUpInfo("http://fredrik-andersson.se/zh/zhPortfolioAPI.php");
        //this.setUpInfo("http://alphahw.eu/zh/zhPortfolioAPI.php");
=======
        TextView myTextView=(TextView)findViewById(R.id.text_header_main);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Edmondsans-Bold.otf");
        myTextView.setTypeface(typeFace);

        this.setUpInfo("http://puertosur.com.ar/Martin/andPorfolio/zhPortfolioAPI.php");
        this.setUpInfo("http://fredrik-andersson.se/zh/zhPortfolioAPI.php");
        this.setUpInfo("http://alphahw.eu/zh/zhPortfolioAPI.php");
>>>>>>> 1dc70382c466132dac9b7e69a381070669d3aa25

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void setUpInfo(String url, Person name) {
    	new Fetcher(name).execute(url);
    }
    
    public void moveToProfile(View v){
    	
    	Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
        
        //We need to pass through some kind of data to know which profile clicked.
    
    }
    
}
