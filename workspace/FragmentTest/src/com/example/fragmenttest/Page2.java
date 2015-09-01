package com.example.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Page2 extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.tabs_page1, container, false);
		TextView textView = (TextView) root.findViewById(R.id.textViewp);
		textView.setText("Page2");
		return root;
	}
}
