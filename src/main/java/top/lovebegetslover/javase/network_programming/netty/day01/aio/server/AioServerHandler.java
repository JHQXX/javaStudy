package top.lovebegetslover.javase.network_programming.netty.day01.aio.server;

import top.lovebegetslover.javase.network_programming.netty.day01.aio.ChannelAdapter;
import top.lovebegetslover.javase.network_programming.netty.day01.aio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/10/28 上午11:14
 **/
public class AioServerHandler extends ChannelAdapter {
    public AioServerHandler(AsynchronousSocketChannel channel, Charset charset) {
        super(channel, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try {
            System.out.println(" 链接报告信息:" + ctx.channel().getRemoteAddress());
            //通知客户端链接建立成功
            ctx.writeAndFlush(" 通知服务端链接建立成功" + " " + new Date() + " " + ctx.channel().getRemoteAddress() + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelInactive(ChannelHandler ctx) {

    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(" 服务端收到：" + new Date() + " " + msg + "\r\n");
        ctx.writeAndFlush("服务端信息处理Success！\r\n");
    }
}
