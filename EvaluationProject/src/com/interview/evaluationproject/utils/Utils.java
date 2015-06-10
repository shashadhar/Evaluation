package com.interview.evaluationproject.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.PreferenceManager;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class Utils {
	public static final String REG_ID = "regId";
	private static final String APP_VERSION = "appVersion";
	
	public static boolean isGooglePlayServicesAvailable(Context context){
		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
		if(ConnectionResult.SUCCESS == resultCode){
			return true;
		}
		return false;
	}
	
	private static int getAppVersion(Context context) {
		try {
			PackageInfo packageInfo = context.getPackageManager()
					.getPackageInfo(context.getPackageName(), 0);
			return packageInfo.versionCode;
		} catch (NameNotFoundException e) {
			// should never happen
			throw new RuntimeException("Could not get package name: " + e);
		}
	}
	
}
