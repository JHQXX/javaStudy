package top.lovebegetslover.javase.network_programming.netty.day01.aio.server;

import top.lovebegetslover.javase.network_programming.netty.day01.aio.ChannelInitializer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * AIO 测试
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/10/28 上午11:09
 **/
public class AioServerChannelInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(AsynchronousSocketChannel channel) throws Exception {
        channel.read(ByteBuffer.allocate(1024),10, TimeUnit.SECONDS,null,new AioServerHandler(channel, Charset.forName("GBK")));
    }
}
