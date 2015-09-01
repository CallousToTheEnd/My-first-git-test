package com.lk.db;

import android.R;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class DBService extends SQLiteOpenHelper {

	private final static int DATABASE_VERSION = 1; 
	
	/*
	 * ���췽��
	 */
	public DBService(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	public DBService(Context context, String name, CursorFactory factory){
		super(context, name, factory, DATABASE_VERSION);
	}
	

	/*
	 * �������ݿ�ʱִ��
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		//�������ݿ�ʱ����
		String sql = "create table test (id varchar primary key," +
				"name varchar(5))";
		db.execSQL(sql);
	}

	/*
	 * �Զ���������ݵķ���
	 */
	public void query(String sql , String[] args){
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL(sql, args);
	}
	
	/*
	 * �������ݿ�ʱִ�еķ���
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
