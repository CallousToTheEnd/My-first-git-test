package com.lk.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBService extends SQLiteOpenHelper {
	
	List<String> noteList = new ArrayList<String>();
	List<String> contentList = new ArrayList<String>();
	List<String> timeList = new ArrayList<String>();

	public DBService(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String str = "create table notepaddata (title varchar(16) not null primary key,"
				+ "content text(255) null,"
				+ "time datetime null)";
		db.execSQL(str);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
	
	//���ݱ����ѯ����
	public Cursor dataSelect(String title){
		SQLiteDatabase db = this.getReadableDatabase();
		if(title != null){
			String sql = "select * from notepaddata where title=?";
			Cursor cursor = db.rawQuery(sql, new String[] {title});
			return cursor;
		}else{
			String sql = "select * from notepaddata";
			Cursor cursor = db.rawQuery(sql, null);
			return cursor;
		}
	}
	
	//������ݿ�title���б�
	public List<String> getNoteList(){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = this.dataSelect(null);
		while (cursor.moveToNext()) {
			noteList.add(cursor.getString(cursor.getColumnIndex("title")));
		}
		return noteList;
	}
	
	//���time�б�
	public List<String> getTimeList(){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = this.dataSelect(null);
		while (cursor.moveToNext()) {
			timeList.add(cursor.getString(cursor.getColumnIndex("time")));
		}
		return timeList;
	}
	
	//���content�б�
	public List<String> getContentList(){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = this.dataSelect(null);
		while (cursor.moveToNext()) {
			contentList.add(cursor.getString(cursor.getColumnIndex("content")));
		}
		return contentList;
	}
	
	
	//��������
	public void dataInsert(String title, String content, String time){
		SQLiteDatabase db = this.getWritableDatabase();
		String sql = "insert into notepaddata values(?,?,?)";
		db.execSQL(sql, new String[] {title, content, time});
		
	}
	
	//���ݸ���
	public void dataUpdate(String content, String time, String title){
		SQLiteDatabase db = this.getWritableDatabase();
		String sql = "update notepaddata set content=? where title=?";
		String sql2 = "update notepaddata set time=? where title=?";
		db.execSQL(sql, new String[] {content, title});
		db.execSQL(sql2, new String[] {time, title});
	}
	
	//�ж��Ƿ������ͬ����ļ��±�
	public boolean isExist(String title){
		SQLiteDatabase db = this.getReadableDatabase();
		if(this.getNoteList().contains(title))
			return true;
		return false;
	}

}
