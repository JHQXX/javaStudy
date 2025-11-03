package top.lovebegetslover.javase.network_programming.netty.day02.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        System.out.println("链接开始");
        System.out.println("channel id: " + channel.id());
        System.out.println("ip:"+channel.localAddress().getHostString());
        System.out.println("port:"+channel.localAddress().getPort());
        System.out.println("链接报告完成");
        //通知客户端链接建立成功
        String str = "建立成功" + " " + new Date() + " " + channel.localAddress().getHostString()+ "\r\n";
        ctx.writeAndFlush(str);
    }

    /**
     * 关闭连接 channelInactive 不活动的channel
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("断开连接" + ctx.channel().localAddress().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接收msg信息
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "接收到信息" +msg);
        //通知客户端信息发送成功
        String str = "客户端收到:" + new Date() + " " + msg + "\r\n";
        ctx.writeAndFlush(str);
    }

    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        System.out.println("异常信息 : \r\n" + cause.getMessage());
    }
}
