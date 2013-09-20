/* Scott Caruso
 * MDF 1309
 * Week 3 - Widgets and Action Bars
 */
package com.scottcaruso.pictureviewwidget;

import java.util.Random;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.RemoteViews;

public class PictureWidgetProvider extends AppWidgetProvider {

	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
	{
		final int N = appWidgetIds.length;

		//Randomly decide on a number, and then use that number to figure out which picture to show next.
		Log.i("Info","Update triggered.");
		for (int x=0; x < N; x++) {
			int appWidgetId = appWidgetIds[x];
			Random rand = new Random();
			int n = rand.nextInt(5) + 1;
			
			int resourceID = 0;
			
			if (n == 1)
			{
				resourceID = R.drawable.img1;
			} else if (n == 2)
			{
				resourceID = R.drawable.img2;
			} else if (n == 3)
			{
				resourceID = R.drawable.img3;
			} else if (n == 4)
			{
				resourceID = R.drawable.img4;
			} else if (n == 5)
			{
				resourceID = R.drawable.img5;
			}
			
			//Grab that picture from its resource ID.
			Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), 
				    resourceID);
			
			Bitmap scaledBitmap = scaleDownBitmap(bitmap, 100, context);
			
			//Prepare the click intent
			Intent i = new Intent(context,LargeView.class);
			i.putExtra("image id", resourceID);
			PendingIntent pi = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
			
			RemoteViews rv = new RemoteViews(context.getPackageName(),R.layout.picture_widget_layout);
			rv.setBitmap(R.id.imageView1, "setImageBitmap", scaledBitmap);
			rv.setOnClickPendingIntent(R.id.imageView1, pi);
			appWidgetManager.updateAppWidget(appWidgetId, rv);
		}
		
	}
	
	//Scale the bitmaps down for memory management
    public static Bitmap scaleDownBitmap(Bitmap photo, int newHeight, Context context) 
    {
    	final float densityMultiplier = context.getResources().getDisplayMetrics().density;        

    	int h= (int) (newHeight*densityMultiplier);
    	int w= (int) (h * photo.getWidth()/((double) photo.getHeight()));

    	photo=Bitmap.createScaledBitmap(photo, w, h, true);

    	return photo;
    }
	
}
