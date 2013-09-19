package com.scottcaruso.pictureviewwidget;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RemoteViews;
import android.widget.Toast;

public class WidgetConfig extends Activity {
	
	public int widgetId;
	public int checkedButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configure_widget);
		
		Button okButton = (Button) findViewById(R.id.selection);
		final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_hours);
		okButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle extras = getIntent().getExtras();
				
				if (extras != null)
				{
					widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,AppWidgetManager.INVALID_APPWIDGET_ID);	
					if (widgetId != AppWidgetManager.INVALID_APPWIDGET_ID)
					{
						checkedButton = radioGroup.getCheckedRadioButtonId();
						RadioButton radioButton = (RadioButton) findViewById(checkedButton);
						
						Log.i("Info", "Radio button " +radioButton.getText() + " was clicked.");
						Toast toast = Toast.makeText(WidgetConfig.this, "Note that these settings are not yet saved - this is placeholder for the next version!", Toast.LENGTH_LONG);
						toast.show();
						AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(WidgetConfig.this);
						RemoteViews views = new RemoteViews(WidgetConfig.this.getPackageName(), R.layout.picture_widget_layout);
						appWidgetManager.updateAppWidget(widgetId, views);
						Intent resultValue = new Intent();
						resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
						setResult(RESULT_OK, resultValue);
						finish();
					}
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.large_view, menu);
		return true;
	}

}
