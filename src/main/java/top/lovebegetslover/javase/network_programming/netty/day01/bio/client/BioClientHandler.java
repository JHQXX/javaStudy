package top.lovebegetslover.javase.network_programming.netty.day01.bio.client;

import top.lovebegetslover.javase.network_programming.netty.day01.bio.ChannelAdapter;
import top.lovebegetslover.javase.network_programming.netty.day01.bio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 客户端处理消息器
 */
public class BioClientHandler extends ChannelAdapter {
    public BioClientHandler(SocketChannel socketChannel, Charset charset) {
        super(socketChannel, charset);
    }
    //建立链接的时候处理的事件
    @Override
    public void channelActive(ChannelHandler ctx) {
        //思考一个问题 为啥使用 socketChannel 和 socket 两者 在使用同一个方法的时候 前者需要抛出异常
        System.out.println("链接报告LocalAddress: " + ctx.channel().socket().getLocalAddress());
        ctx.writeAndFlush("你好！ 我是BIO 处理器 msg for you \r\n");
    }

    //发生读取事件的处理
    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "接受到信息为："+msg);
        ctx.writeAndFlush("hi 我已经收到你的消息了 \r\n");
    }
}
