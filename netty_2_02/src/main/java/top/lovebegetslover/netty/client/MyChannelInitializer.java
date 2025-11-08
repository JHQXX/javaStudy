package top.lovebegetslover.netty.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import top.lovebegetslover.netty.domain.MsgBody;
import top.lovebegetslover.netty.client.MyClientHandler;


/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/8 上午10:04
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline line = ch.pipeline();

        //protobuf处理
        line.addLast(new ProtobufVarint32FrameDecoder());
        //编解码器
        line.addLast(new ProtobufDecoder(MsgBody.getDefaultInstance()));
        line.addLast(new ProtobufVarint32LengthFieldPrepender());
        line.addLast(new ProtobufEncoder());

        //添加自己接受数据的实现方法
        line.addLast(new MyClientHandler());
    }
}
