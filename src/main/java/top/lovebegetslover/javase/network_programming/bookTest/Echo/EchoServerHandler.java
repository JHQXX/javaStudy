package top.lovebegetslover.javase.network_programming.bookTest.Echo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.ByteBuffer;
import java.util.Date;

/**
 * @Author: Lee
 * @Description: echo 服务端处理器
 * @DateTime: 2025/11/1 上午10:32
 **/
//注解作用：标示一个Channel - Handler 可以被多个Channel安全共享
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    //对每一个传入的消息都要调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuffer in = (ByteBuffer) msg;
        //将消息记录到控制台
        System.out.println("服务端收到：" + new Date() + " " + in.toString() + "\r\n");
        //将接收到的消息写给发送者，而不冲刷出战信息
        ctx.write(msg);
    }

    //通知ChannelInboundHandler 最后一次对 Channel-Read()的调用是当前批量读取种的最后一条消息
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将未决消息冲刷到远程节点，并关闭Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }
    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //打印异常
        cause.printStackTrace();
        //关闭channel
        ctx.close();
    }
}

