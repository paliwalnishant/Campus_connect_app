package info.androidhive.tabsswipe.adapter;

//package info.androidhive.tabsswipe;

//import info.androidhive.tabsswipe.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 import com.example.campusconnect.R;
public class Contact extends Fragment {
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
         
        return rootView;
    }
}
