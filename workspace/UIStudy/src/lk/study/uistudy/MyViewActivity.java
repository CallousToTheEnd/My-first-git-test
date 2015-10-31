package lk.study.uistudy;

import lk.study.ui.MyVeiw;
import lk.study.ui.MyVeiw.OnDirectionListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public class MyViewActivity extends Activity {

	MyVeiw myView;
	int colorIndex = 0;
	// 每隔0.5秒变一次颜色
	private Thread myThread = new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myView.colorIndex = colorIndex++;
				if (colorIndex > 2)
					colorIndex = 0;
				myView.postInvalidate();
			}
		}
	});

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		myView = new MyVeiw(this);
		myView.setDirectionListener(new lk.study.ui.MyVeiw.OnDirectionListener() {

			@Override
			public void onKeyDown(String moveDirection) {
				System.out.println(moveDirection);
			}
		});
		setContentView(myView);

		myThread.start();
	}

	// 键盘方向键控制方向
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			myView.x += 10;
			myView.postInvalidate();
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			myView.y += 10;
			myView.postInvalidate();
			break;
		case KeyEvent.KEYCODE_DPAD_LEFT:
			myView.x -= 10;
			myView.postInvalidate();
			break;
		case KeyEvent.KEYCODE_DPAD_UP:
			myView.y -= 10;
			myView.postInvalidate();
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

}
