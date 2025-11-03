package top.lovebegetslover.javase.network_programming.netty.day04.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.SocketChannel;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    //接收服务端发送的内容
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        String msg = packet.content().toString(Charset.forName("GBK"));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "UDP客服端接收到消息"+msg);
    }
}
