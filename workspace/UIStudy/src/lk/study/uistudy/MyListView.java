package lk.study.uistudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 直接用XML中的ListView控件来实现列表效果
 * @author Mr.li
 *
 */
public class MyListView extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_listview) ;
		setListView() ;
	}
	
	/**
	 * ListView 的设置
	 */
	private void setListView(){
		//ListView listView1 = (ListView) findViewById(R.id.listView1) ;	改变ui_lisetview中的id才能用
		//建立数据源
		String[] counties = new String[] {"中国", "美国", "德国", "意大利"} ;
		//建立Adapter并与数据进行连接
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, counties) ;
		//设置Adapter
		//listView1.setAdapter(adapter) ;    
	}
	
}
