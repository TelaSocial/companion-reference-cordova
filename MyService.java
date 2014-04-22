package com.red_folder.phonegap.plugin.backgroundservice.sample;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.AlarmClock;
 
// For network
import java.net.*;
import java.io.*;

//import java.util.Calendar;

//marcio test
import android.os.Vibrator;

import com.red_folder.phonegap.plugin.backgroundservice.BackgroundService;

public class MyService extends BackgroundService {
	
	private final static String TAG = MyService.class.getSimpleName();
	
	private String mHelloTo = "World";

  @Override
  protected JSONObject doWork() {
    JSONObject result = new JSONObject();
    
    Log.d(TAG, "marcio do work...3 " );

	try { 
		Log.d(TAG, "marcio loading.. " );
		URL yahoo = new URL("http://telalabs.appspot.com/profeed/tab");
		URLConnection yc = yahoo.openConnection();
		BufferedReader in = new BufferedReader( new InputStreamReader(yc.getInputStream(),"UTF-8"));
		String inputLine;

		while ((inputLine = in.readLine()) != null)  { 
			Log.d(TAG, "marcio... processing remote line: "+inputLine+"===" );

			if(inputLine.indexOf("aparece")>-1) { 
				Intent i = new Intent();
				PackageManager manager = getPackageManager();
				i = manager.getLaunchIntentForPackage("io.cordova.hellocordova");
				i.addCategory(Intent.CATEGORY_LAUNCHER);
				this.startActivity(i);
				Vibrator vibrator = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);
				vibrator.vibrate(50000);
			} 
		} 

		in.close();
		//result.put("marcio - Message", msg);
	} catch (IOException ee) { 
		Log.d(TAG, "marcio, no network --- "+ ee);
	} 

    return result;  
  }

	@Override
	protected JSONObject getConfig() {
		JSONObject result = new JSONObject();
		
		try {
			result.put("HelloTo", this.mHelloTo);
		} catch (JSONException e) {
		}
		
		return result;
	}

	@Override
	protected void setConfig(JSONObject config) {
		try {
			if (config.has("HelloTo"))
				this.mHelloTo = config.getString("HelloTo");
		} catch (JSONException e) {
		}
		
	}     

	@Override
	protected JSONObject initialiseLatestResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onTimerEnabled() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onTimerDisabled() {
		// TODO Auto-generated method stub
		
	}


}
