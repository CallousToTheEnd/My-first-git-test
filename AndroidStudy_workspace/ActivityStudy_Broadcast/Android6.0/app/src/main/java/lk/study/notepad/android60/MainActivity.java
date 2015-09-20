package lk.study.notepad.android60;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent serviceIntent ;
    Intent broadcastIntent = new Intent("lk.study.notepad.android60");
    ServiceConnection conn;
    EditText et1;

    @Override
    protected void onStop() {
        System.out.println("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        System.out.println("onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        System.out.println("onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        System.out.println("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        System.out.println("onPause");
        super.onPause();
    }

    /**
     * onPause之后执行
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        下面所说情况是在Activity进程终止后再开始的情况
//          系统自动保存的当前Activity的状态，会在onRestoreInstanceState中优先恢复，虽然在onCreate中
//        恢复了保存的内容，但是onRestoreInstanceState方法在onCreate之后之后执行，所以onRestoreInstanceState中
//        的恢复覆盖掉了onCreate方法中的恢复，导致自定义保存的内容没有显示出来，所以屏蔽此句，在
//        onRestoreInstanceState中的 super.onRestoreInstanceState(savedInstanceState)就没有任何内容，而不会覆盖onCreate中
//
//        显示自定义保存的内容
//        super.onSaveInstanceState(outState);
        System.out.println("onSaveInstanceState");
        outState.putString("name", "Mr.li");
    }

    //onStart之后执行
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        下面所说情况是在Activity进程终止后再开始的情况
        //这里优先恢复的是在onSaveInstanceState中系统保存的Bundle而不是自定义保存的内容
        //自定义保存的内容建议在onCreate中恢复，因为有时onRestoreInstanceState可能不会执行
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("onRestoreInstanceStat");
    }

    //当Activity配置改变时调用。比如：横竖屏切换，等等，
    // 具体是哪个设置改变要在Manifest的Activity标签中设置android:configChanges属性
    //横竖屏android:configChanges="orientation|screenSize"，两个都要有，否则无效
//    还要设置权限ANDROID.PERMISSION.CHANGE_CONFIGURATION
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        System.out.println("onConfigurationChanged");
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            System.out.println("Change to 横屏");
        }else
            System.out.println("Change to 竖屏");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("onCreate");
        et1 = (EditText) findViewById(R.id.et1);

        //显示保存的内容
        if (savedInstanceState != null) {
            et1.setText(savedInstanceState.getString("name"));
        }

        serviceIntent = new Intent(this, MyService.class);
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Toast.makeText(MainActivity.this, "bindSuccess", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Toast.makeText(MainActivity.this, "bindFailed", Toast.LENGTH_SHORT).show();
            }
        };

        //发送广播
        findViewById(R.id.btnSendBroadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(broadcastIntent);
            }
        });
        //绑定
        findViewById(R.id.btnBindService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(serviceIntent, conn, Context.BIND_AUTO_CREATE);
            }
        });
        //解除绑定
        findViewById(R.id.btnUnbindService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });
        //开始服务
        findViewById(R.id.btnStartService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(serviceIntent);
            }
        });
        //结束服务
        findViewById(R.id.btnStopService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(serviceIntent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
