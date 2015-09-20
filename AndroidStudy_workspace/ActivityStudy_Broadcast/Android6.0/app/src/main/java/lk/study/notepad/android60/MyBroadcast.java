package lk.study.notepad.android60;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Mr.li on 2015/9/4.
 *
 */
public class MyBroadcast extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("MyBroadcast");
    }
}
