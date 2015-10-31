package lk.study.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ExpendableListActivity���������
 * ���Ը���Spinner�Զ���Adapter�ķ����Զ���SimpleExpendableListViewAdapter
 * @author Mr.li
 * 
 */
public class MyExpendableListActivity extends ExpandableListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		displayExpendablaListActivity();
	}

	public void displayExpendablaListActivity() {
		// ��������Դ
		// groupData
		List<HashMap<String, String>> groups = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> group1 = new HashMap<>();
		group1.put("name", "lk");
		HashMap<String, String> group2 = new HashMap<>();
		group2.put("name", "ly");
		HashMap<String, String> group3 = new HashMap<>();
		group3.put("name", "dz");
		groups.add(group1);
		groups.add(group2);
		groups.add(group3);
		// childData
		List<List<HashMap<String, String>>> childs = new ArrayList<List<HashMap<String, String>>>();
		// ��һ�����б�
		List<HashMap<String, String>> child1 = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> childData1 = new HashMap<String, String>();
		childData1.put("content", "my name is lk");
		child1.add(childData1);
		// �ڶ������б�
		List<HashMap<String, String>> child2 = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> childData2 = new HashMap<String, String>();
		childData2.put("content", "my name is ly");
		child2.add(childData2);
		// ���������б������������
		List<HashMap<String, String>> child3 = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> childData3 = new HashMap<String, String>();
		childData3.put("content", "my name is dz");
		HashMap<String, String> childData3_2 = new HashMap<>();
		childData3_2.put("content", "2");
		child3.add(childData3);
		child3.add(childData3_2);
		// ���3�����б�
		childs.add(child1);
		childs.add(child2);
		childs.add(child3);
		// ����Adapter��������Դ������ϵ
		SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
				this, groups, android.R.layout.simple_expandable_list_item_1,
				android.R.layout.simple_expandable_list_item_2,
				new String[] { "name" }, new int[] { android.R.id.text1 },
				childs, android.R.layout.simple_expandable_list_item_1,
				new String[] { "content" }, new int[] { android.R.id.text1 });
		// ����Adapter
		setListAdapter(adapter);
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		TextView tv = (TextView) v;
		Toast.makeText(
				this,
				"groupPosition: " + groupPosition + "childPosition: "
						+ childPosition + "child row id: " + id + tv.getText(),
				3000).show();
		return super.onChildClick(parent, v, groupPosition, childPosition, id);
	}

}
