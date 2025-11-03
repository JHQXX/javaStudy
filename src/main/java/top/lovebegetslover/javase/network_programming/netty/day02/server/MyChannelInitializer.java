package top.lovebegetslover.javase.network_programming.netty.day02.server;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午8:37
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        /*解码器*/
        // 基于换行符
         socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // 基于指定字符串【换行符，这样的功能等同于LineBasedFrameDecoder】
        // socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, false, Delimiters.lineDelimiter()));
        // 基于最大长度
        // socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(4));
        // 解码转String,注意调整自己的编码格式GBK , UTF-8
        socketChannel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
        //添加实现
        socketChannel.pipeline().addLast(new MyServerHandler());





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
