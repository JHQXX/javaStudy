package top.lovebegetslover.javase.network_programming.bookTest.Echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/1 上午10:54
 **/
public class EchoServer {

    //节点
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception{
        if (args.length!=1){
            System.err.println("Usage: java EchoServer <port>" + EchoServer.class.getSimpleName()+" ");
        }
        //设置端口值
        int port = Integer.parseInt(args[0]);
        //启动服务器
        new EchoServer(port).start();

    }

    public void start() throws  Exception{
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        //创建一个线程组 nio  非阻塞io
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建ServerBootstrap 启动
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(group)
                    .channel(NioServerSocketChannel.class) //指定NIO传输的Channel
                    .localAddress(new InetSocketAddress(port)) // 使用指定的端口设置套接字地址
                    .childHandler(new ChannelInitializer<>() {
                        //添加一个EchoServerHandler 到 Channel 的 ChannelPipeline 中
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            //添加一个EchoServerHandler 到 Channel 的 ChannelPipeline 中
                            //因为我们标记了@Shareable注解，所有我们总是可以用同一个实例，所以可以final
                            channel.pipeline().addLast(echoServerHandler);
                        }
                    });
            //异步绑定服务器，调用sync()方法阻塞等待直到绑定完成
            ChannelFuture f = serverBootstrap.bind().sync();
            //获取Channel 的 CloseFuture，并且阻塞当前线程直到它完成
            f.channel().closeFuture().sync();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //关闭group 释放所有的资源
            group.shutdownGracefully().sync();
        }


    }
}
