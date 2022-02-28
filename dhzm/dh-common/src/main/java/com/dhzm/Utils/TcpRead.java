package com.dhzm.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Remy~
 * @date 来自:2022年02月17日 14:32
 */
public class TcpRead {
    private int port;
    private boolean isFinished;
    private ServerSocket serverSocket;
    private ArrayList<SocketThread> socketThreads;
    private ObjTransForm objTransForm = new ObjTransForm();

    /**
     *
     * @author Remy~
     * @date 2022/2/18 11:13
     * @param  port 需要监听的端口
     * @return  null
     */
    public TcpRead(Integer port){
        this.port = port;

    }
    //启动监听
    public void start() {
        isFinished = false;
        try {
            //创建服务器套接字，绑定到指定的端口
            serverSocket = new ServerSocket(port);
            //等待客户端连接
            while (!isFinished) {
                Socket socket = serverSocket.accept();//接受连接
                //创建线程处理连接
                SocketThread socketThread = new SocketThread(socket);
                socketThreads.add(socketThread);
                socketThread.start();
            }
        } catch (IOException e) {
            isFinished = true;
        }
    }

    //关闭监听
    public void stop() {
        isFinished = true;
        for (SocketThread socketThread : socketThreads) {
            socketThread.interrupt();
            socketThread.close();
        }
        try {
            if (serverSocket != null) {
                serverSocket.close();
                serverSocket = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //启动监听的线程
    private class SocketThread extends Thread {

        private Socket socket;
        private InputStream in;
        private OutputStream out;

        SocketThread(Socket socket) {
            this.socket = socket;
            try {
                in = socket.getInputStream();
                out = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void run() {
            while (!isInterrupted()) {
                if (in == null) {
                    return;
                }
                try {
                    int available = in.available();
                    if (available > 0) {
                        byte[] buffer = new byte[available];
                        int size = in.read(buffer);
                        if (size > 0) {
                            String message = ObjTransForm.byteTF_String(buffer);
                            System.out.println("收到了来自于集中器"+socket.getInetAddress().getHostName()
                                    +"的消息："+ message.toString());
                            //返回结果给TcpClient
                            String response = "我操你妈";
                            out.write(response.getBytes());
                            out.flush();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        public void close() {

            try {
                if (in != null) {
                    in.close();
                }

                if (out != null) {
                    out.close();
                }

                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }






}
