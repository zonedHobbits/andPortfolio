package com.example.zonedhobbitsportfolio;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

public class Fetcher extends AsyncTask<String, Void, String> {
	//REMEMBER TO ADD INTERNET PERMISION TO MANIFEST
		
		//Creating an project array for sending as a parameter when creating a person object.
		Project[] projects;
	
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
	        return json.toString();
		}

		@Override
		protected void onPostExecute(String json) {
			super.onPostExecute(json);
			try {
				showInfoFromDb(json);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		void showInfoFromDb(String json) throws JSONException {
			Log.i("FETCHER", json.toString());
			//look for the general JSON object
			JSONObject jObject = new JSONObject(json);
	   		//look for the strings in the JSON object
	   		String name = jObject.getString("name");
	   		String nick_name = jObject.getString("nick_name");
	   		String normal_img = jObject.getString("normal_img");
	   		String fun_img = jObject.getString("fun_img");
	   		String quote = jObject.getString("quote");
	   		String bio = jObject.getString("bio");
	   		//look for the JSON object contact
	   		JSONObject jObjectContact = jObject.getJSONObject("contact");
	   		String email = jObjectContact.getString("email");
	   		String twitter = jObjectContact.getString("twitter");
	   		String github = jObjectContact.getString("github");
	   		String phone = jObjectContact.getString("phone");
	   		String url = jObjectContact.getString("url");
	   		
	   		//Get the strings in the jObject2.
	   		JSONObject jObjectProjects = jObject.getJSONObject("projects");
	   		for(int x=1; x <= jObjectProjects.length(); x++) {
		   		JSONObject jObjectProjectSingle = jObjectProjects.getJSONObject(Integer.toString(x));
		   		String projectName = jObjectProjectSingle.getString("name");
		   		String projectTagline = jObjectProjectSingle.getString("tagline");
	   			String projectDescription = jObjectProjectSingle.getString("description");
	   			String projectType = jObjectProjectSingle.getString("type");
	   			//FECTH THE IMAGES WHEN ALBIN IS DONE WITH THE PHP
	   		}
	   		
	   		//Change the url of the images to a bitmap object.
	   		Bitmap normal_img_bitmap;
	   		Bitmap fun_img_bitmap;
	   		
	   		//Creat a person object, send parameters.
	   		//Person user = new Person(name, quote, nick_name, bio, normal_img_bitmap, fun_img_bitmap, email, phone, twitter, url, github, projects);
		}
    	
    }