package top.lovebegetslover.javase.network_programming.netty.day03.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午11:30
 **/
public class NettyClient {
    public static void main(String[] args) {
        new NettyClient().connect("10.175.2.54",4398);
    }

    public void connect(String inetHost , int inetPort){
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.AUTO_READ,true)
                    .handler(new MyChannelInitializer());
            ChannelFuture f = b.connect(inetHost, inetPort).sync();
            System.out.println("客户端链接完成");
            f.channel().closeFuture().sync();

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
        }


    }
}
