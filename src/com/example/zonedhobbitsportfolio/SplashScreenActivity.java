package com.example.zonedhobbitsportfolio;

import android.os.Bundle;
import android.app.Activity;

public class SplashScreenActivity extends Activity {

  private long splashDelay = 6000; //6 segundos
  private static Activity activity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    GifWebView view = new GifWebView(this, "file:///android_asset/ring.gif"); 
    setContentView(view);
    
    activity = this;
  }

  public static void finishSplash() {
	  activity.finish();
  }
  
}