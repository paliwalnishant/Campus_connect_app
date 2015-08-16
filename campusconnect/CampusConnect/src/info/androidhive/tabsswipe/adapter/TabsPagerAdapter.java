package info.androidhive.tabsswipe.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	 
    public TabsPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public android.support.v4.app.Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new Hubslist();
        case 1:
            // Games fragment activity
            return new Login();
        case 2:
            // Movies fragment activity
            return new Contact();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
 
}
