package lk.study.servicrtest;

import lk.study.servicrtest.MyIntentService.MyBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Intent intent = new Intent(MainActivity.this, MyIntentService.class);
		//startService
		findViewById(R.id.btnStartService).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startService(intent);
			}
		});
		//StopService
		findViewById(R.id.btnStopService).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(intent);
			}
		});
		//BindService
		findViewById(R.id.btnBindService).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bindService(intent, conn, Service.BIND_AUTO_CREATE);
			}
		});
		//UnbindService
		findViewById(R.id.btnUnbindService).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				unbindService(conn);
			}
		});
		findViewById(R.id.btnStartMusicPlayerActivity).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, MusicPlayerActivity.class);
				startActivity(intent);
			}
		});
		
	}
	
	private ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			System.out.println("ServiceDisconnected");
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			((MyBinder)service).getService().helloWorld();
		}
	};

}
