package lk.study.uistudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * ֱ����XML�е�ListView�ؼ���ʵ���б�Ч��
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
	 * ListView ������
	 */
	private void setListView(){
		//ListView listView1 = (ListView) findViewById(R.id.listView1) ;	�ı�ui_lisetview�е�id������
		//��������Դ
		String[] counties = new String[] {"�й�", "����", "�¹�", "�����"} ;
		//����Adapter�������ݽ�������
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, counties) ;
		//����Adapter
		//listView1.setAdapter(adapter) ;    
	}
	
}
