package com.example.httppost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.example.httpget.R;

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
import android.widget.TextView;

public class MainActivity extends Activity {

	Button btnLoad;
//	ImageView iv;
	Bitmap bm;
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnLoad = (Button) findViewById(R.id.btnLoad);
		tv = (TextView) findViewById(R.id.tv);
//		iv = (ImageView) findViewById(R.id.imageView);
		
		btnLoad.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new AsyncTask<String, Void, Void>(){

					@Override
					protected Void doInBackground(String... params) {
						try {
							URL url = new URL(params[0]);
							HttpURLConnection conn = (HttpURLConnection) url.openConnection();
							
							conn.setDoOutput(true);
							conn.setRequestMethod("POST");
							
							OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
							BufferedWriter bw = new BufferedWriter(osw);
							bw.write("");
							bw.flush();
							
							//获得响应状态并判断是否连接成功，链接成功后输出
							if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
								InputStream is = conn.getInputStream();
								InputStreamReader isr = new InputStreamReader(is,"utf-8");
								BufferedReader br = new BufferedReader(isr);
								
	//							bm = BitmapFactory.decodeStream(is);
								Message msg = new Message();
								
	//							msg.what = 1;
	//							hanler.sendMessage(msg);
								
								String line;
								String re = null;
								while ((line = br.readLine()) != null) {
									re += line;
									System.out.println(line);
								}
								Bundle bundle = new Bundle();
								bundle.putString("re", re);
								msg.setData(bundle);
								hanler.sendMessage(msg);
								br.close();
								isr.close();
								is.close();
							}
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
					}}.execute("https://openapi.baidu.com/rest/2.0/passport/users/getLoggedInUser");
			}
		});
	}
	Handler hanler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			tv.setText(msg.getData().getString("re"));
//			if(msg.what == 1)
//				iv.setImageBitmap(bm);
			super.handleMessage(msg);
		}
		
	};

	
}
