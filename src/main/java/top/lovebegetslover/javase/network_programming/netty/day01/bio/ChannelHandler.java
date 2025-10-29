package top.lovebegetslover.javase.network_programming.netty.day01.bio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * handler 处理者
 */
public class ChannelHandler {

    private SocketChannel channel;



    private Charset charset;

    public ChannelHandler(SocketChannel channel, Charset charset) {
        this.channel = channel;
        this.charset = charset;
    }

    public void writeAndFlush(Object msg) {
        try {//拿取信息字节
        byte[] bytes = msg.toString().getBytes(charset);
        //通过字节长度创建对应buffer 创建默认为写模式
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        //存放到buffer
        writeBuffer.put(bytes);
        //反转到读模式
        writeBuffer.flip();
        //读取buffer 到channel中 处理者中
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
