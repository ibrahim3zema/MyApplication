package com.example.ibra.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashSet;
import java.util.Set;

//import android.preference.PreferenceManager;
public class SharedPreference {
	public static final String PREFS_NAME = "AOP_PREFS";
	public static final String PREFS_KEY = "AOP_PREFS_String";
	Set<String> arr = new HashSet<>();
	public SharedPreference() {
		super();
	}
	public void save(Context context, String txt) {
		SharedPreferences settings;
		Editor editor;
		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
		editor = settings.edit(); //2
		arr.add(txt);
		editor.putStringSet(PREFS_KEY, arr); //3
		editor.commit(); //4
	}

	public Set<String> getValue(Context context) {
		SharedPreferences settings;
		Set<String> text ;
		//settings = PreferenceManager.getDefaultSharedPreferences(context);
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		text = settings.getStringSet(PREFS_KEY, null);
		return text;
	}
	public void removeValue(Context context) {
		SharedPreferences settings;
		Editor editor;
		settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		editor = settings.edit();
		editor.remove(PREFS_KEY);
		editor.commit();
	}
}
