package com.lk.datastorage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	CheckBox checkBox;
	RadioGroup radioGroup;
	EditText editText;
	Button btnSave, btnRead;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		checkBox = (CheckBox) findViewById(R.id.checkBox1);
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		editText = (EditText) findViewById(R.id.editText1);
		btnSave = (Button) findViewById(R.id.btnSave);
		btnRead = (Button) findViewById(R.id.btnRead);
		btnSave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				saveData();
			}
		});
		btnRead.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				readDate();
			}
		});
		
	}

	/**
	 * SharedPreferences存储数据
	 */
	private void saveData() {
		SharedPreferences settings = getSharedPreferences("mySetting", 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean("checkedCheckBox", checkBox.isChecked());
		editor.putInt("checkedRadioButtonID",
				radioGroup.getCheckedRadioButtonId());
		editor.putString("editText", editText.getText().toString());
		editor.commit();
		Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
	}

	/**
	 * SharedPreferences读取数据
	 */
	private void readDate() {
		// 调用自定义xmlSharePreference文件
		SharedPreferences settings = getSharedPreferences("mySetting", 0);
		checkBox.setChecked(settings.getBoolean("checkedCheckBox", false));
		radioGroup.check(settings.getInt("checkedRadioButtonID", R.id.radio0));
		editText.setText(settings.getString("editText", null));
		// 调用系统默认SharedPreference
		SharedPreferences delete_old_sms = PreferenceManager
				.getDefaultSharedPreferences(this);
		System.out.println(delete_old_sms.getBoolean("delete old sms", false));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			Intent settingsActivityIntent = new Intent(this,
					SettingsActivity.class);
			startActivity(settingsActivityIntent);
			break;
		case R.id.startDatabaseDemoActivity:
			Intent databaseDemoIntent = new Intent(this, DatabaseDemo.class);
			startActivity(databaseDemoIntent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
