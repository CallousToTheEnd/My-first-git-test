package lk.study.ui;

import lk.study.uistudy.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

/**
 * 显示TabHost控件的Activity 注意：如果要在TabHost上显示不同的Activity必须继承TabActivity
 * 
 * @author Mr.li
 * 
 */
public class MyTabActivity extends Activity {

	private TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_tabhost);

		tabHost = (TabHost) findViewById(R.id.tabhost);
		tabHost.setup(); // 如果不继承TabActivity此句必须写
		TabSpec tabSpec1 = tabHost.newTabSpec("tab1").setIndicator("tab11")
				.setContent(R.id.tab1);
		TabSpec tabSpec2 = tabHost.newTabSpec("tab2").setIndicator("tab22")
				.setContent(R.id.tab2);
		TabSpec tabSpec3 = tabHost.newTabSpec("tab3").setIndicator("tab33")
				.setContent(R.id.tab3);
		tabHost.addTab(tabSpec1);
		tabHost.addTab(tabSpec2);
		tabHost.addTab(tabSpec3);
	}

}
