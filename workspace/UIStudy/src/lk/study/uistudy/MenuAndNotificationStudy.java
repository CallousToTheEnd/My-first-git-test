package lk.study.uistudy;

import lk.study.ui.MyListActivity;
import lk.study.ui.MyTabActivity;
import lk.study.ui.MyVeiw;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuAndNotificationStudy extends Activity {

	TextView tvMenuStudy_01;
	TextView tvMenuStudy_02;
	Button btnStartListActivity;
	Button btnStartNotification;
	ActionMode mMode;
	NotificationManager notificationManager;
	NotificationCompat.Builder mBuilder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_study);

		tvMenuStudy_01 = (TextView) findViewById(R.id.tvMenuStudy_01);
		tvMenuStudy_02 = (TextView) findViewById(R.id.tvMenuStudy_02);
		btnStartListActivity = (Button) findViewById(R.id.btnMenuStudyStartListActivity);
		btnStartNotification = (Button) findViewById(R.id.btnMenuStudyStartNotification);
		createNotification();

		// 上下文浮动菜单
		tvMenuStudy_01.setOnCreateContextMenuListener(this);
		// 上下文操作模式
		tvMenuStudy_02.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				if (mMode != null) {
					return false;
				}
				mMode = MenuAndNotificationStudy.this.startActionMode(callback);
				v.setSelected(true);
				return true;
			}
		});
		// ListView中应用批量上下文操作
		btnStartListActivity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuAndNotificationStudy.this,
						MyListActivity.class);
				startActivity(intent);
			}
		});
		// 创建Notification
		btnStartNotification.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				notificationManager.notify(1, mBuilder.build());
			}
		});
	}

	// 操作栏菜单
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		menu.add(Menu.NONE, 0, Menu.NONE, "动态添加的菜单");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			Toast.makeText(this, item.getTitle() + ":" + item.getItemId(),
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_item1:
			Toast.makeText(this, item.getTitle() + ":" + item.getItemId(),
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_item2_child1:
			Toast.makeText(this, item.getTitle() + ":" + item.getItemId(),
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_item2_child2:
			Toast.makeText(this, item.getTitle() + ":" + item.getItemId(),
					Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	// 上下文菜单
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.context_menu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.context_menu_item1:
			Toast.makeText(this, item.getTitle() + ":" + item.getItemId(),
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.context_menu_item2:
			Toast.makeText(this, item.getTitle() + ":" + item.getItemId(),
					Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onContextItemSelected(item);
	}

	// 创建上下文操作模式
	private ActionMode.Callback callback = new ActionMode.Callback() {

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
			inflater.inflate(R.menu.context_menu, menu);
			return true;
		}

		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			switch (item.getItemId()) {
			case R.id.context_menu_item1:
				Toast.makeText(MenuAndNotificationStudy.this,
						item.getTitle() + ":" + item.getItemId(),
						Toast.LENGTH_SHORT).show();
				mode.finish();
				return true;
			case R.id.context_menu_item2:
				Toast.makeText(MenuAndNotificationStudy.this,
						item.getTitle() + ":" + item.getItemId(),
						Toast.LENGTH_SHORT).show();
				mode.finish();
				return true;
			default:
				return false;
			}

		}
	};

	/**
	 * 创建Notification
	 */
	private void createNotification() {

		notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		Intent mIntent = new Intent(this, MyTabActivity.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(MyTabActivity.class);
		stackBuilder.addNextIntent(mIntent);
		PendingIntent mPendingIntent = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		// 将扩展布局应用于Notification
		NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
		String[] events = new String[6];
		for (int i = 0; i < events.length; i++) {
			inboxStyle.addLine(events[i]);
		}
		mBuilder = new NotificationCompat.Builder(this)
				.setSmallIcon(R.drawable.ic_launcher)
				.setContentText("ContentText").setContentTitle("ContentTitle")
				.setContentIntent(mPendingIntent).setSubText("SubText")
				.setStyle(inboxStyle)
				.setAutoCancel(true)
				.setVisibility(NotificationCompat.VISIBILITY_SECRET);
		
	}

	@Override
	protected void onStop() {
		//notificationManager.cancelAll();
		super.onStop();
	}

}
