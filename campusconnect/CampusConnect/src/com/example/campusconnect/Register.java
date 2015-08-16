package com.example.campusconnect;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity implements OnClickListener{

	EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10;
	Button b;

	 // Progress Dialog
    private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();

    //php login script

    //localhost :
    //testing on your device
    //put your local ip instead,  on windows, run CMD > ipconfig
    //or in mac's terminal type ifconfig and look for the ip under en0 or en1
   // private static final String LOGIN_URL = "http://xxx.xxx.x.x:1234/webservice/register.php";

    //testing on Emulator:
    private static final String LOGIN_URL = "http://10.0.2.2/campus_connect/participant.php";

  //testing from a real server:
    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/register.php";

    //ids
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_regestration);

		    e1 = (EditText) findViewById(R.id.editText1);
			e2 = (EditText) findViewById(R.id.editText2);
			e3 = (EditText) findViewById(R.id.editText3);
			e4 = (EditText) findViewById(R.id.editText4);
			e5 = (EditText) findViewById(R.id.editText5);
			e6 = (EditText) findViewById(R.id.editText6);
			e7 = (EditText) findViewById(R.id.editText7);
			e8 = (EditText) findViewById(R.id.editText8);
			e9 = (EditText) findViewById(R.id.editText9);
			e10 = (EditText)findViewById(R.id.editText10);
			
			Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

				new CreateUser().execute();

	}

	class CreateUser extends AsyncTask<String, String, String> {

		 /**
         * Before starting background thread Show Progress Dialog
         * */
		boolean failure = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Register.this);
            pDialog.setMessage("Creating User...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			 // Check for success tag
            int success;
            String editText1 = e1.getText().toString();
            String editText2 = e2.getText().toString();
            String editText3 = e3.getText().toString();
            String editText4 = e4.getText().toString();
            String editText5 = e5.getText().toString();
            String editText6 = e6.getText().toString();
            String editText7 = e7.getText().toString();
            String editText8 = e8.getText().toString();
            String editText9 = e9.getText().toString();
            String editText10 = e10.getText().toString();
            
            try {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("name", editText1));
                params.add(new BasicNameValuePair("em", editText2));
                params.add(new BasicNameValuePair("alternate_email", editText3));
                params.add(new BasicNameValuePair("contact", editText4));
                params.add(new BasicNameValuePair("alternate_contact", editText5));
                params.add(new BasicNameValuePair("year", editText6));
                params.add(new BasicNameValuePair("roll", editText7));
                params.add(new BasicNameValuePair("hub", editText8));
                params.add(new BasicNameValuePair("event", editText9));
                params.add(new BasicNameValuePair("gname", editText10));
                
                

                Log.d("request!", "starting");

                //Posting user data to script
                JSONObject json = jsonParser.makeHttpRequest(
                       LOGIN_URL, "POST", params);

                // full json response
                Log.d("Login attempt", json.toString());

                // json success element
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                	Log.d("User Created!", json.toString());
                	finish();
                	return json.getString(TAG_MESSAGE);
                }else{
                	Log.d("Login Failure!", json.getString(TAG_MESSAGE));
                	return json.getString(TAG_MESSAGE);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

		}
		/**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null){
            	Toast.makeText(Register.this, file_url, Toast.LENGTH_LONG).show();
            }

        }

	}

}