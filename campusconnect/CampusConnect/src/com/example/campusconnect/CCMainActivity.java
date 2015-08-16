package com.example.campusconnect;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;


public class CCMainActivity extends Activity {

	private ProgressBar pbar = null;
	Thread splash_thread = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccmain);

        
        pbar = (ProgressBar) findViewById(R.id.progressBar1);
		splash_thread = new Thread(new Runnable() {

	        @Override
	        public void run() {
	            // TODO Auto-generated method stub
	            int i = 0;
	              for( i=0;i<100;i++){

	                  pbar.setProgress(i);

	                 // counter_txt.setText(i+" %");
	                  try {
	                    splash_thread.sleep(50);
	                } catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	              }
	              if(i==100){
	                  Intent intent = new Intent(getBaseContext(),MainCampus.class);
	                  startActivity(intent);
	                  finish();
	              }
	        }
	    });
	    splash_thread.start();

	}
	@Override
	protected void onDestroy() {
	    // TODO Auto-generated method stub
	    super.onDestroy();
	}

}