package com.sinlord.aatmobile;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MainService extends Service {
    private static final String TAG = "MainService";
    private SocketServer socketServer;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service started.");
        socketServer = new SocketServer();
        socketServer.start();  // 启动 Socket 服务器线程
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (socketServer != null) {
            socketServer.stopServer();
        }
        Log.d(TAG, "Service destroyed.");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
