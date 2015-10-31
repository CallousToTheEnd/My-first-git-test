package lk.study.uistudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DrawableActivity extends Activity {

	LinearLayout mLinearLayout ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mLinearLayout = new LinearLayout(this) ;
		ImageView mImageView = new ImageView(this) ;
		mImageView.setImageResource(R.drawable.ic_launcher) ;
		mImageView.setAdjustViewBounds(true) ;
		mImageView.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		mLinearLayout.addView(mImageView) ;
		setContentView(mLinearLayout) ;
		
	}
	
}
