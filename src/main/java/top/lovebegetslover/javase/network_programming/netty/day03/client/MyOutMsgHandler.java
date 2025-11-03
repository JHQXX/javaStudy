package top.lovebegetslover.javase.network_programming.netty.day03.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.SocketChannel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyOutMsgHandler extends ChannelOutboundHandlerAdapter {


    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("ChannelOutboundHandlerAdapter.read 发来一条消息\r\n");
        super.read(ctx);
    }

    //启动客户端发送消息
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ctx.writeAndFlush("ChannelOutboundHandlerAdapter.write 发来一条信息\r\n");
        super.write(ctx, msg, promise);
    }




    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        System.out.println("异常信息 : \r\n" + cause.getMessage());
    }
}
