package com.lk.ServiceSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener extends Thread {

	@Override
	public void run() {
		try {
			//建立一个服务端
			ServerSocket serverSocket = new ServerSocket(12345);
			while(true){
				Socket socket = serverSocket.accept();			//这里会阻塞线程，直到有客户端链接到服务端才执行下面的语句
				System.out.println("调用了12345接口");
				Check cs = new Check(socket);		//创建新的线程并将Socket传入，把这个线程添加进CheckManeger中
				cs.start();
				CheckManager.getcheck().addCheck(cs);		
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
}
