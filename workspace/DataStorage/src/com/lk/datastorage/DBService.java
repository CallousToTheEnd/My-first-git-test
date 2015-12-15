package com.lk.datastorage;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBService extends SQLiteOpenHelper {

	public static final String TABLE_NAME = "users";
	public static final String ID = "_id";
	public static final String USER_NAME = "user_name";
	public static final String USER_ADDRESS = "user_address";

	public DBService(Context context) {
		super(context, "user_info", null, 1);
	}

	public DBService(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + USER_NAME
				+ " TEXT NOT NULL," + USER_ADDRESS + " TEXT NOT NULL)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	/**
	 * �������
	 * 
	 * @param name
	 *            Ҫ��ӵ�USER_NAME
	 * @param address
	 *            Ҫ��ӵ�USER_ADDRESS
	 */
	public void insertData(String name, String address) {
		ContentValues values = new ContentValues();
		values.put(USER_NAME, name);
		values.put(USER_ADDRESS, address);
		this.getWritableDatabase().insert(TABLE_NAME, null, values);
	}

	/**
	 * ��ѯ���ݿ�����
	 * 
	 * @return ����USER_NAME��USER_ADDRESS
	 */
	public Cursor selectData() {
		return this.getReadableDatabase().query(TABLE_NAME,
				new String[] { USER_NAME, USER_ADDRESS }, null, null, null,
				null, null);
	}

	/**
	 * ɾ��ָ�����ֵ�����
	 * 
	 * @param names
	 *            Ҫɾ����USER_NAME
	 */
	public void deleteData(List<String> names) {
		SQLiteDatabase db = this.getWritableDatabase();
		try {
			db.beginTransaction();
			for (int i = 0; i < names.size(); i++) {
				String p = names.get(i);
				db.delete(TABLE_NAME, USER_NAME + "=?", new String[] { p });
			}
			ContentValues values = new ContentValues();
			values.put("seq", 0);
			db.update("sqlite_sequence", values, "name=?", new String[]{TABLE_NAME});
			db.setTransactionSuccessful();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			db.endTransaction();
		}
		

	}

	/**
	 * ��������
	 * 
	 * @param whereName
	 *            �ɵ�USER_NAME
	 * @param name
	 *            �µ�USER_NAME
	 * @param address
	 *            �µ�USER_ADDRESS
	 */
	public void updataData(String whereName, String name, String address) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(USER_NAME, name);
		values.put(USER_ADDRESS, address);
		System.out.println(address + ":" + whereName);
		db.update(TABLE_NAME, values, USER_NAME + "=?",
				new String[] { whereName });
	}

}
