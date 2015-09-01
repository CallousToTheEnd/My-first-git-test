package com.lk.ServiceSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class MyServerSocket {
	
	public static void main(String[] args){
		//启动一个新的线程
		new SocketListener().start();
	}
}
