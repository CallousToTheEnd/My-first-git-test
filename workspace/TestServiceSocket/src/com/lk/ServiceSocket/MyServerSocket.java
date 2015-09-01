package com.lk.ServiceSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class MyServerSocket {
	
	public static void main(String[] args){
		ServerSocket serverSocket;
		try {
			//端口为12345
			serverSocket = new ServerSocket(12345);
			//serverSocket.accept()阻塞
			Socket socket = serverSocket.accept();
			
			System.out.println("调用了12345端口");
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
