package top.lovebegetslover.javase.network_programming.netty.day01.bio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * 客户端
 */
public class BioClient {
    public static void main(String[] args) {
        try {
            //方法一
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("192.168.1.116", 4399));
            //方法二
            //创建信息
//            Socket socket = new Socket("192.168.1.116", 4399);
            System.out.println("bio_client start done | 正在启动");
            BioClientHandler bioClientHandler = new BioClientHandler(socketChannel, Charset.forName("utf-8"));
            //启动
            bioClientHandler.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
