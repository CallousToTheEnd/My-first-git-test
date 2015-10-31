package lk.study.ui;

import lk.study.uistudy.R;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.Phones;
import android.widget.SimpleCursorAdapter;

public class PhoneListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		displayPhoneList();
	}

	public void displayPhoneList() {
		Cursor cursor = getContentResolver().query(Phones.CONTENT_URI, null,
				null, null, null);
		//第二个参数是ListView要显示的模板，第五个参数是模板中的组件id
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.spinner_item, cursor, new String[] { Phones.NAME,
						Phones.NUMBER }, new int[] { R.id.tvName,
						R.id.tvAddress });
		setListAdapter(adapter);
	}

}
