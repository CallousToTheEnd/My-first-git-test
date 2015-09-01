package com.lk.httpclientget;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.os.AsyncTaskCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tvResult;
	EditText et;
	Button btnClientGet;
//	HttpClient client;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvResult = (TextView) findViewById(R.id.textView);
		et = (EditText) findViewById(R.id.editText);
		btnClientGet = (Button) findViewById(R.id.btnClientGet);
//		client = new DefaultHttpClient();
		
		btnClientGet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String url = "http://www.baidu.com";
				//为url添加请求参数
				HttpClientGet(url + "/s?wd=" + et.getText());
			}
		});
		
	}
	
	public void HttpClientGet (String url){
		
		new AsyncTask<String, Void, String>(){

			@Override
			protected void onPostExecute(String result) {
				tvResult.setText(result);
			}

			@Override
			protected String doInBackground(String... params) {
//				String urlString = params[0];
				//第一步，以url创建HttpGet
				HttpGet httpGet = new HttpGet(params[0]);
				
				//第二步，建立链接
				try {
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpGet);
					if(httpResponse.getStatusLine().getStatusCode() == 200){
						String tvresult = EntityUtils.toString(httpResponse.getEntity());
						return tvresult;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				
				return null;
			}
			
		}.execute(url);
	}

	
}
