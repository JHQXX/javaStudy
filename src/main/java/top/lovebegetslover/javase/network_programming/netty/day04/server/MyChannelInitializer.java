package top.lovebegetslover.javase.network_programming.netty.day04.server;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import top.lovebegetslover.javase.network_programming.netty.day02.codec.MyDecoder;
import top.lovebegetslover.javase.network_programming.netty.day02.codec.MyEncoder;

import java.nio.charset.Charset;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午8:37
 **/
public class MyChannelInitializer extends ChannelInitializer<NioDatagramChannel> {

    private EventLoopGroup group = new NioEventLoopGroup();


    @Override
    protected void initChannel(NioDatagramChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(group,new MyServerHandler());
    }
}
