package com.example.campusconnect;



import info.androidhive.tabsswipe.adapter.TabsPagerAdapter;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
 
public class MainCampus extends FragmentActivity implements
        ActionBar.TabListener {
 
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = { "HUBS", "Login", "Contact" };
    Button fb1,go1,aak1;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincampus);
 
        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
 
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
 
        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
 
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
 
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }
 
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }
 

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.action_button, menu);

    return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Take appropriate action for each action item click
    switch (item.getItemId()) {
    case R.id.action_home:
        // location found
        GoHome();
        return true;
    case R.id.action_jiit:
    	Gojiit();
    	return true;
    case R.id.action_google:
    	GoGoogle();
    	return true;
    case R.id.action_facebook:
    	GoFacebook();
    	return true;
   default:
        return super.onOptionsItemSelected(item);
}
	
    }
private void Gojiit() {
// TODO Auto-generated method stub

			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.jiit.ac.in"));
			startActivity(browserIntent);
	
}
private void GoFacebook() {
// TODO Auto-generated method stub
 
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
			startActivity(browserIntent);
	
}
private void GoGoogle() {
// TODO Auto-generated method stub

			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
			startActivity(browserIntent);
		}
	

private void GoHome() {
    Intent i = new Intent(getBaseContext(),MainCampus.class);
    startActivity(i);
    finish();
}
@Override
public void onBackPressed() {


//Intent i = new Intent(getBaseContext(),MainCampus.class);
//startActivity(i);


 
 AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainCampus.this);
 
    // Setting Dialog Title
    alertDialog.setTitle("EXIT");

    // Setting Dialog Message
    alertDialog.setMessage("Are you sure you want to exit CampusConnect?");

    // Setting Icon to Dialog
    alertDialog.setIcon(R.drawable.exit);
    alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog,int which) {

        // Write your code here to invoke YES event
        Toast.makeText(getApplicationContext(), "Finishing", Toast.LENGTH_SHORT).show();
        finish();
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
}
}

