package com.lk.httpclientgettest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText et;
	TextView tvContent;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et = (EditText) findViewById(R.id.etOne);
		tvContent = (TextView) findViewById(R.id.tvContent);
		findViewById(R.id.btnLoad).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String loadUrl = "http://www.baidu.com/s";
				loadUrl(loadUrl , et.getText().toString());
			}
		});
		
	}
	
	public void loadUrl(String loadUrl, String getText){
		
		new AsyncTask<String, Void, String>(){

			@Override
			protected String doInBackground(String... params) {
				
				HttpPost httpPost = new HttpPost(params[0]);
				try {
					List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
					list.add(new BasicNameValuePair("wd",params[1]));
					httpPost.setEntity(new UrlEncodedFormEntity(list));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpPost);
					if(httpResponse.getStatusLine().getStatusCode() == 200){
						String value = EntityUtils.toString(httpResponse.getEntity());
						return value;
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				return null;
			}

			@Override
			protected void onPostExecute(String result) {
				tvContent.setText(result);
			}
			
		}.execute(loadUrl, getText);
	}

	
}
