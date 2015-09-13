package lk.study.servicrtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MusicPlayerActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.musicplayer) ;
		
//		startMusic
		findViewById(R.id.btnStartMusic).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MusicPlayerActivity.this, MyService.class);
				intent.putExtra("musicstate", 1);
				startService(intent);
			}
		});
//		pauseMusic
		findViewById(R.id.btnPauseMusic).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MusicPlayerActivity.this, MyService.class);
				intent.putExtra("musicstate", 2);
				startService(intent);
			}
		});
//		stopMusic
		findViewById(R.id.btnStopMusic).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MusicPlayerActivity.this, MyService.class);
				intent.putExtra("musicstate", 3);
				startService(intent);
			}
		});
		
	}
	
}
