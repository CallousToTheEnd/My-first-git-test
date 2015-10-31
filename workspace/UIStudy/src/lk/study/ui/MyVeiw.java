package lk.study.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class MyVeiw extends View {

	public int x = 0;
	public int y = 0;
	public int colorIndex = 0;
	OnDirectionListener mOnDirectionListener;

	public MyVeiw(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		Paint paint = new Paint();
		switch (colorIndex) {
		case 0:
			paint.setColor(Color.YELLOW);
			break;
		case 1:
			paint.setColor(Color.GREEN);
			break;
		case 2:
			paint.setColor(Color.BLUE);

			break;
		}
		Rect rect = new Rect(x, y, x + 30, y + 30);
		canvas.drawRect(rect, paint);
		super.onDraw(canvas);
	}

	public interface OnDirectionListener {
		public void onKeyDown(String moveDirection);
	}

	public void setDirectionListener(OnDirectionListener onDirectionListener) {
		mOnDirectionListener = onDirectionListener;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (mOnDirectionListener != null) {
			if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
				mOnDirectionListener.onKeyDown("向下");
			}
			if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
				mOnDirectionListener.onKeyDown("向左");
			}
			if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
				mOnDirectionListener.onKeyDown("向右");
			}
			if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
				mOnDirectionListener.onKeyDown("向上");
			}
		}
		return super.onKeyDown(keyCode, event);
	}

}
