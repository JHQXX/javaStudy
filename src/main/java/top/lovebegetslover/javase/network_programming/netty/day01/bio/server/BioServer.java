package top.lovebegetslover.javase.network_programming.netty.day01.bio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 服务端
 */
public class BioServer extends  Thread{

    private ServerSocket serverSocket =null;

    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
        //由于继承了Thread 有start 方法
        bioServer.start();
    }

    //实际启动的方法
    @Override
    public void run() {
        try {
            serverSocket=new ServerSocket();
            serverSocket.bind(new InetSocketAddress(4399));
            System.out.println("BIO Server 服务端正在运行 监控端口为 4399");
            //创建监听循环
            while (true){
                //拿取消息
                Socket socket = serverSocket.accept();
                //服务器处理器  -- 用于服务器处理事务
                BioServerHandler handler = new BioServerHandler(socket.getChannel(), Charset.forName("utf-8"));
                handler.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
