package com.example.httpget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	Button btnLoad;
	ImageView iv;
	Bitmap bm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnLoad = (Button) findViewById(R.id.btnLoad);
		iv = (ImageView) findViewById(R.id.imageView);
		
		btnLoad.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new AsyncTask<String, Void, Void>(){

					@Override
					protected Void doInBackground(String... params) {
						try {
							URL url = new URL(params[0]);
							URLConnection conn = url.openConnection();
							InputStream is = conn.getInputStream();
							InputStreamReader isr = new InputStreamReader(is,"utf-8");
							BufferedReader br = new BufferedReader(isr);
							
//							bm = BitmapFactory.decodeStream(is);
//							Message msg = new Message();
//							msg.what = 1;
//							hanler.sendMessage(msg);
							
							String line;
							while ((line = br.readLine()) != null) {
								System.out.println(line);
							}
							br.close();
							isr.close();
							is.close();
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
					}}.execute("http://www.baidu.com");
			}
		});
	}
	Handler hanler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			if(msg.what == 1)
				iv.setImageBitmap(bm);
			super.handleMessage(msg);
		}
		
	};

	
}
