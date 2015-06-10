package com.interview.evaluationproject.net;

import java.io.IOException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Properties;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

import com.interview.evaluationproject.net.NetworkException;
import com.interview.evaluationproject.utils.Log;


public class HttpManager {
	private static final DefaultHttpClient sClient;
	private static String network_error = "We are not able to access our servers. Please try again later";
	static {

		// Set basic data
		HttpParams params = new BasicHttpParams();
		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, "UTF-8");
		
		//the following would only be if we were sending large amount of data, and waiting
		//for authentication from headers first
		HttpProtocolParams.setUseExpectContinue(params, false);
		HttpProtocolParams.setUserAgent(params, "MeneameAndroid/0.1.6");

		// Make pool
		int val = 2;
		ConnPerRoute connPerRoute = new ConnPerRouteBean(val);
		ConnManagerParams.setMaxConnectionsPerRoute(params, connPerRoute);
		int maxTotalConnections = 2;
		ConnManagerParams.setMaxTotalConnections(params, maxTotalConnections);
		final int maxTryIfFail = 3;
		
		// Set timeout
		HttpConnectionParams.setStaleCheckingEnabled(params, false);
		int connectionTimeOutInSeconds = 20;
		HttpConnectionParams.setConnectionTimeout(params,
				connectionTimeOutInSeconds * 1000);
		int socketTimeOutInSeconds = 20;
		HttpConnectionParams
				.setSoTimeout(params, socketTimeOutInSeconds * 1000);
		HttpConnectionParams.setSocketBufferSize(params, 8192);

		// Some client params
		// HttpClientParams.setRedirecting(params, false);

		// Register http/s shemas!
		SchemeRegistry schReg = new SchemeRegistry();
		
		String isSelfSigned = "true";
		
		if(isSelfSigned.equals("true")){
			schReg.register(new Scheme ("http", PlainSocketFactory.getSocketFactory (), 80));
			//schReg.register(new Scheme("https", new EasySSLSocketFactory(), 443));
		}else{
			schReg.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
		}
				
		ClientConnectionManager conMgr = new ThreadSafeClientConnManager(
				params, schReg);
		sClient = new DefaultHttpClient(conMgr, params);
	    sClient.setRedirectHandler(new RedirectHandler() {
	        public URI getLocationURI(HttpResponse response,
	                HttpContext context) throws ProtocolException {
	            return null;
	        }

	        public boolean isRedirectRequested(HttpResponse response,
	                HttpContext context) {
	            return false;
	        }
	    });
	    
		HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {

			@Override
			public boolean retryRequest(IOException exception, int executionCount,
					HttpContext context) {
				if (executionCount >= maxTryIfFail) {
					return false;
				}else if(exception instanceof HttpHostConnectException){
					return true;
				}else if(exception instanceof ConnectTimeoutException){
					return true;
				}else if (exception instanceof NoHttpResponseException){
					return true;
				}else if (exception instanceof UnknownHostException) {
					return true;
				} else if (exception instanceof java.net.ConnectException) {
					return true;
				}
				return false;
			}
		};

		sClient.setHttpRequestRetryHandler(retryHandler);

	}

	private static int toInt(String intString, int defaultValue) {
		try {
			return Integer.parseInt(intString);
		} catch (Exception e) {
			Log.e("HttpManager", "Error while parsing " + intString);
			return defaultValue;
		}
	}

	private HttpManager() {
	}

	public static HttpResponse execute(HttpHead head) throws NetworkException {
		try{
			return sClient.execute(head);
		}catch(HttpHostConnectException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}catch(ConnectTimeoutException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}catch(IOException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}
	}

	public static HttpResponse execute(HttpHost host, HttpGet get)
			throws NetworkException {
		try{
			return sClient.execute(host, get);
		}catch(HttpHostConnectException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}catch(ConnectTimeoutException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}catch(IOException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}

	}

	public static HttpResponse execute(HttpGet get) throws NetworkException {
		try{
			return sClient.execute(get);
		}catch(HttpHostConnectException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}catch(ConnectTimeoutException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}catch(IOException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}
	}

	public static HttpResponse execute(HttpPost post) throws NetworkException {
		try{
			return sClient.execute(post);
		}catch(HttpHostConnectException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}catch(ConnectTimeoutException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}catch(IOException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}
	}

	public static HttpResponse execute(HttpPut put) throws NetworkException {
		try{
			return sClient.execute(put);
		}catch(HttpHostConnectException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}catch(ConnectTimeoutException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}catch(IOException e){
			e.printStackTrace();
			throw new NetworkException(network_error);
		}
	}

	public static synchronized CookieStore getCookieStore() {
		return sClient.getCookieStore();
	}
}
