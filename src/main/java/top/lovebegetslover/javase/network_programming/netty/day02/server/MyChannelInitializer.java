package top.lovebegetslover.javase.network_programming.netty.day02.server;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;

import java.nio.ByteBuffer;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午8:37
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        System.out.println("开始连接");
        System.out.println("ip"+ socketChannel.localAddress().getAddress());
        System.out.println("port"+ socketChannel.localAddress().getPort());
        System.out.println("连接完毕");
//        错误的尝试
//        socketChannel.pipeline().addLast(new SimpleChannelInboundHandler<Byte>() {
//            @Override
//            protected void channelRead0(ChannelHandlerContext channelHandlerContext, Byte aByte) throws Exception {
//                //读取
//                System.out.println("接收到信息3：" + aByte.toString());
//                //writeAndFlush he write 的区别
////        ctx.writeAndFlush(msg);
//                channelHandlerContext.write(aByte);
//            }
//
//
//            @Override
//            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                //读取
//                ByteBuffer b = (ByteBuffer) msg;
//                System.out.println("接收到信息2：" + b.toString());
//                //writeAndFlush he write 的区别
////        ctx.writeAndFlush(msg);
//                ctx.write(msg);
//            }
//        });
    }

}
