package com.lk.sqlite;

import com.lk.db.DBService;

import android.renderscript.Sampler.Value;
import android.support.v4.widget.SearchViewCompat.OnCloseListenerCompat;
import android.support.v7.app.ActionBarActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	TextView textView ;
	Button createButton ;
	Button insertButton;
	Button selectButton;
	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView);
		createButton = (Button) findViewById(R.id.create);
		insertButton = (Button) findViewById(R.id.insert);
		selectButton = (Button) findViewById(R.id.select);
		createButton.setOnClickListener(new createListener());
		insertButton.setOnClickListener(new insertListener());
		selectButton.setOnClickListener(new selectListener());
	}
	
	/*
	 * 创建数据库
	 */
	
	class createListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			DBService dbService = new DBService(MainActivity.this, "test_2", null, 1);
			SQLiteDatabase db = dbService.getReadableDatabase();
		}
		
	}
	
	/*
	 * 向表中插入数据
	 */
	
	class insertListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			DBService dbService = new DBService(MainActivity.this, "test_2", null, 1);
			String sql = "insert into test values(?,?)";
			dbService.query( sql, new String[]{"1","lk"});	
			//第二种方法
//			SQLiteDatabase db = dbService.getWritableDatabase();
//			ContentValues values = new ContentValues();
//			values.put("3", "dz");
//			db.insert("test", null, values);
		}
		
	}
	
	/*
	 * 查询表数据
	 */
	class selectListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			DBService dbService = new DBService(MainActivity.this, "test_2", null, 1);
			SQLiteDatabase sqLiteDatabase = dbService.getReadableDatabase();
			//查询id=1的数据	两种方法
			//Cursor cursor = sqLiteDatabase.rawQuery(select * from test , null);
			Cursor cursor = sqLiteDatabase.query("test", new String[]{"id","name"}, null, null, null, null, null);
			//while是必须要有的，否则会程序终止
			String name = "";
			while(cursor.moveToNext()){
				name = cursor.getString(cursor.getColumnIndex("name"));
				textView.setText("|" + name );
			}
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
