package top.lovebegetslover.javase.network_programming.netty.day01.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * Channel 适配器 模仿 Netty
 * @Author: Lee
 * @Description: AIO 测试
 * @DateTime: 2025/10/28 上午11:14
 **/
//都要实现该接口
//这里使用抽象类的好处 可以有自己的逻辑
public abstract class ChannelAdapter implements CompletionHandler<Integer,Object> {
    //异步通道实例
    private AsynchronousSocketChannel channel;
    //编码格式
    private Charset charset;

    public ChannelAdapter(AsynchronousSocketChannel channel, Charset charset) {
        this.channel = channel;
        this.charset = charset;
        //如果通道是否被打开
        if (channel.isOpen()){

        }
    }
    //重写方法
    @Override
    public void completed(Integer result, Object attachment) {
        try {
            //创建缓冲区
            final ByteBuffer buffer = ByteBuffer.allocate(1024);
            //创建超时时间
            final long timeout = 60 * 60l;
            channel.read(buffer, timeout, TimeUnit.SECONDS, null, new CompletionHandler<Integer,Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    //
                    if (result == -1){
                        try {
                            channelInactive(new ChannelHandler(channel,charset));
                            channel.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        return;
                    }
                    //缓冲区切换
                    buffer.flip();
                    channelRead(new ChannelHandler(channel,charset),charset.decode(buffer));
                    //清空缓冲区
                    buffer.clear();
                    channel.read(buffer,timeout,TimeUnit.SECONDS,null,this);
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    exc.printStackTrace();
                }
            });





        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, Object attachment) {

    }

    public abstract void channelActive(ChannelHandler ctx);

    public abstract void channelInactive(ChannelHandler ctx);

    //读取消息抽象类
    public abstract void channelRead(ChannelHandler ctx , Object msg);
}
