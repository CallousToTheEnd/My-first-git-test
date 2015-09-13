package lk.study.servicrtest;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * ���������Զ�ִ���������������ڣ�������stopService()����
 * @author Mr.li
 *
 */
public class MyIntentService extends IntentService {
	
	IBinder myBinder = new MyBinder();

	public MyIntentService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public MyIntentService() {
		super("myIntentService");
		// TODO Auto-generated constructor stub
	}

	//��һ���߳�ִ������Ĵ��룬ִ����Ϻ��Զ��ر�Service��������Destroy����
	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("onStartCommand");
		helloWorld();
	}

	@Override
	public void onCreate() {
		System.out.println("onCreate");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("onBind");
		return myBinder;
	}
	
	public void helloWorld(){
		for(int i=1; i<10; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("i=" + i) ;
		}
	}
	
	class MyBinder extends Binder{
		public MyIntentService getService(){
			return MyIntentService.this;
		}
	}

}
