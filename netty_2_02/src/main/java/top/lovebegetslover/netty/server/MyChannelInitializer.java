package top.lovebegetslover.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;
import top.lovebegetslover.netty.domain.MsgBody;

import java.nio.charset.Charset;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/8 上午8:57
 **/
@Slf4j
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
        line.addLast(new MyServerHandler());
    }
}
