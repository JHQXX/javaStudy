package top.lovebegetslover.javase.network_programming.netty.day02.server;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import top.lovebegetslover.javase.network_programming.netty.day02.codec.MyDecoder;
import top.lovebegetslover.javase.network_programming.netty.day02.codec.MyEncoder;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午8:37
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 基于换行符号
        // socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        // socketChannel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        // socketChannel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));


        //使用自定义编码器
        socketChannel.pipeline().addLast(new MyDecoder());
        socketChannel.pipeline().addLast(new MyEncoder());

        // 在管道中添加我们自己的接收数据实现方法
        socketChannel.pipeline().addLast(new MyServerHandler());

    }

}
