package com.example.firsttest;

import com.example.firsttest.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.preference.*;
import android.preference.Preference.OnPreferenceChangeListener;

public class MainActivity extends PreferenceActivity implements OnPreferenceChangeListener{

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		//getPreferenceManager().setSharedPreferencesName("setting");
		addPreferencesFromResource(R.xml.preference_setting);
		Preference individualNamePreference = findPreference("individual_name");
		SharedPreferences sharedPreferences= individualNamePreference.getSharedPreferences();
		individualNamePreference.setSummary(sharedPreferences.getString("individual_name", ""));
		if (sharedPreferences.getBoolean("yesno_save_individual_info", false))
			 individualNamePreference.setEnabled(true);
		else
			 individualNamePreference.setEnabled(false);
		individualNamePreference.setOnPreferenceChangeListener(this);
		
		

	}

	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue)
	{
		preference.setSummary(String.valueOf(newValue));		
		return true;
	}

	@Override
	public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
			Preference preference)
	{

		if ("yesno_save_individual_info".equals(preference.getKey()))
		{
			findPreference("individual_name").setEnabled(
					!findPreference("individual_name").isEnabled());
		}
		return super.onPreferenceTreeClick(preferenceScreen, preference);
	}
	 
}
