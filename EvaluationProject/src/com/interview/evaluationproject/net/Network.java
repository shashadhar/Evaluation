package com.interview.evaluationproject.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ByteArrayEntity;

import com.interview.evaluationproject.net.HttpManager;
import com.interview.evaluationproject.net.NetworkException;
import com.interview.evaluationproject.utils.Log;


public class Network {
	
	

	public static HttpResponse get(String url, List<NameValuePair> params,
			boolean oauth) throws NetworkException {

		if (params != null && params.size() > 0) {
			if (!url.endsWith("?"))
				url += "?";
			String paramString = URLEncodedUtils.format(params, "utf-8");
			url += paramString;
		}
		Log.d(Network.class.getName(), "url: " + url);
		HttpGet request = new HttpGet(url);
		request.setHeader("Accept", "application/json");

		String phoneLanguage = "en-US";
		request.setHeader("Accept-Language", phoneLanguage);

		if (oauth) {
			String accessToken = "";
			String oauthHeader = "Bearer " + accessToken;
			request.addHeader("Authorization", oauthHeader);
		}

		HttpResponse response = HttpManager.execute(request);
		return response;

	}


	public static HttpResponse get(String url, boolean oauth)
			throws NetworkException {

		HttpGet request = new HttpGet(url);
		request.setHeader("Accept", "application/json");

		String phoneLanguage = "en-US";
		request.setHeader("Accept-Language", phoneLanguage);

		if (oauth) {
			String accessToken = "";
			String oauthHeader = "Bearer " + accessToken;
			request.addHeader("Authorization", oauthHeader);
		} else {
			Log.i("Network call",
					String.format("url %s outside oauth domain", url));
		}
		HttpResponse response = HttpManager.execute(request);
		return response;

	}

	/**
	 * Note: can not use content length
	 * 
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static byte[] readResponse(InputStream input) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[2048];

		while (true) {
			int r = input.read(buf, 0, buf.length);
			if (r == -1) {
				break;
			}
			baos.write(buf, 0, r);
		}
		return baos.toByteArray();
	}

	

	
}
