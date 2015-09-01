package com.lk.ServiceSocket;

import java.util.Vector;


/*
 * ��Check�߳�����й���
 */
public class CheckManager {

	private CheckManager(){}
	private static CheckManager cm = new CheckManager();
	public static CheckManager getcheck(){
		return cm;
	}
	
	//����������Check���з�װ
	Vector<Check> vector = new Vector<Check>();
	
	public void addCheck(Check cs){
		vector.add(cs);
	}
	
	public void publish(Check cs, String out){
		for (int i = 0; i < vector.size(); i++) {
			Check csCheck = vector.get(i);
			if(!cs.equals(csCheck)){
				csCheck.out(out);
			}
		}
	}

}
	
