package top.lovebegetslover.javase.network_programming.netty.day01.nio.server;

import top.lovebegetslover.javase.network_programming.netty.day01.nio.ChannelAdapter;
import top.lovebegetslover.javase.network_programming.netty.day01.nio.ChannelHandler;

import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * NIO 服务端处理器
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/10/31 上午11:19
 **/
public class NioServerHandler extends ChannelAdapter {
    public NioServerHandler(Selector selector, Charset charset) {
        super(selector, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        System.out.println("链接报告LocalAddress:" + ctx.channel().socket().getLocalAddress());
        ctx.writeAndFlush("hi! BIOServer to msg for you \r\n");
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);
        ctx.writeAndFlush("hi 我已经收到你的消息Success！\r\n");
    }
}
