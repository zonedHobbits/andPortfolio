package com.example.zonedhobbitsportfolio;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.app.Activity;
import android.graphics.Color;

public class SplashScreenActivity extends Activity {

  private long splashDelay = 6000; //6 segundos
  private static Activity activity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    RelativeLayout superView = new RelativeLayout(this);
    
    setContentView(superView);
    
    GifWebView view = new GifWebView(this, "file:///android_asset/ring.gif");
    
    superView.addView(view);
    
    superView.setBackgroundColor(Color.BLACK);
    view.setBackgroundColor(Color.BLACK);
    
    view.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    
    RelativeLayout.LayoutParams lp = (LayoutParams) view.getLayoutParams();
    lp.addRule(RelativeLayout.CENTER_IN_PARENT);
    
    view.setLayoutParams(lp);
    
    activity = this;
  }

  public static void finishSplash() {
	  activity.finish();
  }
  
  public void padding(View view) {
	  view.setPadding(20,20,20,20);
  }
}