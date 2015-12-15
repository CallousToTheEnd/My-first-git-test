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
 * 游戏界面类，继承自SurfaceView
 * 
 * @author Mr.li
 * 
 */
public class PlayGround extends SurfaceView implements OnTouchListener {

	private static int WIGHT = 40; // 元素宽度
	private static final int ROW = 10; // 默认行数
	private static final int COL = 10; // 默认列数
	private static final int BLOCKS = 10; // 默认添加的路障数量
	// boolean justInit;

	private Dot matrix[][]; // 存放每个点
	private Dot cat;

	public PlayGround(Context context) {
		super(context);
		getHolder().addCallback(callback);
		matrix = new Dot[ROW][COL];
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				// 由于每个点所代表的数组元素下标和平时所说的位置是相反的
				// 数组中的行是垂直，而坐标的x轴是横向的
				// 比如(5，4)这个点在数组中的下标就是[5][6]
				matrix[i][j] = new Dot(j, i);
			}
		}
		setOnTouchListener(this);
		initGame();
	}

	/** 将位置传入，返回该位置的点。 由于每个点所代表的数组元素下标和平时所说的位置是相反的，为了方便 */
	private Dot getDot(int x, int y) {
		return matrix[y][x];
	}

	/**
	 * 判断传入的点是否在边缘上
	 * 
	 * @param d
	 *            要判断的点
	 * @return 在边缘上返回true，不在，反之
	 */
	private boolean isAtEdge(Dot d) {
		if (d.getX() * d.getY() == 0 || d.getX() + 1 == COL
				|| d.getY() + 1 == ROW) {
			return true;
		}
		return false;
	}

	/**
	 * 每个点周围有6个点，根据cat和序号返回序号所代表的点
	 * 
	 * @param one
	 *            cat的所代表的点
	 * @param dir
	 *            cat周围点的序号，从左边开始顺时针分别为1-6号
	 * @return 根据序号返回点
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
	 * 根据某一点的坐标和方向返回该方向的距离
	 * 
	 * @param one
	 *            cat的所代表的点
	 * @param dir
	 *            cat周围点的序号，从左边开始顺时针分别为1-6号
	 * @return 返回某一方向上可走的距离，遇到障碍返回距离的负值，遇到边缘返回正值，
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
	 * 移动到某一点
	 * 
	 * @param one
	 *            要移动到的位置
	 */
	private void moveTo(Dot one) {
		one.setStatus(Dot.STATUS_IN);
		getDot(cat.getX(), cat.getY()).setStatus(Dot.STATUS_OFF);
		cat.setXY(one.getX(), one.getY());
	}

	/**
	 * 猫的移动
	 */
	private void move() {
		if (isAtEdge(cat)) {
			lose();
			// 一定要添加return，否则会继续执行下面的移动的代码，因为已经在边缘了所以会造成下标超出范围
			return;
		}
		Vector<Dot> avaliable = new Vector<>(); // 可走的点
		Vector<Dot> positive = new Vector<>(); // 可以到达屏幕边缘的店
		HashMap<Dot, Integer> al = new HashMap<Dot, Integer>(); // 点的方向
		// 如果cat周围有可走的点，将可走的点存入数组，将点的方向存入数组，如果数组长度为0说明没有可走的点
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
			// }else if(justInit){ //第一次移动时随机方向移动
			// int s = (int) ((Math.random()*1000)%avaliable.size());
			// moveTo(avaliable.get(s));
			// justInit = false;
		} else {
			Dot best = null;
			if (positive.size() != 0) { // 存在可以到达屏幕边缘的走向
				int min = 999;
				for (int i = 0; i < positive.size(); i++) {
					int a = getDistance(positive.get(i),
							al.get(positive.get(i)));
					if (a < min) {
						min = a;
						best = positive.get(i);
					}
				}
			} else { // 不存在可以到达屏幕边缘的走向
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
	 * 游戏胜利
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
	 * 游戏失败
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

	/** 背景的绘制 */
	@SuppressLint("NewApi")
	private void redraw() {
		Canvas canvas = getHolder().lockCanvas();
		canvas.drawColor(Color.LTGRAY);
		// 绘制每个点并设置颜色
		Paint paint = new Paint();
		paint.setFlags(Paint.ANTI_ALIAS_FLAG);
		for (int i = 0; i < ROW; i++) {
			int offset = 0; // 偏移量，当行数为奇数行时偏移半个圆的距离
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
			// 这个SurfaceView是全屏的，所以用屏幕的宽度除以 列数就是每个点的宽度，如果不加1最后一列会显示不全
			WIGHT = width / (COL + 1);
			redraw();
		}

		@Override
		public void surfaceRedrawNeeded(SurfaceHolder holder) {

		}
	};

	/** 初始化游戏 包括游戏状态，cat默认的位置 */
	private void initGame() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				matrix[i][j].setStatus(Dot.STATUS_OFF);
			}
		}
		cat = new Dot(5, 4);
		getDot(5, 4).setStatus(Dot.STATUS_IN);
		// 随机设置初始路障
		for (int i = 0; i < BLOCKS;) {
			int x = (int) ((Math.random() * 1000) % ROW);
			int y = (int) ((Math.random() * 1000) % COL);
			// 为了避免重复
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
			int x = 11, y; // 每个点的位置，不是数组元素下标,y代表的是第几行，x是第几个
			y = (int) (event.getY() / WIGHT);
			if (y % 2 == 0) { // 没有偏移的行
				x = (int) (event.getX() / WIGHT);
			} else { // 偏移行的计算，把x坐标减去半个圆的半径,小于0说明点击的是偏移行的左边空白位置
				if (event.getX() - WIGHT / 2 < 0) {
					initGame();
				} else {
					x = (int) ((event.getX() - WIGHT / 2) / WIGHT);
				}
			}
			// 判断是否超出点击范围
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
