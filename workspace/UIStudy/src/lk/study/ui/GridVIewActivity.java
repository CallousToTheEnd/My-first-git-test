package lk.study.ui;

import lk.study.custom_class.GridViewImageAdapter;
import lk.study.uistudy.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

/**
 * GridViewActivity的相关设置
 * @author Mr.li
 *
 */
public class GridVIewActivity extends Activity {

	private GridView gridView;
	private int imageID[] = new int[] { R.drawable.sample_0,
			R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3,
			R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_6,
			R.drawable.sample_7, };;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_gridview);

		gridView = (GridView) findViewById(R.id.gridView1);

		GridViewImageAdapter adapter = new GridViewImageAdapter(this);
		// 设置Adapter
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(GridVIewActivity.this, "Position" + position, Toast.LENGTH_SHORT).show();
			}
		});
	}

}
