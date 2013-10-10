package com.example.zonedhobbitsportfolio;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

public class Fetcher extends AsyncTask<String, Void, String> {
	//REMEMBER TO ADD INTERNET PERMISION TO MANIFEST
		
		//Creating an project array for sending as a parameter when creating a person object.
		Project[] projects;
		Person user;
		
		public Fetcher (Person name) {
			this.user = name;
		}
		
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
				//Do something when the JSON is recovered from php file.
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
	   		JSONArray jArrayProjects = jObject.getJSONArray("projects");
	   		Log.i("ARRAY", jArrayProjects.toString());
	   		
	   		//Change the url of the images to a bitmap object.
	   		Bitmap normal_img_bitmap = this.grabBitmap(normal_img);
	   		Bitmap fun_img_bitmap = this.grabBitmap(fun_img);
	   		//Log.i("bitmap", normal_img_bitmap.toString());
	   		
	   		//Create a person object, send parameters.
	   		user = new Person(name, quote, nick_name, bio, normal_img_bitmap, fun_img_bitmap, email, phone, twitter, url, github, projects);
	   		
	   		for(int x=0; x < jArrayProjects.length(); x++) {
		   		JSONObject jObjectProjectSingle = jArrayProjects.getJSONObject(x);
		   		Log.i("***jObjectProjectSingle", jObjectProjectSingle.toString());
		   		String projectName = jObjectProjectSingle.getString("name");
		   		String projectTagline = jObjectProjectSingle.getString("tagline");
	   			String projectDescription = jObjectProjectSingle.getString("description");
	   			String projectType = jObjectProjectSingle.getString("type");
	   			String projectThumbnail = jObjectProjectSingle.getString("thumbnail");
	   			//Creating a bitmap object from the projectThumbnail URL.
	   			Bitmap projectThumbnailBitmap = this.grabBitmap(projectThumbnail);
	   			//Log.i("***projectName", projectName);
	   			
	   			//Fetch the images
	   			JSONObject jObjectProjectImages = jObjectProjectSingle.getJSONObject("img");
	   			
	   			//Get how many images does the project has.
	   			int imgLenght = jObjectProjectImages.length();
	   			
	   			//Creat a Bitmap array;
	   			Bitmap[] bitmapArray = new Bitmap[imgLenght];
	   			
	   			//Loop the jObjectProjectImages objects and get all the URL.
	   			for(int v=1; v <= imgLenght; v++) {
	   				//Log.i("***jObjectProjectImages", jObjectProjectImages.toString());
	   				String imageUrl = jObjectProjectImages.getString(Integer.toString(v));
	   				//Convert the URL string in a bitmap object and add it to bitmapArray.
	   				bitmapArray[v] = this.grabBitmap(imageUrl);
	   			}
	   			
	   			//Creat a project object and pass parameters.
	   			Project projectObject = new Project(projectName, projectTagline, user, projectType, projectDescription, projectThumbnailBitmap, bitmapArray);
	   			
	   		}
	   		
		}
		
		Bitmap grabBitmap(String URL) {
			Bitmap bm = null;
	        try {
	            URL aURL = new URL(URL.replace("\\", ""));
	            URLConnection conn = aURL.openConnection();
	            conn.connect();
	            InputStream is = conn.getInputStream();
	            BufferedInputStream bis = new BufferedInputStream(is);
	            bm = BitmapFactory.decodeStream(bis);
	            bis.close();
	            is.close();
	        } catch (IOException e) {
	        	Log.e("DB Bitmap Exception", "Error getting bitmap", e);
	        }
	       
	        return bm; 
	        
		}
    	
    }