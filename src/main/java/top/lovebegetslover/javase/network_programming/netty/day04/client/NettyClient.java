package top.lovebegetslover.javase.network_programming.netty.day04.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

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
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .handler(new MyChannelInitializer());
            Channel ch = b.bind(inetPort).sync().channel();
            ch.writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer("你好，我是李志，我是4399的客户端，你好你在吗？", Charset.forName("GBK")),
                    new InetSocketAddress(inetHost,inetPort))).sync();
            ch.closeFuture().await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }


    }
}
