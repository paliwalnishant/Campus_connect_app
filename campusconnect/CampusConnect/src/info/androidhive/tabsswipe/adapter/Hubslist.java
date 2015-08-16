package info.androidhive.tabsswipe.adapter;

//package info.androidhive.tabsswipe;

//import info.androidhive.tabsswipe.R;
import com.example.campusconnect.Events;
import com.example.campusconnect.R;
import com.example.campusconnect.button2;
import com.example.campusconnect.button3;
import com.example.campusconnect.button4;
import com.example.campusconnect.button5;
import com.example.campusconnect.button6;
import com.example.campusconnect.button7;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
 
public class Hubslist extends Fragment {
	Button b1,b2,b3,b4,b5,b6,b7;
	//Context context;
	//String clubname;
	AlertDialog.Builder adb;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_clubs, container, false);
        
        Button b1 = (Button) rootView.findViewById(R.id.button1);
        Button b2 = (Button) rootView.findViewById(R.id.button2);
        Button b3 = (Button) rootView.findViewById(R.id.button3);
        Button b4 = (Button) rootView.findViewById(R.id.button4);
        Button b5 = (Button) rootView.findViewById(R.id.button5);
        Button b6 = (Button) rootView.findViewById(R.id.button6);
        Button b7 = (Button) rootView.findViewById(R.id.button7);
        
      

        b1.setOnClickListener(new View.OnClickListener() {
 			@Override
 			public void onClick(View arg0) {
   			//	Toast.makeText(club_activity.this, "Welcome",	Toast.LENGTH_SHORT).show();
    				Intent in = new Intent(getActivity(),
 	                    Events.class);
 	             
 	             startActivity(in);
 	           //  finish();
    			
    			}

    		});
    		b2.setOnClickListener(new View.OnClickListener() {

    			@Override
    			public void onClick(View view) {
    				
    				Intent in = new Intent(getActivity(),
 	                    button2.class);
 	             
 	             startActivity(in);
 	        //     finish();
    			
    			}

    		});
    		b3.setOnClickListener(new View.OnClickListener() {

    			@Override
    			public void onClick(View view) {
    	//			Toast.makeText(club_activity.this, "Welcome",	Toast.LENGTH_SHORT).show();
    				Intent in = new Intent(getActivity(),
 	                    button3.class);
 	             
 	             startActivity(in);
 	  //           finish();
    			
    			}

    		});
    		b4.setOnClickListener(new View.OnClickListener() {

    			@Override
    			public void onClick(View view) {
    //				Toast.makeText(club_activity.this, "Welcome",	Toast.LENGTH_SHORT).show();
    				Intent in = new Intent(getActivity(),
 	                    button4.class);
 	             
 	             startActivity(in);
 	 //            finish();
    			
    			}

    		});
    		b5.setOnClickListener(new View.OnClickListener() {

    			@Override
    			public void onClick(View view) {
    		//		Toast.makeText(club_activity.this, "Welcome",	Toast.LENGTH_SHORT).show();
    				Intent in = new Intent(getActivity(),
 	                    button5.class);
 	             
 	             startActivity(in);
 	    //         finish();
    			
    			}

    		});
    		b6.setOnClickListener(new View.OnClickListener() {

    			@Override
    			public void onClick(View view) {
    	//			Toast.makeText(club_activity.this, "Welcome",	Toast.LENGTH_SHORT).show();
    				Intent in = new Intent(getActivity(),
 	                    button6.class);
 	             
 	             startActivity(in);
 	  //           finish();
    			
    			}

    		});
    		b7.setOnClickListener(new View.OnClickListener() {

    			@Override
    			public void onClick(View view) {
    		//		Toast.makeText(club_activity.this, "Welcome",	Toast.LENGTH_SHORT).show();
    				Intent in = new Intent(getActivity(),
 	                    button7.class);
 	             
 	             startActivity(in);
 	   //          finish();
    			
    			}

    		});
    		/*b8.setOnClickListener(new OnClickListener() {

    			@Override
    			public void onClick(View view) {
    				Toast.makeText(club_activity.this, "Welcome",	Toast.LENGTH_SHORT).show();
    				Intent in = new Intent(getApplicationContext(),
 	                    button8.class);
 	             
 	             startActivity(in);
 	             finish();
    			
    			}

    		});*/
    		return rootView;
 	}
    	
   
 	 /* 	 public void onBackPressed() {
 	   		 
 	   		 AlertDialog.Builder alertDialog = new AlertDialog.Builder(Hubslist.this);
 	   		 
 	   	        // Setting Dialog Title
 	   	        alertDialog.setTitle("EXIT");
 	   	 
 	   	        // Setting Dialog Message
 	   	        alertDialog.setMessage("Are you sure you want to exit CampusConnect?");
 	   	 
 	   	        // Setting Icon to Dialog
 	   	        alertDialog.setIcon(R.drawable.exit);
 	   	        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
 	   	            public void onClick(DialogInterface dialog,int which) {
 	   	 
 	   	            // Write your code here to invoke YES event
 	   	            Toast.makeText(getActivity(), "finishing", Toast.LENGTH_SHORT).show();
 	//   	            finish();
 	   	            }
 	   	        });
 	   	        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
 	   	            public void onClick(DialogInterface dialog, int which) {
 	               // Write your code here to invoke NO event
 	   	            Toast.makeText(getApplicationContext(), "CampusConnect", Toast.LENGTH_SHORT).show();
 	   	            dialog.cancel();
 	   	            }
 	   	        });
 	   	        alertDialog.show();
 	   	 
 	   	 
 	 }*/
        
         
        
   
}
