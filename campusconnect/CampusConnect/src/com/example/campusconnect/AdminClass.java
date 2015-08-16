package com.example.campusconnect;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminClass extends Activity implements OnClickListener{
	
	private EditText e_name,description,venue,email,hub;
	private Button  mSubmit;
	
	 // Progress Dialog
    private ProgressDialog pDialog;
 
    // JSON parser class
    JSONParser jsonParser = new JSONParser();
    
    //php login script
    
    //localhost :  
    //testing on your device
    //put your local ip instead,  on windows, run CMD > ipconfig
    //or in mac's terminal type ifconfig and look for the ip under en0 or en1
   // private static final String POST_COMMENT_URL = "http://xxx.xxx.x.x:1234/webservice/addcomment.php";
    
    //testing on Emulator:
    private static final String POST_COMMENT_URL = "http://10.0.2.2/campus_connect/create_event.php";
    
  //testing from a real server:
    //private static final String POST_COMMENT_URL = "http://www.mybringback.com/webservice/addcomment.php";
    
    //ids
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adminlogin);
		
		
		e_name= (EditText)findViewById(R.id.e1);
		description= (EditText)findViewById(R.id.e2);
		venue= (EditText)findViewById(R.id.e3);
		email= (EditText)findViewById(R.id.e4);
		hub= (EditText)findViewById(R.id.e5);
	//	date= (EditText)findViewById(R.id.e6);
	//	time= (EditText)findViewById(R.id.e7);
		
		mSubmit = (Button)findViewById(R.id.create);
		mSubmit.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
				new PostComment().execute();
	}
	
	
	class PostComment extends AsyncTask<String, String, String> {
		
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(AdminClass.this);
            pDialog.setMessage("Posting Comment...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
		
		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			 // Check for success tag
            int success;
            String a = e_name.getText().toString();
            String b = description.getText().toString();
            String c = venue.getText().toString();
            String d = email.getText().toString();
            String h = hub.getText().toString();
  //          String f = date.getText().toString();
  //          String g = time.getText().toString();
            
          
            
            
          
           
            
            try {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("e_name", a));
                params.add(new BasicNameValuePair("description",b));
                params.add(new BasicNameValuePair("address", c));
                params.add(new BasicNameValuePair("email", d));
                params.add(new BasicNameValuePair("hub", h));
   //             params.add(new BasicNameValuePair("date",f));
   //             params.add(new BasicNameValuePair("time",g));
 
                Log.d("request!", "starting");
                
                //Posting user data to script 
                JSONObject json = jsonParser.makeHttpRequest(
                		POST_COMMENT_URL, "POST", params);
 
                // full json response
                Log.d("Post Comment attempt", json.toString());
 
                // json success element
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                	Log.d("Comment Added!", json.toString());    
                	finish();
                	return json.getString(TAG_MESSAGE);
                }else{
                	Log.d("Comment Failure!", json.getString(TAG_MESSAGE));
                	return json.getString(TAG_MESSAGE);
                	
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
 
            return null;
			
		}
		
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null){
            	Toast.makeText(AdminClass.this, file_url, Toast.LENGTH_LONG).show();
            }
 
        }
		
	}
		 

}
