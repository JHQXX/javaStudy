package top.lovebegetslover.javase.network_programming.netty.day04.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午11:30
 **/
public class MyChannelInitializer extends ChannelInitializer<NioDatagramChannel> {
    //初始化Channel
    @Override
    protected void initChannel(NioDatagramChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        //在管道中添加我们自己的接收数据实现方法
        pipeline.addLast(new MyClientHandler());
    }
}
