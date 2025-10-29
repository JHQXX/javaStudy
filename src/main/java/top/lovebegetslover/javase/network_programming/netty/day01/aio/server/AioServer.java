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
            //使用多线程创建--打开异步服务器嵌套窗口
            serverSocketChannel = AsynchronousServerSocketChannel.open(AsynchronousChannelGroup.withCachedThreadPool(Executors.newCachedThreadPool(), 10));
            //绑定端口
            serverSocketChannel.bind(new InetSocketAddress(4399));
            System.out.println("itstack-demo-netty server start done.");
            //等待
            CountDownLatch latch = new CountDownLatch(1);
            //this 当前AioServer 的实例对象  后面是回调处理器
            serverSocketChannel.accept(this,new AioServerChannelInitializer());
            //永久等待 因为计算器不会变为0
            latch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public AsynchronousServerSocketChannel serverSocketChannel() {
        return serverSocketChannel;
    }

    public static void main(String[] args) {
        //启动服务 该线程会自动执行run 方法
        new AioServer().start();
    }
}
