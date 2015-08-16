package info.androidhive.tabsswipe.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.campusconnect.AdminLogin;
import com.example.campusconnect.Events;
import com.example.campusconnect.R;
import com.example.campusconnect.UserLogin;
import com.example.campusconnect.UserRegister;

public class Login extends Fragment {
	Button b1,b2,b3;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.login, container, false);
         b1 = (Button) rootView.findViewById(R.id.adminlogin);
         b2 = (Button) rootView.findViewById(R.id.login);
         b3 = (Button) rootView.findViewById(R.id.register);
         b1.setOnClickListener(new View.OnClickListener() {
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
 				Intent in = new Intent(getActivity(),
 	                    AdminLogin.class);
 				startActivity(in);
 				
 			}
 		});
         b2.setOnClickListener(new View.OnClickListener() {
  			@Override
  			public void onClick(View arg0) {
  				// TODO Auto-generated method stub
  				Intent in = new Intent(getActivity(),
  	                    UserLogin.class);
  				startActivity(in);
  			}
  		});
         b3.setOnClickListener(new View.OnClickListener() {
   			@Override
   			public void onClick(View arg0) {
   				// TODO Auto-generated method stub
   				Intent in = new Intent(getActivity(),
   	                    UserRegister.class);
   				startActivity(in);
   				
   			}
   		});
        
         
        return rootView;
    }
}