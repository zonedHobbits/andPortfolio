package com.example.zonedhobbitsportfolio;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;

import android.os.AsyncTask;
import android.util.Log;

public class Fetcher extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			
			String urlString = params[0];
			
			HttpURLConnection conn = null;
	        final StringBuilder json = new StringBuilder();
	        try {
	            // Connect to the web service
	            URL url = new URL(urlString);
	            conn = (HttpURLConnection) url.openConnection();
	            InputStreamReader in = new InputStreamReader(conn.getInputStream());

	            // JSON data into the StringBuilder
	            int read;
	            char[] buff = new char[1024];
	            json.append(buff, 0, in.read(buff));
	            /*
	            while ((read = in.read(buff)) != -1) {
	                json.append(buff, 0, read);
	            }
	            */
	            
	        } catch (IOException e) {
	            Log.e("myTag", "Error connecting", e);
	            //throw new IOException("Error connecting", e);
	        } finally {
	            if (conn != null) {
	                conn.disconnect();
	            }
	        }
	        Log.i("JSONResponseCategories", json.toString());
	        return json.toString();
		}

		@Override
		protected void onPostExecute(String json) {
			super.onPostExecute(json);
			try {
				putCategory(json);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		void putCategory(String json) throws JSONException {
			Log.i("FETCHER", json.toString());
		}
    	
    }