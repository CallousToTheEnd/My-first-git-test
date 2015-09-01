package com.lk.progressbar;

import android.support.v7.app.ActionBarActivity;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	Button firstButton;
	Button secondButton;
	ProgressBar progressBar;
	SeekBar firstSeekBar;
	RatingBar firstRatingBar;
	TextView seekBarAndRatingBarValue;
	int seekBarValue = 0;
	float ratingBarValue = 0;
	//线程
	TextView runnableTextView;
	Button startRunnable;
	Button stopRunnable;
	int index = 0;
	Handler handler = new Handler(); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		firstButton = (Button) findViewById(R.id.firstButton);
		secondButton = (Button) findViewById(R.id.secondButton);
		progressBar = (ProgressBar) findViewById(R.id.firstProgressBar);
		firstSeekBar = (SeekBar) findViewById(R.id.firstSeekBar);
		firstRatingBar = (RatingBar) findViewById(R.id.firstRatingBar);
		seekBarAndRatingBarValue = (TextView) findViewById(R.id.seekBarAndRatinggBarValue);
		firstButton.setOnClickListener(new firstButtonListener());
		secondButton.setOnClickListener(new secondButtonListener());
		firstSeekBar.setOnSeekBarChangeListener(new seekBarlistener());
		firstRatingBar.setOnRatingBarChangeListener(new ratingBarlistener());
		seekBarAndRatingBarValue.setText("SeekBarValue:" + seekBarValue + "RatingBarValue:" + ratingBarValue);
		// 线程
		runnableTextView = (TextView) findViewById(R.id.runnableTextView);
		startRunnable = (Button) findViewById(R.id.startRunnable);
		stopRunnable = (Button) findViewById(R.id.stopRunnable);
		startRunnable.setOnClickListener(new startRunnablelistener());
		stopRunnable.setOnClickListener(new stopRunnablelistener());
		runnableTextView.setText(Thread.currentThread().getName());
	}
		
	
	/**
	 * SeekBar改变事件
	 * @author 康
	 *
	 */
	class seekBarlistener implements OnSeekBarChangeListener{

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			seekBarValue = progress;
			seekBarAndRatingBarValue.setText("SeekBarValue:" + seekBarValue + "RatingBarValue:" + ratingBarValue);
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			
		}
		
	}
	
	/**
	 * RatingBar改变事件
	 * @author 康
	 *
	 */
	class ratingBarlistener implements OnRatingBarChangeListener{

		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) {
			ratingBarValue = rating;
			seekBarAndRatingBarValue.setText("SeekBarValue:" + seekBarValue + "RatingBarValue:" + ratingBarValue);
		}}
	
	/**
	 * 第一个按钮点击事件
	 * @author 康
	 *
	 */
	class firstButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			progressBar.incrementProgressBy(10);
		}
		
	}
	
	/**
	 * 第二个按钮点击事件
	 * @author 康
	 *
	 */
	class secondButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			progressBar.incrementSecondaryProgressBy(10);
		}
		
	}

	/*
	 * 开始线程按钮
	 */
	class startRunnablelistener implements OnClickListener{

		@Override
		public void onClick(View v) {
			handler.post(runnable);		//这个方法启动的线程和activity是同一个线程，它并没有条用start方法，而是调用的run方法
//											按java创建线程然后
//											Thread t = new Thread(runnable);
//											t.start();				这个方法会启动新的线程
//										可以用Thread.currentThread().getName()查看当前线程名称
		}}
	
	/*
	 * 结束线程按钮
	 * 
	 */
	class stopRunnablelistener implements OnClickListener{

		@Override
		public void onClick(View v) {
			handler.removeCallbacks(runnable);
		}
		
	}
	
	/*
	 * 定义线程
	 */
	Runnable runnable = new Runnable(){

		@Override
		public void run(){
			runnableTextView.setText("线程开始时间:" + index + Thread.currentThread().getName());
			index++;
			handler.postDelayed(runnable, 1000);
			
			
		}
		
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
