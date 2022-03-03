package com.dhzm.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Callable;

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
     * @param port 需要监听的端口
     * @return null
     * @author Remy~
     * @date 2022/2/18 11:13
     */
    public TcpRead(Integer port) {
        this.port = port;
        socketThreads = new ArrayList<>();
    }


    //启动监听
    public Object start() {
        isFinished = false;
        try {
            //创建服务器套接字，绑定到指定的端口
            serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();//接受连接
            //等待客户端连接
            while (!isFinished) {

                //创建线程处理连接
                SocketThread socketThread = new SocketThread(socket);
                socketThreads.add(socketThread);
                return socketThread.call();
            }
        } catch (IOException e) {
            isFinished = true;
        }
        return "250";
    }

    //关闭监听
    public void stop() {
        isFinished = true;
        for (SocketThread socketThread : socketThreads) {
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
    private class SocketThread implements Callable<Object> {

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

        @Override
        public Object call() {
            String message = null;
            while (!isFinished) {
                if (in == null) {
                    return "";
                }
                try {
                    int available = in.available();
                    if (available > 0) {
                        byte[] buffer = new byte[available];
                        int size = in.read(buffer);
                        if (size > 0) {
                            message = ObjTransForm.byteTF_String(buffer);
                            String response = "我操你妈";
                            out.write(response.getBytes());
                            out.flush();
                            return "收到了来自于集中器" + socket.getInetAddress().getHostName()
                                    + "的消息：" + message.toString();
                            //返回结果给TcpClient

                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "250";
        }
    }
}
