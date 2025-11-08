package top.lovebegetslover.netty_2_01.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/8 上午8:57
 **/
@Slf4j
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline line = ch.pipeline();

        //基于换行符
        line.addLast(new LineBasedFrameDecoder(1024));

        //编解码器
        line.addLast(new StringDecoder(Charset.forName("GBK")));
        line.addLast(new StringEncoder(Charset.forName("GBK")));

        //添加自己接受数据的实现方法
        line.addLast(new MyServerHandler());
    }
}
