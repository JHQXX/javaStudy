package top.lovebegetslover.javase.network_programming.netty.day02.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午11:30
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    //初始化Channel
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        System.out.println("链接报告开始");
        System.out.println("链接报告信息：本客户端链接到服务端 channelId:"+ channel.id());
        System.out.println("链接报告完成");
    }
}
