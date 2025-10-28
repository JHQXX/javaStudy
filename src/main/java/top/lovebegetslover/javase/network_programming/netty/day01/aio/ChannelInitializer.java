package top.lovebegetslover.javase.network_programming.netty.day01.aio;

import top.lovebegetslover.javase.network_programming.netty.day01.aio.server.AioServer;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/10/28 上午11:14
 **/
public abstract class ChannelInitializer implements CompletionHandler<AsynchronousSocketChannel, AioServer> {


    @Override
    public void completed(AsynchronousSocketChannel channel, AioServer attachment) {
        try {
            initChannel(channel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            attachment.serverSocketChannel().accept(attachment,this);//再次接收客户端连接
        }
    }

    @Override
    public void failed(Throwable exc, AioServer attachment) {
        exc.getStackTrace();
    }

    protected abstract void initChannel(AsynchronousSocketChannel channel) throws  Exception;
}
