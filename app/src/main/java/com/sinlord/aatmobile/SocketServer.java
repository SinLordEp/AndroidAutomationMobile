package com.sinlord.aatmobile;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Thread {
    private static final String TAG = "SocketServer";
    private static final int PORT = 8888;  // 监听端口
    private boolean running = true;

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            Log.d(TAG, "Socket server started on port " + PORT);

            while (running) {
                Socket clientSocket = serverSocket.accept();
                Log.d(TAG, "Client connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String command = in.readLine();  // 读取桌面端发送的指令
                Log.d(TAG, "Received command: " + command);

                String result = CommandHandler.handleCommand(command);  // 处理指令并获取结果
                out.println(result);  // 返回结果给桌面端

                clientSocket.close();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in socket server", e);
        }
    }

    public void stopServer() {
        running = false;
        Log.d(TAG, "Socket server stopped.");
    }
}
