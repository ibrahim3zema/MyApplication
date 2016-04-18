package com.example.ibra.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.androidopentutorials.sharedpreference.R;
import com.example.ibra.myapplication.utils.SharedPreference;
import java.util.HashSet;
import java.util.Set;
public class MainActivity extends Activity {
	private EditText textEtxt;
	private Button saveButton;
	private Button activity2Button;
	private String text;
	private SharedPreference sharedPreference;
	Activity context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sharedPreference = new SharedPreference();
		findViewsById();
		saveButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				text = textEtxt.getText().toString();
				sharedPreference.save(context, text);
				Toast.makeText(context, getResources().getString(R.string.saved), Toast.LENGTH_LONG).show();
				textEtxt.setText("");
			}
		});
		activity2Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, SecondActivity.class);
				startActivity(intent);
			}
		});
	}
	private void findViewsById() {
		textEtxt = (EditText) findViewById(R.id.etxt_text);
		saveButton = (Button) findViewById(R.id.button_save);
		activity2Button = (Button) findViewById(R.id.button_second_activity);
	}


}
