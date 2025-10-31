package top.lovebegetslover.javase.network_programming.netty.day01.nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * NIO 客户端
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/10/31 上午10:16
 **/
public class NioClient {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);//阻塞模式

        boolean isConnect = socketChannel.connect(new InetSocketAddress("192.168.1.116", 4399));
        if (isConnect){
            //注册的意思
            socketChannel.register(selector, SelectionKey.OP_READ);
        }else {
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
        }
        System.out.println("nio client start done...");
        new NioClientHandler(selector, Charset.forName("GBK")).start();



    }
}
