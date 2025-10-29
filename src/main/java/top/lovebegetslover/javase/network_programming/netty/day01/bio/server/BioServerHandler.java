package top.lovebegetslover.javase.network_programming.netty.day01.bio.server;

import top.lovebegetslover.javase.network_programming.netty.day01.bio.ChannelAdapter;
import top.lovebegetslover.javase.network_programming.netty.day01.bio.ChannelHandler;

import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 服务端消息处理
 */
public class BioServerHandler extends ChannelAdapter {
    public BioServerHandler(SocketChannel socketChannel, Charset charset) {
        super(socketChannel, charset);
    }

    //链接事件处理
    @Override
    public void channelActive(ChannelHandler ctx) {
        System.out.println("链接报告LocalAddress:" + ctx.channel().socket().getLocalAddress());
        ctx.writeAndFlush("hi! BIOServer to msg for you \r\n");
    }

    //读取事件
    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);
        ctx.writeAndFlush("hi 我已经收到你的消息Success！\r\n");
    }
}
