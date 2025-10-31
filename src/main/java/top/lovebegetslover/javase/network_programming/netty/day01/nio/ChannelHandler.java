package top.lovebegetslover.javase.network_programming.netty.day01.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Handler 处理者
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/10/31 上午11:21
 **/
public class ChannelHandler {


    private SocketChannel channel;

    private Charset charset;

    public ChannelHandler(SocketChannel channel, Charset charset) {
        this.channel = channel;
        this.charset = charset;
    }

    public void writeAndFlush(Object msg) {
        OutputStream out = null;
        try {
            byte[] bytes = msg.toString().getBytes(charset);
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public SocketChannel channel(){
        return channel;
    }

    public void setChannel(SocketChannel channel){
        this.channel = channel;
    }


}
