package com.interview.evaluationproject.utils;

import com.interview.evaluationproject.manager.AppManager;
import com.interview.evaluationproject.net.NetworkCommunicator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.interview.evaluationproject.json.Company;
import com.interview.evaluationproject.json.CompanyDetails;
import com.interview.evaluationproject.utils.Log;




public class CacheReader {
	static String FILENAME_COMPANY = "Companies";
	static String FILENAME_COMPANY_DETAILS="CompanieDetails";
	private Context context;
	public static List<Company> avaialableCompanies;
	public static List<CompanyDetails> avaialableCompanyDetails;
	public CacheReader() {
		context = AppManager.getInstance().getApplicationContext();
	}
	public static List<Company> readCachedCompanies()
	{
		FileInputStream fis = null;
		try
		{
			fis = AppManager.getInstance().getApplicationContext().openFileInput(FILENAME_COMPANY);
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new InputStreamReader(fis));
			Type listType= new TypeToken<List<Company>>(){}.getType();
			List<Company> companies = gson.fromJson(reader,listType);
            if(companies != null){
            	avaialableCompanies=companies;
    	 }
         
			fis.close();
			return companies;
		} catch (FileNotFoundException fnf) {
			//ignore, no method to check if file exists
		}catch (Throwable t) {
			Log.e("Cache reader", "Failed to read cached", t);
		} finally
		{
			try
			{
				fis.close();
			} catch (Throwable t)
			{
			}
		}
		return null;
	}	
	
	public static void saveCompanies(List<Company> companies) throws Exception
	{
		FileOutputStream fos = AppManager.getInstance().getApplicationContext().openFileOutput(FILENAME_COMPANY , Context.MODE_PRIVATE);
		Gson gson = new Gson();
		String crap = gson.toJson(companies);
		fos.write(crap.getBytes());
		fos.close();
	}
	
	public static List<CompanyDetails> readCachedCompanyDetails()
	{
		FileInputStream fis = null;
		try
		{
			fis = AppManager.getInstance().getApplicationContext().openFileInput(FILENAME_COMPANY_DETAILS);
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new InputStreamReader(fis));
			Type listType= new TypeToken<List<CompanyDetails>>(){}.getType();
			List<CompanyDetails> companyDetails = gson.fromJson(reader,listType);
            if(companyDetails != null){
            	avaialableCompanyDetails=companyDetails;
    	 }
         
			fis.close();
			return companyDetails;
		} catch (FileNotFoundException fnf) {
			//ignore, no method to check if file exists
		}catch (Throwable t) {
			Log.e("Cache reader", "Failed to read cached company details", t);
		} finally
		{
			try
			{
				fis.close();
			} catch (Throwable t)
			{
			}
		}
		return null;
	}	
	public static void updateCompanyDetails(List<Company> companies)
	{
		List<CompanyDetails> allCompanyDetailsToUpdate= new ArrayList<CompanyDetails>();
		for (Company company : companies) {
		CompanyDetails companyDetails=null;
			try {
				companyDetails = NetworkCommunicator.GetCompanyDetails(company.getId());
				companyDetails.setId(company.getId());
				if(companyDetails!=null)
				{
					allCompanyDetailsToUpdate.add(companyDetails);
				}
		    	} catch (Exception e) {
		    		Log.e("Error in details saving", "no of cout");		
		}
		
		}
		
		try{
			CacheReader.saveCompanyDetails(allCompanyDetailsToUpdate);
			Log.e("cache reader saved in list", "no of cout"+allCompanyDetailsToUpdate.size());			
		}catch(Exception e)
		{
			Log.e("Main activity", "error in saving");
		}
		
	}
	
	
	public static void saveCompanyDetails(List<CompanyDetails> companyDetails) throws Exception
	{
		try{
		FileOutputStream fos = AppManager.getInstance().getApplicationContext().openFileOutput(FILENAME_COMPANY_DETAILS, Context.MODE_PRIVATE);
		Gson gson = new Gson();
		String crap = gson.toJson(companyDetails);
		fos.write(crap.getBytes());
		fos.close();
		}catch(Exception e){
			Log.e("Cache reader", "Failed to save");
		}
	}
}
