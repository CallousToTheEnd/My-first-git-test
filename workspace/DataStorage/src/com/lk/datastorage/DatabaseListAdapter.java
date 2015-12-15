package com.lk.datastorage;

import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DatabaseListAdapter extends BaseAdapter {

	Context mContext;
	Cursor mCursor;

	public DatabaseListAdapter(Context context, Cursor cursor) {
		mContext = context;
		mCursor = cursor;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mCursor.getCount();
	}

	@Override
	public Object getItem(int position) {
		mCursor.moveToPosition(position);
		return mCursor;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(mContext).inflate(
				R.layout.database_demo_listitem, null);
		TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
		TextView tvAddress = (TextView) convertView
				.findViewById(R.id.tvAddress);

		mCursor.moveToPosition(position);
		tvName.setText(mCursor.getString(mCursor
				.getColumnIndex(DBService.USER_NAME)));
		tvAddress.setText(mCursor.getString(mCursor
				.getColumnIndex(DBService.USER_ADDRESS)));
		return convertView;
	}

}
