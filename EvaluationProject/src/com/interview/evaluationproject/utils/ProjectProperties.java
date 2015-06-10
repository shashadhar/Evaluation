package com.interview.evaluationproject.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.content.res.Resources;

import com.interview.evaluationproject.R;
import com.interview.evaluationproject.manager.AppManager;

public class ProjectProperties extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ProjectProperties instance = null;
	
	public static ProjectProperties getInstance(){
		if(instance == null){
			instance = new ProjectProperties();
			instance.loadProperties();
		}
		return instance;
	}
	
	private ProjectProperties(){
		
	}
	
	private void loadProperties(){
		this.loadProperties(R.raw.endpoint);
	}
	
	private void loadProperties(int resourceId){
		Resources resources = AppManager.getInstance().getApplicationContext().getResources();
		InputStream rawResource = resources.openRawResource(resourceId);
		try {
			load(rawResource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key){
		return getProperty(key, "");
	}
	
}
