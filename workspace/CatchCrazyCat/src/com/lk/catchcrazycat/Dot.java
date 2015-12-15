package com.lk.catchcrazycat;

/**
 * 用来存放每个点的位置和状态信息
 * 
 * @author Mr.li
 * 
 */
public class Dot {
	// 每个点的位置
	private int x, y;
	// 当前坐标点的状态
	private int status;

	/** 选中状态，不可走 */
	public static final int STATUS_ON = 1;
	/** 默认，可走状态 */
	public static final int STATUS_OFF = 0;
	/** cat处在某一点上时，这个点为这个状态 */
	public static final int STATUS_IN = 9;

	public Dot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		status = STATUS_OFF;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setXY(int x, int y) {
		this.y = y;
		this.x = x;
	}

}
