/* Scott Caruso
 * MDF3 - 1309
 * Week 2 - Here I Am Camera/GPS App
 */
package com.scottcaruso.hereiam;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;

//This is a very simple page - pretty much placeholder to prove concept.

public class About extends Activity {
	
	int NAVIGATION_MODE_LIST = 1;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
	
        setContentView(R.layout.about);
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return super.onCreateOptionsMenu(menu);
    }

}
