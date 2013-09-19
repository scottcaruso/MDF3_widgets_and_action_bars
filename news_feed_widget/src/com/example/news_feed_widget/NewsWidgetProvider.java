package com.example.news_feed_widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

public class NewsWidgetProvider extends AppWidgetProvider {

	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
	{
		RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
		Log.i("Info","Time to update");
	}
	
	public void onDeleted(Context context, int[] appWidgetIds)
	{
		//doNothing
	}
}
