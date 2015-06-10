package com.interview.evaluationproject.net;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;
import android.telephony.TelephonyManager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.interview.evaluationproject.json.Company;
import com.interview.evaluationproject.json.CompanyDetails;
import com.interview.evaluationproject.utils.Log;
import com.interview.evaluationproject.utils.SettingsManager;
import com.interview.evaluationproject.utils.ProjectProperties;


public class NetworkCommunicator {

	private static String getUrl(String endpoint) {
		return ProjectProperties.getInstance().getProperty("rootUrl") + endpoint;
	}

	public static List<Company> GetAllCompaies() throws ServerException {
		List<Company> customers = new ArrayList<Company>();
		Gson gson = new Gson();
		String endpointUrl = getUrl(ProjectProperties.getInstance().getProperty(
				"get_companies"));
		try {
			HttpResponse response = Network.get(endpointUrl, false);
			StatusLine line = response.getStatusLine();
			if (line.getStatusCode() == 200 || line.getStatusCode() == 201) {
				byte[] responseContent = Network.readResponse(response
						.getEntity().getContent());
				String responseJson = new String(responseContent, 0,
						responseContent.length);
				Log.e("Get customers", responseJson);
				Type type = new TypeToken<List<Company>>() {
				}.getType();
				customers = gson.fromJson(responseJson, type);
			} else {
				throw (new ServerException());
			}
		} catch (NetworkException e) {
			Log.e("Get customers", e.getMessage());
			throw (new ServerException());
		} catch (Throwable t) {
			Log.e("Get customers", t.getMessage());
			throw (new ServerException());
		}

		return customers;
	}

	public static CompanyDetails GetCompanyDetails(String companyId)
			throws ServerException {
		CompanyDetails companyDetails;
		Gson gson = new Gson();
		String endpointUrl = getUrl(ProjectProperties.getInstance().getProperty(
				"get_companyDetails"));
		endpointUrl +=companyId;
		try {
			HttpResponse response = Network.get(endpointUrl, false);
			StatusLine line = response.getStatusLine();
			if (line.getStatusCode() == 200 || line.getStatusCode() == 201) {
				byte[] responseContent = Network.readResponse(response
						.getEntity().getContent());
				String responseJson = new String(responseContent, 0,
						responseContent.length);
				Log.e("company details  with id ", responseJson);
				companyDetails = gson.fromJson(responseJson, CompanyDetails.class);
			} else {
				byte[] responseContent = Network.readResponse(response
						.getEntity().getContent());
				String responseJson = new String(responseContent, 0,
						responseContent.length);
				Log.e("company details  with id ", responseJson);
				throw new ServerException();
			}
		} catch (NetworkException e) {
			Log.e("Get ", e.getMessage());
			throw (new ServerException());
		} catch (Throwable t) {
			Log.e(" User with msisdn customers", t.getMessage());
			throw (new ServerException());
		}

		return companyDetails;
	}

	
}
