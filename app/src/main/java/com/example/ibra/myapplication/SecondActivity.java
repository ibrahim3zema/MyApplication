package com.example.ibra.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.androidopentutorials.sharedpreference.R;
import com.example.ibra.myapplication.utils.SharedPreference;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SecondActivity extends Activity {
	private Set<String> text;
	private SharedPreference sharedPreference;
	Activity context = this;
	ListView listView ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		listView=(ListView)findViewById(R.id.listView);
		sharedPreference = new SharedPreference();
		//Retrieve a value from SharedPreference
		text = sharedPreference.getValue(context);
		String[] arr = text.toArray(new String[text.size()]);
		List<String> list= Arrays.asList(arr);
		ArrayAdapter adpter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
		listView.setAdapter(adpter);
		
	}

}
