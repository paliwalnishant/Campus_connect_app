package com.example.campusconnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class HellAdmin extends Activity {
Button a,b,c;
@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.helloadmin);

	addListenerOnButton();

}

public void addListenerOnButton() {

    //Select a specific button to bundle it with the action you want
	a = (Button) findViewById(R.id.b1);
	b = (Button) findViewById(R.id.b2);
	c = (Button) findViewById(R.id.b3);
	b.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View view) {

		  Intent i =  new Intent(HellAdmin.this,AddNews.class);
		  startActivity(i);
		}

	});

	a.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View view) {

		  Intent openBrowser =  new Intent(HellAdmin.this,AdminClass.class);
		  startActivity(openBrowser);
		}

	});
	c.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View view) {

		  Intent openBrowser =  new Intent(HellAdmin.this,AdminClass.class);
		  startActivity(openBrowser);
		}

	});
	

}

}