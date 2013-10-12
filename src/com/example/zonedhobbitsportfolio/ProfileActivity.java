package com.example.zonedhobbitsportfolio;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.Html;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends Activity {

	Person p;
	
	TextView profileText;
    ImageView funImg;
    TextView quote;
    TextView bio;
    TextView contactHeader;
    TextView contact;
    TextView projectListHeader;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		//	Receive & unpack package
		Intent i = getIntent();
		i.getExtras();
		p = (Person) i.getParcelableExtra("pOi");
		
		//	Grab view resources
        profileText = (TextView) findViewById(R.id.text_header_profile);
        
        funImg = (ImageView) findViewById(R.id.image_funimg_profile);
        quote = (TextView) findViewById(R.id.image_funtext_profile);
        
        bio = (TextView) findViewById(R.id.text_desc_profile);
        
        contactHeader = (TextView) findViewById(R.id.text_socialheader_profile);
        contact = (TextView) findViewById(R.id.text_social_profile);
        
        projectListHeader = (TextView) findViewById(R.id.text_projectlistheader_profile);
        
        //	Dump in vars
        funImg.setImageBitmap(p.getFun_img());
        quote.setText(p.getQuote());
        
        bio.setText(p.getBio());
        
        //	Let's build us a proper lil' contact string
        String contactString = "<b>E-mail</b> "+p.getEmail()+"\n<b>Twitter</b> "+p.getTwitter()+"\n<b>Phone</b> "+p.getPhone()+"\n<b>URL</b> "+p.getUrl()+"\n<b>GitHub</b> "+p.getGithub();
        
        contact.setText(Html.fromHtml(contactString));
        
		//	Test fonts        		
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Edmondsans-Bold.otf");
        profileText.setTypeface(typeFace);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

}
