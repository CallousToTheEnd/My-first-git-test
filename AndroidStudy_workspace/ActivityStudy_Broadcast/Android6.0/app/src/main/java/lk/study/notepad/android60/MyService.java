package lk.study.notepad.android60;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Mr.li on 2015/9/4.
 *服务类
 */
public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 当Activity绑定服务和start时执行，如果绑定之后再执行startService()将不再执行此方法
     */
    @Override
    public void onCreate() {
        System.out.println("onCreate");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        System.out.println("onStart");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestory");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        System.out.println("onRebind");
        super.onRebind(intent);
    }
}
