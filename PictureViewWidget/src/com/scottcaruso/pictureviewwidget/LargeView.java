/* Scott Caruso
 * MDF 1309
 * Week 3 - Widgets and Action Bars
 */
package com.scottcaruso.pictureviewwidget;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class LargeView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_large_view);
		
		//Retrieve the intent of the activity that launched us. If there are extras, that's good! We should use them!
		Intent passedIntent = getIntent();
		if (passedIntent != null)
		{
			Bundle extras = passedIntent.getExtras();
			int imageId;
			try {
				//Pull the int from the extras, and then utilize it to populate this view.
				imageId = extras.getInt("image id");
				ImageView image = (ImageView) findViewById(R.id.imageView1);
				Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), 
					    imageId);
				image.setImageBitmap(bitmap);
				TextView pictureField = (TextView) findViewById(R.id.textView1);
				TextView authorField = (TextView) findViewById(R.id.textView2);
				TextView dateField = (TextView) findViewById(R.id.textView3);
				
				pictureField.setText("Picture Number " + String.valueOf(imageId));
				authorField.setText("Author Number " + String.valueOf(imageId));
				dateField.setText("Retrieved on the " + String.valueOf(imageId) + "th day.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.large_view, menu);
		return true;
	}

}
