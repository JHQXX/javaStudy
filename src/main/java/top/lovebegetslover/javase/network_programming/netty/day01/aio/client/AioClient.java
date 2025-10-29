package top.lovebegetslover.javase.network_programming.netty.day01.aio.client;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.Future;

/**
 * 客户端
 * @Author: Lee
 * @Description: AIO 测试
 * @DateTime: 2025/10/28 上午11:08
 **/
public class AioClient {
    public static void main(String[] args) throws Exception {
        //创建
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        //连接地址 端口
        Future<Void> future = socketChannel.connect(new InetSocketAddress("192.168.137.1", 4399));
        System.out.println("启动连接");
        future.get();
        socketChannel.read(ByteBuffer.allocate(1024),null ,new AioClientHandler(socketChannel, Charset.forName("GBK")));
        Thread.sleep(100000);
    }

}
