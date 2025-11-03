package top.lovebegetslover.javase.network_programming.netty.day01.bio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 服务端 同步阻塞
 */
public class BioServer extends  Thread{

    private ServerSocketChannel serverChannel =null;

    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
        //由于继承了Thread 有start 方法
        bioServer.start();
    }

    //实际启动的方法
    @Override
    public void run() {
        try {
//            serverSocket=new ServerSocket();
//            serverSocket.bind(new InetSocketAddress(4399));
            serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(4399));
            //这里为啥要用socket 而不是 socketChannel 是因为 socket 是 阻塞的 而 socketChannel 是非阻塞的 混用aip bio是同步阻塞
            serverChannel.configureBlocking(true);//BIO模式

            System.out.println("BIO Server 服务端正在运行 监控端口为 4399");
            //创建监听循环
            while (true){
                //拿取消息
                SocketChannel socketChannel = serverChannel.accept();
                //服务器处理器  -- 用于服务器处理事务
                BioServerHandler handler = new BioServerHandler(socketChannel, StandardCharsets.UTF_8);
                handler.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
