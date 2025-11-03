package top.lovebegetslover.javase.network_programming.netty.day05.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;


/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 下午4:27
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //数据解码操作
        socketChannel.pipeline().addLast(new HttpResponseEncoder());

        //数据编码操作
        socketChannel.pipeline().addLast(new HttpResponseDecoder());

        //在管道中添加我们的实现方法
        socketChannel.pipeline().addLast(new MyServerHandler());
    }
}
