package top.lovebegetslover.javase.network_programming.netty.day02.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
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
        //建立连接以后,把客户放入Group中
        ChannelHandler.channelGroup.add(ctx.channel());
        SocketChannel channel = (SocketChannel) ctx.channel();
        System.out.println("连接开始：");
        System.out.println("有一条客户端连接到服务端");
        System.out.println("连接IP"+channel.localAddress().getHostString());
        System.out.println("连接Port"+channel.localAddress().getPort());
        System.out.println("连接完成");
        //通知客户端连接建立成功
        String str = "连接成功" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ " " + channel.localAddress().getHostString() + "\r\n";
        ctx.writeAndFlush(str);
    }

    /**
     * 客户端主动断开服务器的连接后,就是这个通道不活跃了,调用了这个方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端断开连接"+ctx.channel().localAddress().toString());
        //当有客户端退出后,从ChannelGroup中移出
        ChannelHandler.channelGroup.remove(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接收消息 版本2.0 使用自动解码器
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "接收消息:"+msg);
        //群发给客户端
        String str = "服务端收到:" + new Date() + " " + msg + "\r\n";
        //推送给客户端
        ChannelHandler.channelGroup.writeAndFlush(str);
    }

    /**
     * 异常捕获,当发生异常的时候,可以做一些相当的处理,比如有日志,关闭连接等
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        System.out.println("异常:\r\n"+cause.getMessage());
    }
}
