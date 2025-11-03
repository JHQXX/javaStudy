package top.lovebegetslover.javase.network_programming.netty.day04.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午8:38
 **/
public class NettyServer {
    public static void main(String[] args) {
        new NettyServer().bing(4398);
    }

    public void bing(int port){
        //配置服务器NIO线程组
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)//非阻塞模式
                    .option(ChannelOption.SO_BROADCAST,true)//广播
                    .option(ChannelOption.SO_RCVBUF,2048 * 1024)//设置UDP读缓冲区为2M
                    .option(ChannelOption.SO_SNDBUF,1024 * 1024)//设置UDP写缓冲区为1M
                    .handler(new MyChannelInitializer());
            ChannelFuture f = b.bind(port).sync();
            System.out.println("连接开始");
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            //优雅的关闭
            group.shutdownGracefully();
        }

    }
}
