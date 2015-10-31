package lk.study.ui;

import java.util.ArrayList;

import lk.study.uistudy.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * 继承自ListActivity的自定义Activity 实现ListView
 * 
 * @author Mr.li
 * 
 */
public class MyListActivity extends ListActivity {

	ArrayList<String> counties;
	EditText editTextAddListItem;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.ui_listview);
		setListActivity();
		ListItemMenu();
	}

	/**
	 * 对ListActivity的设置 使用默认ListActivity的ListView模板显示ListView
	 */
	private void setListActivity() {
		// 建立数据源
		// String[] counties = new String[] {"中国", "美国", "德国", "意大利"} ;
		counties = new ArrayList<String>();
		counties.add("China");
		// 建立Adapter并与数据进行连接
		adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
				counties);
		// 设置Adapter
		setListAdapter(adapter);
		editTextAddListItem = (EditText) findViewById(R.id.editTextAddlistItem);
		editTextAddListItem.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_ENTER
						&& event.getAction() == KeyEvent.ACTION_UP) {
					counties.add(editTextAddListItem.getText().toString());
					adapter.notifyDataSetChanged();
					editTextAddListItem.setText(null);
				}
				return false;
			}
		});
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		counties.remove(position);
		adapter.notifyDataSetChanged();
	}
	

	/**
	 * 列表项批量上下文操作
	 */
	private void ListItemMenu() {
		final ListView listView = getListView();
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {

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
					Toast.makeText(MyListActivity.this,
							"你点击了" + item.getTitle(), Toast.LENGTH_SHORT)
							.show();
					return true;
				case R.id.context_menu_item2:
					Toast.makeText(MyListActivity.this,
							"你点击了" + item.getTitle(), Toast.LENGTH_SHORT)
							.show();
					return true;
				default:
					return false;
				}

			}

			@Override
			public void onItemCheckedStateChanged(ActionMode mode,
					int position, long id, boolean checked) {
				// TODO Auto-generated method stub
			}
		});
	}

}
