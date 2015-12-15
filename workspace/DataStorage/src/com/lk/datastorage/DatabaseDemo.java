package com.lk.datastorage;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnContextClickListener;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DatabaseDemo extends ListActivity {

	Cursor cursor;
	DatabaseListAdapter adapter;
	DBService dbService;
	String delName; // Ҫɾ��������
	List<String> delNames;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		init();
	}

	@Override
	protected void onResume() {
		super.onResume();
		init();
	}

	public void init() {
		delNames = new ArrayList<String>();
		dbService = new DBService(this);
		cursor = dbService.selectData();
		adapter = new DatabaseListAdapter(this, cursor);
		setListAdapter(adapter);

		// Ϊ�б�����������Ĳ˵�
		getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		getListView().setMultiChoiceModeListener(new MultiChoiceModeListener() {

			@Override
			public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void onDestroyActionMode(ActionMode mode) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean onCreateActionMode(ActionMode mode, Menu menu) {
				MenuInflater inflater = getMenuInflater();
				inflater.inflate(R.menu.databasedemo_context, menu);
				return true;
			}

			@Override
			public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
				switch (item.getItemId()) {
				case R.id.deleteData:
					dbService.deleteData(delNames);
					Toast.makeText(DatabaseDemo.this, "ɾ���ɹ�",
							Toast.LENGTH_SHORT).show();
					init();
					return true;
				case R.id.updataData:
					desplayUpdataframe();
					return true;
				default:
					return false;
				}
			}

			@Override
			public void onItemCheckedStateChanged(ActionMode mode,
					int position, long id, boolean checked) {

				Cursor cursor2 = (Cursor) getListAdapter().getItem(position);
				delName = cursor2.getString(cursor2
						.getColumnIndex(DBService.USER_NAME));
				delNames.add(delName);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflter = getMenuInflater();
		inflter.inflate(R.menu.databasedemo_main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.addData:
			desplayAddframe();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * ��ʾ�����Ϣ�Ի���
	 */
	@SuppressLint("NewApi")
	public void desplayAddframe() {
		new AlertDialog.Builder(this).setView(R.layout.database_demo_addframe)
				.setTitle("���").setPositiveButton("ȷ��", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						AlertDialog alertDialog = (AlertDialog) dialog;
						EditText etAddName = (EditText) alertDialog
								.findViewById(R.id.etAddName);
						EditText etAddAddress = (EditText) alertDialog
								.findViewById(R.id.etAddAddress);
						dbService.insertData(etAddName.getText().toString(),
								etAddAddress.getText().toString());
						init();
						Toast.makeText(DatabaseDemo.this, "�༭�ɹ�",
								Toast.LENGTH_SHORT).show();
					}
				}).setNegativeButton("ȡ��", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				}).create().show();
	}

	@SuppressLint("NewApi")
	public void desplayUpdataframe() {
		new AlertDialog.Builder(this).setView(R.layout.database_demo_addframe)
				.setTitle("���").setPositiveButton("ȷ��", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						AlertDialog alertDialog = (AlertDialog) dialog;
						EditText etAddName = (EditText) alertDialog
								.findViewById(R.id.etAddName);
						EditText etAddAddress = (EditText) alertDialog
								.findViewById(R.id.etAddAddress);
						dbService.updataData(delName, etAddName.getText()
								.toString(), etAddAddress.getText().toString());
						init();
						Toast.makeText(DatabaseDemo.this, "�༭�ɹ�",
								Toast.LENGTH_SHORT).show();
					}
				}).setNegativeButton("ȡ��", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				}).create().show();
	}

}
