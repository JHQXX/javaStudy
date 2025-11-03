package top.lovebegetslover.javase.network_programming.netty.day02.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午9:13
 **/
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        System.out.println("连接开始：");
        System.out.println("有一条客户端连接到服务端");
        System.out.println("连接IP"+channel.localAddress().getHostString());
        System.out.println("连接Port"+channel.localAddress().getPort());
        System.out.println("连接完成");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接收消息
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] bytes = new byte[buf.readableBytes()];
//        buf.readBytes(bytes);
//        System.out.println("接收到消息"+new Date());
//        System.out.println(new String (bytes, Charset.forName("GBK")));
//        System.out.println("接收到消息"+new Date()+" "+buf.toString());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "接收消息:"+msg);
    }
}
