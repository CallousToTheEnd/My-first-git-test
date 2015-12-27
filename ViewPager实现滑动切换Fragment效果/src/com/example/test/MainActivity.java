package com.example.test;

import java.util.ArrayList;
import java.util.List;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	private ViewPager viewPager;
	private static final int TAB_COUNT = 3;
	private int current_index = 0;
	private TextView tvTitle1, tvTitle2, tvTitle3;
	private List<TextView> tvTitles;
	private ImageView cursor;
	private static int lineWidth;
	private static int offset;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) findViewById(R.id.viewPager);
		initIvCursor();
		tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
		tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
		tvTitle3 = (TextView) findViewById(R.id.tvTitle3);
		tvTitles = new ArrayList<TextView>();
		tvTitles.add(tvTitle1);
		tvTitles.add(tvTitle2);
		tvTitles.add(tvTitle3);

		viewPager.setAdapter(new FragmentPagerAdapter(
				getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return TAB_COUNT;
			}

			@Override
			public Fragment getItem(int arg0) {
				switch (arg0) {
				case 0:
					return new fragment();
				case 1:
					return new fragment2();
				case 2:
					return new fragment3();
				}
				return null;
			}
		});
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			int one = offset * 2 + lineWidth;

			@Override
			public void onPageSelected(int arg0) {
				Animation animation = new TranslateAnimation(one
						* current_index, one * arg0, 0, 0);
				animation.setFillAfter(true);
				animation.setDuration(300);
				cursor.startAnimation(animation);
				tvTitles.get(current_index).setTextColor(Color.BLACK);
				tvTitles.get(arg0).setTextColor(Color.RED);
				current_index = arg0;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	/**
	 * 
	 */
	private void initIvCursor() {
		cursor = (ImageView) findViewById(R.id.ivCursor);
		// 获取图片宽度
		lineWidth = BitmapFactory.decodeResource(getResources(),
				R.drawable.cursor).getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		// 获取屏幕宽度
		int screenWidth = dm.widthPixels;
		Matrix matrix = new Matrix();
		offset = (int) ((screenWidth / (float) TAB_COUNT - lineWidth) / 2);
		matrix.postTranslate(offset, 0);
		// 设置初始位置
		cursor.setImageMatrix(matrix);
	}

}
