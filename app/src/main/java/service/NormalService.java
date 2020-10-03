package service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class NormalService extends Service {

    int mStartMode;
    boolean mAllowRebind;

    String msg = "";

    public class MyBinder extends Binder {

        public NormalService getService() {
            return NormalService.this;
        }
    }

    private MyBinder binder = new MyBinder();

    /**
     * 当服务被创建时调用.
     */
    @Override
    public void onCreate() {
        Log.d("service", "onCreate");
        msg = "onCreate-->";
    }

    /**
     * 调用startService()启动服务时回调
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service", "onStartCommand");
        msg = "onStartCommand-->";

        return mStartMode;
    }

    /**
     * 通过bindService()绑定到服务的客户端
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("service", "onBind");
        msg = "onBind-->";
        return binder;
    }

    /**
     * 通过unbindService()解除所有客户端绑定时调用
     */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("service", "onUnbind");
        msg = "onUnbind-->";
        return mAllowRebind;
    }

    /**
     * 通过bindService()将客户端绑定到服务时调用
     */
    @Override
    public void onRebind(Intent intent) {
        Log.d("service", "onRebind");
        msg = "onRebind-->";
    }

    /**
     * 服务不再有用且将要被销毁时调用
     */
    @Override
    public void onDestroy() {
        Log.d("service", "onDestroy");
        msg = "onDestroy-->";
    }

    public String getMsg() {
        return msg;
    }

}
