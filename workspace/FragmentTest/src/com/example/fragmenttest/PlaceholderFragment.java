package com.example.fragmenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class PlaceholderFragment extends Fragment{
	
	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		rootView.findViewById(R.id.btnStartAnotherFragment).setOnClickListener(
				new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						getFragmentManager().beginTransaction()
						.addToBackStack(null)
						.replace(R.id.container, new AnotherFragment())
						.commit();
					}
				});
		rootView.findViewById(R.id.btnStartSliderFragment).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(), SliderContentActivity.class));
			}
		});
		rootView.findViewById(R.id.btnStartTabFragment).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(), TabActivity.class));
			}
		});
		return rootView;
	}
	
}
