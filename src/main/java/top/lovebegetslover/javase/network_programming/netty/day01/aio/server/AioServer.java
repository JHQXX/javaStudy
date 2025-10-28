package top.lovebegetslover.javase.network_programming.netty.day01.aio.server;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * AIO 测试
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/10/28 上午11:09
 **/
public class AioServer extends Thread{

    private AsynchronousServerSocketChannel serverSocketChannel;

    @Override
    public void run() {
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open(AsynchronousChannelGroup.withCachedThreadPool(Executors.newCachedThreadPool(), 10));
            serverSocketChannel.bind(new InetSocketAddress(4399));
            System.out.println("itstack-demo-netty server start done.");
            //等待
            CountDownLatch latch = new CountDownLatch(1);
            serverSocketChannel.accept(this,new AioServerChannelInitializer());
            latch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public AsynchronousServerSocketChannel serverSocketChannel() {
        return serverSocketChannel;
    }

    public static void main(String[] args) {
        new AioServer().start();
    }
}
