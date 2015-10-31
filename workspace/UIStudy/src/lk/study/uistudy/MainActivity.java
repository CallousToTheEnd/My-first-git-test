package lk.study.uistudy;

import java.text.Format;

import lk.study.ui.GridVIewActivity;
import lk.study.ui.MyExpendableListActivity;
import lk.study.ui.MyListActivity;
import lk.study.ui.MyTabActivity;
import lk.study.ui.PhoneListActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		// startMyViewActivity
		findViewById(R.id.btnStartMyView).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								MyViewActivity.class);
						startActivity(intent);
					}
				});
		// startDrawableActivity
		findViewById(R.id.btnStartDrawableActivity).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								DrawableActivity.class);
						startActivity(intent);
					}
				});
		// startUiLayoutActivity
		findViewById(R.id.btnStartUiLayoutActivity).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								UiLayoutActivity.class);
						startActivity(intent);
					}
				});
		// 在Activity中加载ListView
		findViewById(R.id.btnStartMyListView).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								MyListView.class);
						startActivity(intent);
					}
				});
		// 在ListActivity中加载ListView
		findViewById(R.id.btnStartMyListActivity).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								MyListActivity.class);
						startActivity(intent);
					}
				});
		// ListView显示通讯录
		findViewById(R.id.btnStartPhoneListActivity).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								PhoneListActivity.class);
						startActivity(intent);
					}
				});
		// Start ExtendableListView
		findViewById(R.id.btnStartExpendableListActivity).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								MyExpendableListActivity.class);
						startActivity(intent);
					}
				});
		// Start GridView
		findViewById(R.id.btnStartGridViewActivity).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								GridVIewActivity.class);
						startActivity(intent);
					}
				});
		// Start MyTabActivity
		findViewById(R.id.btnStartMyTabsActivity).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								MyTabActivity.class);
						startActivity(intent);
					}
				});
		// Start MenuStudy
		findViewById(R.id.btnStartMenuStudyActivity).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,
								MenuAndNotificationStudy.class);
						startActivity(intent);
					}
				});
	}

}
