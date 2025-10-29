package top.lovebegetslover.javase.network_programming.netty.day01.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
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
        OutputStream out = null;
        try {
            //拿取信息字节 由于同步不需要 buffer 缓存
            out = channel.socket().getOutputStream();
            out.write(msg.toString().getBytes(charset));
            out.flush();
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
