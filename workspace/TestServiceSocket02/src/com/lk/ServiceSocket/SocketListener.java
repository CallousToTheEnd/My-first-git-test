package com.lk.ServiceSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener extends Thread {

	@Override
	public void run() {
		try {
			//����һ�������
			ServerSocket serverSocket = new ServerSocket(12345);
			while(true){
				Socket socket = serverSocket.accept();			//����������̣߳�ֱ���пͻ������ӵ�����˲�ִ����������
				System.out.println("������12345�ӿ�");
				Check cs = new Check(socket);		//�����µ��̲߳���Socket���룬������߳���ӽ�CheckManeger��
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
