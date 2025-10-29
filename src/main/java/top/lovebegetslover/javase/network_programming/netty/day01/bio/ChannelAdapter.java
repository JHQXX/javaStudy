package top.lovebegetslover.javase.network_programming.netty.day01.bio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * channel 适配器 模仿 Netty
 */
public abstract class ChannelAdapter extends Thread {

    private SocketChannel socketChannel;

    private ChannelHandler channelHandler;

    private Charset charset;

    public ChannelAdapter (SocketChannel socketChannel,Charset charset){
        this.socketChannel=socketChannel;
        this.charset=charset;
        while (!socketChannel.isConnected()){
            break;
        }
        channelHandler = new ChannelHandler(this.socketChannel, charset);

    }
    //重写run方法 线程方法
    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(this.socketChannel.socket().getInputStream(), charset));
            String str = null;
            while ((str = input.readLine()) != null){
                channelRead(channelHandler,str);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //链接通知抽象类
    public abstract void channelActive(ChannelHandler ctx);

    //读取消息抽象类
    public abstract void channelRead(ChannelHandler ctx , Object msg);







}
