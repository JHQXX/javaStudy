package top.lovebegetslover.javase.network_programming.netty.day01.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;

/**
 * NIO 服务端
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/10/31 上午11:19
 **/
public class NioServer {

    private Selector selector;

    private ServerSocketChannel socketChannel;

    public static void main(String[] args) {
        new NioServer().bind(4399);
    }

    public void bind(int port){
        try {
            selector=Selector.open();
            socketChannel=ServerSocketChannel.open();
            socketChannel.configureBlocking(false);//非阻塞
            socketChannel.socket().bind(new InetSocketAddress(port),1024);
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("nio server start done");
            new NioServerHandler(selector, Charset.forName("GBK")).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
