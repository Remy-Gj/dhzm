package com.dhzm.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author Remy~
 * @date 来自:2022年02月17日 14:31
 */
public class TcpSend {
    private String ip;
    private Integer port;
    private String command;
    //创建socket流
    private Socket mSocket;
    //socket流的地址(ip,port)
    private SocketAddress mSocketAddress;
    private OutputStream mOutputStream;
    private InputStream mInputStream;
    //调用转换工具类
    ObjTransForm objTransForm = new ObjTransForm();

    /**
     * @param ip      集中器接收ip
     * @param port    集中器接收端口
     * @param command 集中器接收命令
     * @author Remy~
     * @date 2022/2/17 14:36
     */
    public TcpSend(String ip, Integer port, String command) {
        this.ip = ip;
        this.port = port;
        this.command = command;
    }

    public boolean connect() {

        try {
            this.mSocket = new Socket();
            this.mSocketAddress = new InetSocketAddress(ip, port);
            this.mSocket.connect( mSocketAddress, 3000);// 设置连接超时时间为3秒
            this.mOutputStream = mSocket.getOutputStream();
            this.mInputStream = mSocket.getInputStream();
                //十六进制字符串转Byte数组 -
                byte[] bytes = objTransForm.stringTF_Byte(command);
                send(bytes);
                return true;
        } catch (Exception e) {
            System.err.println("未接收到集中器的反馈....请检查链接" + e.getMessage());
            close();
            return false;
        }
    }
    public void send(byte[] bOutArray) {
        try {
            this.mOutputStream.write(bOutArray);
            close();
        } catch (IOException e) {
            System.err.println("发送失败....请检查链接" + e.getMessage());
            close();
        }
    }

    public void close() {
        if (this.mSocket != null) {
            try {
                this.mSocket.close();
                this.mSocket = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
