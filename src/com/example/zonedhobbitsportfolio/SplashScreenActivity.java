package com.example.zonedhobbitsportfolio;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class SplashScreenActivity extends Activity {

  private long splashDelay = 6000; //6 segundos
  private static Activity activity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);
    
    activity = this;
  }

  public static void finishSplash() {
	  activity.finish();
  }
  
}