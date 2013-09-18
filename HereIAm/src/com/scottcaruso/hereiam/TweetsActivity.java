package com.scottcaruso.hereiam;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class TweetsActivity extends Activity {
	
	int NAVIGATION_MODE_LIST = 1;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        Log.i("Info","Tweets activity loaded");
	
        setContentView(R.layout.tweets);
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        SpinnerAdapter headerSpinner = ArrayAdapter.createFromResource(this, R.array.action_list,
                android.R.layout.simple_spinner_dropdown_item);
        
        OnNavigationListener mOnNavigationListener = new OnNavigationListener() {

        	  @Override
        	  public boolean onNavigationItemSelected(int position, long itemId) {
        		
        		switch (position) {
				case 0:
	        		Log.i("Clicked","Main was clicked.");
					Intent mainActivity = new Intent(TweetsActivity.this,MainActivity.class);
					startActivityForResult(mainActivity, 1);
					break;
				case 1:
	        		Log.i("Clicked","Tweets was clicked.");
	        		//Do nothing - we're already here!
					break;
					
				case 2:
					Intent facebookActivity = new Intent(TweetsActivity.this,FacebookActivity.class);
					startActivityForResult(facebookActivity, 1);
	        		Log.i("Clicked","Facebook was clicked.");
					break;
				
				default:
					break;
				}
        		
        	    return true;
        	  }
        	};
        ActionBar myActionBar = this.getActionBar();
        myActionBar.setDisplayShowTitleEnabled(false);
        myActionBar.setNavigationMode(NAVIGATION_MODE_LIST);

        myActionBar.setListNavigationCallbacks(headerSpinner, mOnNavigationListener);
        myActionBar.setSelectedNavigationItem(1);
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
