package com.interview.evaluationproject.utils;

import com.google.gson.Gson;


import android.content.Context;
import android.content.SharedPreferences;

public class SettingsManager {

	private static String PREFERENCE_SETTINGS = "appPreferenceSettings";

	// keys
	private static String KEY_SIGNED_UP = "signedUp";
	private static String KEY_GCM_REG_ID = "gcmregid";
	private static String KEY_NAME_ON_CARD = "nameoncard";
	private static String KEY_CARD_NUMBER = "cardnumber";
	private static String KEY_BARCODE = "barcode";
	private static String KEY_HAS_CARD = "hascard";
	private static String KEY_DO_UPDATE_LOCATION = "doupdatelocation";
	private static String KEY_USER_DATA = "userdata";
	private static String KEY_APP_IN_FOREGROUND = "appinforeground";
	private static String KEY_APP_URL = "appurl";
	private static String KEY_MERCHANT_DATA = "merchantdata";
	private static String KEY_IS_MERCHANT = "ismerchant";
	private static String KEY_CAWVER_LOYALTY_CARD = "cawverloyaltycard";
	// keys

	private static SettingsManager instance;

	private SharedPreferences appSettings;
	private SharedPreferences.Editor settingsEditor;
	private boolean isInitialized = false;

	public static SettingsManager getInstance() {
		if (instance == null) {
			instance = new SettingsManager();
		}
		return instance;
	}

	public void init(Context context) {
		if (!isInitialized) {
			appSettings = context.getSharedPreferences(PREFERENCE_SETTINGS, 0);
			settingsEditor = appSettings.edit();
			isInitialized = true;
		}
	}

	public boolean isSignedUp() {
		return appSettings.getBoolean(KEY_SIGNED_UP, false);
	}

	public void setSignedUp(boolean val) {
		settingsEditor.putBoolean(KEY_SIGNED_UP, val);
		settingsEditor.commit();
	}
	
	public String getGcmRegId(){
		return appSettings.getString(KEY_GCM_REG_ID, "");
	}
	
	public void setGCMRegId(String val){
		settingsEditor.putString(KEY_GCM_REG_ID, val);
		settingsEditor.commit();
	}
	
	public boolean hascard() {
		return appSettings.getBoolean(KEY_HAS_CARD, false);
	}

	public void setHasCard(boolean val) {
		settingsEditor.putBoolean(KEY_HAS_CARD, val);
		settingsEditor.commit();
	}
	
	public boolean appInForeground() {
		return appSettings.getBoolean(KEY_APP_IN_FOREGROUND, false);
	}

	public void setAppInForeground(boolean val) {
		settingsEditor.putBoolean(KEY_APP_IN_FOREGROUND, val);
		settingsEditor.commit();
	}
	
	public boolean doLocationUpdate() {
		return appSettings.getBoolean(KEY_DO_UPDATE_LOCATION, true);
	}

	public void setDoLocationUpdate(boolean val) {
		settingsEditor.putBoolean(KEY_DO_UPDATE_LOCATION, val);
		settingsEditor.commit();
	}
	
	public String getNameOnCard(){
		return appSettings.getString(KEY_NAME_ON_CARD, "");
	}
	
	public void setNameOnCard(String val){
		settingsEditor.putString(KEY_NAME_ON_CARD, val);
		settingsEditor.commit();
	}
	
	public String getCardNumber(){
		return appSettings.getString(KEY_CARD_NUMBER, "");
	}
	
	public void setCardNumber(String val){
		settingsEditor.putString(KEY_CARD_NUMBER, val);
		settingsEditor.commit();
	}
	
	public String getBarcode(){
		return appSettings.getString(KEY_BARCODE, "");
	}
	
	public void setBarcode(String val){
		settingsEditor.putString(KEY_BARCODE, val);
		settingsEditor.commit();
	}
	
	public String getAppUrl(){
		return appSettings.getString(KEY_APP_URL, "");
	}
	
	public void setAppUrl(String val){
		settingsEditor.putString(KEY_APP_URL, val);
		settingsEditor.commit();
	}
	
/*	public void setUserData(JsonCustomer customer){
		Gson gson = new Gson();
		String userJson = gson.toJson(customer);
		settingsEditor.putString(KEY_USER_DATA, userJson);
		settingsEditor.commit();
	}
	
	public JsonCustomer getUserData(){
		String userJson = appSettings.getString(KEY_USER_DATA, "");
		Gson gson = new Gson();
		return gson.fromJson(userJson, JsonCustomer.class);
	}
	
	public void setMerchantData(JsonOutlet outlet){
		Gson gson = new Gson();
		String outletJson = gson.toJson(outlet);
		settingsEditor.putString(KEY_MERCHANT_DATA, outletJson);
		settingsEditor.commit();
	}
	
	public JsonOutlet getMerchantData(){
		String outletJson = appSettings.getString(KEY_MERCHANT_DATA, "");
		Gson gson = new Gson();
		return gson.fromJson(outletJson, JsonOutlet.class);
	}
	
	public void setCawverLoyaltyCard(CawverLoyaltyCard card){
		Gson gson = new Gson();
		String json = gson.toJson(card);
		settingsEditor.putString(KEY_CAWVER_LOYALTY_CARD, json);
		settingsEditor.commit();
	}
	
	public CawverLoyaltyCard getCawverLoyaltyCard(){
		String json = appSettings.getString(KEY_CAWVER_LOYALTY_CARD, "");
		Gson gson = new Gson();
		return gson.fromJson(json, CawverLoyaltyCard.class);
	}*/
	
	public boolean isMerchant() {
		return appSettings.getBoolean(KEY_IS_MERCHANT, false);
	}

	public void setIsMerchant() {
		settingsEditor.putBoolean(KEY_IS_MERCHANT, true);
		settingsEditor.commit();
	}
}
