package top.lovebegetslover.javase.network_programming.netty.day02.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午9:13
 **/
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接收消息
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        System.out.println("接收到消息"+new Date());
        System.out.println(new String (bytes, Charset.forName("GBK")));
    }
}
