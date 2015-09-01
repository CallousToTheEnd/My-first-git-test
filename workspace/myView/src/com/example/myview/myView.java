package com.example.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class myView extends TextView {

	private final String namespace = "http://com.example.myview";
	private int resourceId = 0;
	private Bitmap bitmap ;

	@Override
	protected void onDraw(Canvas canvas) {
		if(bitmap != null){
			Rect src = new Rect();
			Rect target = new Rect();
			src.left = 0;
			src.top = 0;
			src.bottom = bitmap.getHeight();
			src.right = bitmap.getWidth();
			int textHeight = (int) getTextSize();
			target.left = 0;
			target.top = (int)((getMeasuredHeight() - getTextSize())/2)+1;
			target.bottom = target.top + textHeight;
			target.right = (int)(textHeight*(bitmap.getWidth()/(float)bitmap.getHeight()));
			canvas.drawBitmap(bitmap, src, target, getPaint());
			canvas.translate(target.right + 2, 0);
		}
		super.onDraw(canvas);
	}

	public myView(Context context, AttributeSet attrs) {
		super(context, attrs);
		resourceId = attrs.getAttributeResourceValue(namespace, "iconSrc", 0);
		if(resourceId > 0)
			bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
	}

	
}
