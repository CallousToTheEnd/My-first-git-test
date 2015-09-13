package lk.study.servicrtest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
	
	MediaPlayer mMediaPlayer ;

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("onBind");
		return null;
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("onUnbind");
		return super.onUnbind(intent);
	}
	@Override
	public void onCreate() {
		System.out.println("onCreate");
		mMediaPlayer = MediaPlayer.create(this, R.raw.musicservice) ;
		super.onCreate();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand");
		int state = intent.getIntExtra("musicstate", 0);
		if(intent != null)
		{
			switch(state){
			case 0: 
				Toast.makeText(this, "No music", 3000).show();
				break;
			case 1:
				mMediaPlayer.start();
				break;
			case 2:
				mMediaPlayer.pause();
				break;
			case 3:
				mMediaPlayer.stop();
				break;
			}
		}
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}
	
}
