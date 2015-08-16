package com.example.campusconnect;





import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.campusconnect.R;

//import com.example.campusconnect.ClubRowItem;
import com.example.campusconnect.Json;


import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.campusconnect.R;

import com.example.campusconnect.JSONParser;
import com.example.campusconnect.Events;
import com.example.campusconnect.Events.LoadComments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class button2 extends ListActivity {

	// Progress Dialog
	private ProgressDialog pDialog;
 
	//php read comments script
    
    //localhost :  
    //testing on your device
    //put your local ip instead,  on windows, run CMD > ipconfig
    //or in mac's terminal type ifconfig and look for the ip under en0 or en1
   // private static final String READ_COMMENTS_URL = "http://xxx.xxx.x.x:1234/webservice/comments.php";
    
    //testing on Emulator:
    private static final String READ_EVENTS_URL = "http://10.0.2.2/campus_connect/button2.php";
    
  //testing from a real server:
    //private static final String READ_COMMENTS_URL = "http://www.mybringback.com/webservice/comments.php";
   
  //JSON IDS:
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_TITLE = "e_name";
    private static final String TAG_POSTS = "events";
    private static final String TAG_POST_ID = "description";
    private static final String TAG_USERNAME = "address";
    private static final String TAG_MESSAGE = "email";
    private static final String TAG_HUB = "hub";
 //   private static final String TAG_DATE = "date";
 //   private static final String TAG_TIME = "time";
    //it's important to note that the message is both in the parent branch of 
    //our JSON tree that displays a "Post Available" or a "No Post Available" message,
    //and there is also a message for each individual post, listed under the "posts"
    //category, that displays what the user typed as their message.
    

   //An array of all of our comments
    private JSONArray mComments = null;
    //manages all of our comments in a list.
    private ArrayList<HashMap<String, String>> mCommentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //note that use read_comments.xml instead of our single_post.xml
        setContentView(R.layout.fragment_events);   
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	//loading the comments via AsyncTask
    	new LoadComments().execute();
    }

	/*public void addComment(View v)
    {
        Intent i = new Intent(Events.this, Addevent.class);
        startActivity(i);
    }*/

    /**
     * Retrieves json data of comments
     */
    

    /**
     * Inserts the parsed data into our listview
     */
    public void updateJSONdata() {

        // Instantiate the arraylist to contain all the JSON data.
    	// we are going to use a bunch of key-value pairs, referring
    	// to the json element name, and the content, for example,
    	// message it the tag, and "I'm awesome" as the content..
    	
        mCommentList = new ArrayList<HashMap<String, String>>();
        
        // Bro, it's time to power up the J parser 
        JSONParser jParser = new JSONParser();
        // Feed the beast our comments url, and it spits us
        //back a JSON object.  Boo-yeah Jerome.
        JSONObject json = jParser.getJSONFromUrl(READ_EVENTS_URL);

        //when parsing JSON stuff, we should probably
        //try to catch any exceptions:
        try {
            
        	//I know I said we would check if "Posts were Avail." (success==1)
        	//before we tried to read the individual posts, but I lied...
        	//mComments will tell us how many "posts" or comments are
        	//available
            mComments = json.getJSONArray(TAG_POSTS);

            // looping through all posts according to the json object returned
            for (int i = 0; i < mComments.length(); i++) {
                JSONObject c = mComments.getJSONObject(i);

                //gets the content of each tag
                String title = c.getString(TAG_TITLE);
                String content = c.getString(TAG_MESSAGE);
                String username = c.getString(TAG_USERNAME);
                String hub= c.getString(TAG_HUB);
         //       String date= c.getString(TAG_DATE);
         //       String time= c.getString(TAG_TIME);
                String description= c.getString(TAG_POST_ID);
                

                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();
              
                map.put(TAG_TITLE, title);
                map.put(TAG_MESSAGE, content);
                map.put(TAG_USERNAME, username);
                map.put(TAG_HUB, hub);
      //          map.put(TAG_DATE, date);
      //          map.put(TAG_TIME, time);
                map.put(TAG_POST_ID, description);
             
                // adding HashList to ArrayList
                mCommentList.add(map);
                
                //annndddd, our JSON data is up to date same with our array list
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    
    private void updateList() {
		// For a ListActivity we need to set the List Adapter, and in order to do
		//that, we need to create a ListAdapter.  This SimpleAdapter,
		//will utilize our updated Hashmapped ArrayList, 
		//use our single_post xml template for each item in our list,
		//and place the appropriate info from the list to the
		//correct GUI id.  Order is important here.
		ListAdapter adapter = new SimpleAdapter(this, mCommentList,
				R.layout.singleevent, new String[] { TAG_TITLE,TAG_HUB,TAG_POST_ID, 
						TAG_USERNAME,TAG_MESSAGE, }, new int[] { R.id.title,R.id.hub,R.id.description,
						R.id.venue, R.id.email });

		// I shouldn't have to comment on this one:
		setListAdapter(adapter);
		
		// Optional: when the user clicks a list item we 
		//could do something.  However, we will choose
		//to do nothing...
		ListView lv = getListView();	
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				

				// This method is triggered if an item is click within our
				// list. For our example we won't be using this, but
				// it is useful to know in real life applications.
				
				Intent in = new Intent(getApplicationContext(),
	                    Register.class);
	             
	             startActivity(in);
	             finish();
	             

			}
		});
	}       

    public class LoadComments extends AsyncTask<Void, Void, Boolean> {

    	@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(button2.this);
			pDialog.setMessage("Loading Comments...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}
        @Override
        protected Boolean doInBackground(Void... arg0) {
        	//we will develop this method in version 2
            updateJSONdata();
            return null;

        }


        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            pDialog.dismiss();
          //we will develop this method in version 2
            updateList();
        }
    }
}