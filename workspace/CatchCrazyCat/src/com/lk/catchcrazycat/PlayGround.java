package com.lk.catchcrazycat;

import java.util.HashMap;
import java.util.Vector;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

/**
 * ��Ϸ�����࣬�̳���SurfaceView
 * 
 * @author Mr.li
 * 
 */
public class PlayGround extends SurfaceView implements OnTouchListener {

	private static int WIGHT = 40; // Ԫ�ؿ��
	private static final int ROW = 10; // Ĭ������
	private static final int COL = 10; // Ĭ������
	private static final int BLOCKS = 10; // Ĭ����ӵ�·������
	// boolean justInit;

	private Dot matrix[][]; // ���ÿ����
	private Dot cat;

	public PlayGround(Context context) {
		super(context);
		getHolder().addCallback(callback);
		matrix = new Dot[ROW][COL];
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				// ����ÿ���������������Ԫ���±��ƽʱ��˵��λ�����෴��
				// �����е����Ǵ�ֱ���������x���Ǻ����
				// ����(5��4)������������е��±����[5][6]
				matrix[i][j] = new Dot(j, i);
			}
		}
		setOnTouchListener(this);
		initGame();
	}

	/** ��λ�ô��룬���ظ�λ�õĵ㡣 ����ÿ���������������Ԫ���±��ƽʱ��˵��λ�����෴�ģ�Ϊ�˷��� */
	private Dot getDot(int x, int y) {
		return matrix[y][x];
	}

	/**
	 * �жϴ���ĵ��Ƿ��ڱ�Ե��
	 * 
	 * @param d
	 *            Ҫ�жϵĵ�
	 * @return �ڱ�Ե�Ϸ���true�����ڣ���֮
	 */
	private boolean isAtEdge(Dot d) {
		if (d.getX() * d.getY() == 0 || d.getX() + 1 == COL
				|| d.getY() + 1 == ROW) {
			return true;
		}
		return false;
	}

	/**
	 * ÿ������Χ��6���㣬����cat����ŷ������������ĵ�
	 * 
	 * @param one
	 *            cat��������ĵ�
	 * @param dir
	 *            cat��Χ�����ţ�����߿�ʼ˳ʱ��ֱ�Ϊ1-6��
	 * @return ������ŷ��ص�
	 */
	private Dot getNrighbour(Dot one, int dir) {
		switch (dir) {
		case 1:
			return getDot(one.getX() - 1, one.getY());
		case 2:
			if (one.getY() % 2 == 0) {
				return getDot(one.getX() - 1, one.getY() - 1);
			} else {
				return getDot(one.getX(), one.getY() - 1);
			}
		case 3:
			if (one.getY() % 2 == 0) {
				return getDot(one.getX(), one.getY() - 1);
			} else {
				return getDot(one.getX() + 1, one.getY() - 1);
			}
		case 4:
			return getDot(one.getX() + 1, one.getY());
		case 5:
			if (one.getY() % 2 == 0) {
				return getDot(one.getX(), one.getY() + 1);
			} else {
				return getDot(one.getX() + 1, one.getY() + 1);
			}
		case 6:
			if (one.getY() % 2 == 0) {
				return getDot(one.getX() - 1, one.getY() + 1);
			} else {
				return getDot(one.getX(), one.getY() + 1);
			}
		}
		return null;
	}

	/**
	 * ����ĳһ�������ͷ��򷵻ظ÷���ľ���
	 * 
	 * @param one
	 *            cat��������ĵ�
	 * @param dir
	 *            cat��Χ�����ţ�����߿�ʼ˳ʱ��ֱ�Ϊ1-6��
	 * @return ����ĳһ�����Ͽ��ߵľ��룬�����ϰ����ؾ���ĸ�ֵ��������Ե������ֵ��
	 */
	private int getDistance(Dot one, int dir) {
		int distance = 0;
		if (isAtEdge(one)) {
			return 1;
		}
		Dot ori = one, next;
		while (true) {
			next = getNrighbour(ori, dir);
			if (next.getStatus() == Dot.STATUS_ON) {
				return distance * -1;
			}
			if (isAtEdge(next)) {
				distance++;
				return distance;
			}
			distance++;
			ori = next;
		}
	}

	/**
	 * �ƶ���ĳһ��
	 * 
	 * @param one
	 *            Ҫ�ƶ�����λ��
	 */
	private void moveTo(Dot one) {
		one.setStatus(Dot.STATUS_IN);
		getDot(cat.getX(), cat.getY()).setStatus(Dot.STATUS_OFF);
		cat.setXY(one.getX(), one.getY());
	}

	/**
	 * è���ƶ�
	 */
	private void move() {
		if (isAtEdge(cat)) {
			lose();
			// һ��Ҫ���return����������ִ��������ƶ��Ĵ��룬��Ϊ�Ѿ��ڱ�Ե�����Ի�����±곬����Χ
			return;
		}
		Vector<Dot> avaliable = new Vector<>(); // ���ߵĵ�
		Vector<Dot> positive = new Vector<>(); // ���Ե�����Ļ��Ե�ĵ�
		HashMap<Dot, Integer> al = new HashMap<Dot, Integer>(); // ��ķ���
		// ���cat��Χ�п��ߵĵ㣬�����ߵĵ�������飬����ķ���������飬������鳤��Ϊ0˵��û�п��ߵĵ�
		for (int i = 1; i < 7; i++) {
			Dot n = getNrighbour(cat, i);
			if (n.getStatus() == Dot.STATUS_OFF) {
				avaliable.add(n);
				al.put(n, i);
				if (getDistance(n, i) > 0) {
					positive.add(n);
				}
			}
		}
		if (avaliable.size() == 0) {
			win();
		} else if (avaliable.size() == 1) {
			moveTo(avaliable.get(0));
			// }else if(justInit){ //��һ���ƶ�ʱ��������ƶ�
			// int s = (int) ((Math.random()*1000)%avaliable.size());
			// moveTo(avaliable.get(s));
			// justInit = false;
		} else {
			Dot best = null;
			if (positive.size() != 0) { // ���ڿ��Ե�����Ļ��Ե������
				int min = 999;
				for (int i = 0; i < positive.size(); i++) {
					int a = getDistance(positive.get(i),
							al.get(positive.get(i)));
					if (a < min) {
						min = a;
						best = positive.get(i);
					}
				}
			} else { // �����ڿ��Ե�����Ļ��Ե������
				int max = 0;
				for (int i = 0; i < avaliable.size(); i++) {
					int k = getDistance(avaliable.get(i),
							al.get(avaliable.get(i)));
					if (k < max) {
						max = k;
						best = avaliable.get(i);
					}
				}
			}
			moveTo(best);
		}

	}

	/**
	 * ��Ϸʤ��
	 */
	private void win() {
		new AlertDialog.Builder(getContext()).setMessage("You Win!")
				.setNegativeButton("Again", new AlertDialog.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						initGame();
					}
				}).create().show();
	}

	/**
	 * ��Ϸʧ��
	 */
	private void lose() {
		new AlertDialog.Builder(getContext()).setMessage("You Lose!")
				.setNegativeButton("Again", new AlertDialog.OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int which) {
						initGame();
						redraw();
					}
					
				}).create().show();
	}

	/** �����Ļ��� */
	@SuppressLint("NewApi")
	private void redraw() {
		Canvas canvas = getHolder().lockCanvas();
		canvas.drawColor(Color.LTGRAY);
		// ����ÿ���㲢������ɫ
		Paint paint = new Paint();
		paint.setFlags(Paint.ANTI_ALIAS_FLAG);
		for (int i = 0; i < ROW; i++) {
			int offset = 0; // ƫ������������Ϊ������ʱƫ�ư��Բ�ľ���
			if (i % 2 != 0) {
				offset = WIGHT / 2;
			}
			for (int j = 0; j < COL; j++) {
				Dot one = getDot(j, i);
				switch (one.getStatus()) {
				case Dot.STATUS_OFF:
					paint.setColor(0xFFEEEEEE);
					break;
				case Dot.STATUS_ON:
					paint.setColor(0xFFFFAA00);
					break;
				case Dot.STATUS_IN:
					paint.setColor(0xFFFF0000);
					break;
				}
				canvas.drawOval(one.getX() * WIGHT + offset,
						one.getY() * WIGHT, (one.getX() + 1) * WIGHT + offset,
						(one.getY() + 1) * WIGHT, paint);
			}

		}
		getHolder().unlockCanvasAndPost(canvas);
	}

	Callback2 callback = new Callback2() {

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {

		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			redraw();
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			// ���SurfaceView��ȫ���ģ���������Ļ�Ŀ�ȳ��� ��������ÿ����Ŀ�ȣ��������1���һ�л���ʾ��ȫ
			WIGHT = width / (COL + 1);
			redraw();
		}

		@Override
		public void surfaceRedrawNeeded(SurfaceHolder holder) {

		}
	};

	/** ��ʼ����Ϸ ������Ϸ״̬��catĬ�ϵ�λ�� */
	private void initGame() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				matrix[i][j].setStatus(Dot.STATUS_OFF);
			}
		}
		cat = new Dot(5, 4);
		getDot(5, 4).setStatus(Dot.STATUS_IN);
		// ������ó�ʼ·��
		for (int i = 0; i < BLOCKS;) {
			int x = (int) ((Math.random() * 1000) % ROW);
			int y = (int) ((Math.random() * 1000) % COL);
			// Ϊ�˱����ظ�
			if (getDot(x, y).getStatus() == Dot.STATUS_OFF) {
				getDot(x, y).setStatus(Dot.STATUS_ON);
				i++;
			}
		}
		// justInit = true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_UP) {
			int x = 11, y; // ÿ�����λ�ã���������Ԫ���±�,y������ǵڼ��У�x�ǵڼ���
			y = (int) (event.getY() / WIGHT);
			if (y % 2 == 0) { // û��ƫ�Ƶ���
				x = (int) (event.getX() / WIGHT);
			} else { // ƫ���еļ��㣬��x�����ȥ���Բ�İ뾶,С��0˵���������ƫ���е���߿հ�λ��
				if (event.getX() - WIGHT / 2 < 0) {
					initGame();
				} else {
					x = (int) ((event.getX() - WIGHT / 2) / WIGHT);
				}
			}
			// �ж��Ƿ񳬳������Χ
			if (x + 1 > COL || y + 1 > ROW) {
				initGame();
			} else {
				if (getDot(x, y).getStatus() == Dot.STATUS_OFF) {
					getDot(x, y).setStatus(Dot.STATUS_ON);
					move();
				}
			}
			redraw();
		}
		return true;
	}

}
