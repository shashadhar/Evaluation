package com.interview.evaluationproject.manager;

import android.content.Context;

public class AppManager {
	private Context context;
	
	private static AppManager instance = null;
	
	private AppManager(){
		
	}
	
	public static AppManager getInstance(){
		if(instance == null){
			instance = new AppManager();
		}
		return instance;
	}
	
	public void init(Context context){
		this.context = context;
	}
	
	public Context getApplicationContext(){
		return this.context;
	}
}
