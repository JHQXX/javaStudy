package top.lovebegetslover.javase.network_programming.netty.day04.server;


import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.SocketChannel;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午9:13
 **/
public class MyServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        String msg = packet.content().toString(Charset.forName("GBK"));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "UDP服务端接收到消息"+msg);

        //向客户端发送消息
        String json = "李志：你的信息我已经收到了\r\n";
        //由于数据报的数据是以字符数组的传的形式存储，所有传转数据
        byte[] bytes = json.getBytes(Charset.forName("GBK"));
        DatagramPacket data = new DatagramPacket(Unpooled.copiedBuffer(bytes), packet.sender());
        ctx.writeAndFlush(data);//向客户端发送信息
    }

}
