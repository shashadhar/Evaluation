package com.interview.evaluationproject.utils;

public class Log {

	private static boolean log = ProjectProperties.getInstance()
			.getProperty("enablelog").equals("true");

	public static void e(String tag, String msg) {
		if (log) {
			android.util.Log.e(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (log) {
			android.util.Log.d(tag, msg);
		}
	}

	public static void i(String tag, String msg) {
		if (log) {
			android.util.Log.i(tag, msg);
		}
	}
	
	public static void e(String tag, String msg, Throwable t) {
		if (log) {
			android.util.Log.e(tag, msg, t);
		}
	}
}
