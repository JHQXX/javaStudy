package top.lovebegetslover.javase.network_programming.bookTest;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @Author: Lee
 * @Description: 异步连接伪代码
 * @DateTime: 2025/11/1 上午9:17
 **/
public class ChannelFutureTest {


    public static void main(String[] args) {
        //创建一个group
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group( group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    //创建编码器
                    socketChannel.pipeline().addLast(new StringEncoder(Charset.defaultCharset()));
//                    //解码器
//                    socketChannel.pipeline().addLast(new StringDecoder(Charset.defaultCharset()));
                }
            });
            //连接不会停止--异步地连接到远程节点
            ChannelFuture future = bootstrap.connect(new InetSocketAddress("10.175.2.54", 4395));
            future.addListener(new ChannelFutureListener() { //这里注册了一个ChannelFutureListener 以便在操作完成的时候获取通知
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    //检查操作状态
                    if (future.isSuccess()){
                        //如果操作是成功的
                        ByteBuf buffer = Unpooled.copiedBuffer("hello world", Charset.defaultCharset());
                        //发送数据--通过管道
                        future.channel().writeAndFlush(buffer);
                    }else {
                        //如果发生错误 则描述原因的Throwable
                        Throwable cause = future.cause();
                        cause.printStackTrace();
                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
