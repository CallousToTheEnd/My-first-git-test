package com.lk.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	RecyclerView rv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		rv = new RecyclerView(this);
		setContentView(rv);
		
		rv.setLayoutManager(new LinearLayoutManager(this));
		rv.setAdapter(new RecyclerView.Adapter<ViewHolder>() {

			Data[] data = new Data[]{new Data("详细信息","姓名，电话，住址.."), 
					new Data("详细信息","姓名，电话，住址.."),
					new Data("详细信息","姓名，电话，住址.."),
					new Data("详细信息","姓名，电话，住址.."),
					new Data("详细信息","姓名，电话，住址.."),
					new Data("详细信息","姓名，电话，住址.."),
					new Data("详细信息","姓名，电话，住址.."),
					new Data("详细信息","姓名，电话，住址.."),
					new Data("详细信息","姓名，电话，住址.."),
					new Data("详细信息","姓名，电话，住址.."),
					new Data("详细信息","姓名，电话，住址.."),
					new Data("详细信息","姓名，电话，住址.."),
					new Data("详细信息","姓名，电话，住址.."),
					new Data("语言","中文（简体）,English")};
			
			@Override
			public int getItemCount() {
				// TODO Auto-generated method stub
				return data.length;
			}

			@Override
			public void onBindViewHolder(ViewHolder arg0, int arg1) {
				myViewHolder mvh = (myViewHolder) arg0;
				Data dt = data[arg1];
				mvh.gettvTitle().setText(dt.title);
				mvh.gettvContent().setText(dt.content);
			}

			@Override
			public ViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				return new myViewHolder(LayoutInflater.from(arg0.getContext())
						.inflate(R.layout.mylist, arg0, false));
			}
		});
	}
	
	class myViewHolder extends ViewHolder{

		private TextView tvTitle;
		private TextView tvContent;
		private View root;
		
		public myViewHolder(View arg0) {
			super(arg0);
			root = arg0;
			tvTitle = (TextView) root.findViewById(R.id.tvTitle);
			tvContent = (TextView) root.findViewById(R.id.tvContent);
			
		}
		
		public TextView gettvTitle(){
			return tvTitle;
		}
		
		public TextView gettvContent(){
			return tvContent;
		}
		
	}
	
	public class Data {
		
		public String title;
		public String content;
		
		public Data(String title, String content){
			this.title = title;
			this.content = content;
		}
	}

	
}
