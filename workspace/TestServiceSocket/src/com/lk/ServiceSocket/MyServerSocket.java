package com.lk.ServiceSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class MyServerSocket {
	
	public static void main(String[] args){
		ServerSocket serverSocket;
		try {
			//�˿�Ϊ12345
			serverSocket = new ServerSocket(12345);
			//serverSocket.accept()����
			Socket socket = serverSocket.accept();
			
			System.out.println("������12345�˿�");
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
