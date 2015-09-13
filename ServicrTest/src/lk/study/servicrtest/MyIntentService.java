package lk.study.servicrtest;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * 这个服务会自动执行完它的生命周期，不用用stopService()方法
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

	//另开一个线程执行里面的代码，执行完毕后自动关闭Service，即调用Destroy方法
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
