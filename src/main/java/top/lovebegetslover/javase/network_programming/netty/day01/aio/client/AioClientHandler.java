package top.lovebegetslover.javase.network_programming.netty.day01.aio.client;

import top.lovebegetslover.javase.network_programming.netty.day01.aio.ChannelAdapter;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;

/**
 * 客户端消息处理器
 * @Author: Lee
 * @Description: AIO 测试
 * @DateTime: 2025/10/28 上午11:08
 **/
public class AioClientHandler extends ChannelAdapter {

    public AioClientHandler(AsynchronousSocketChannel channel, Charset charset){
        super(channel,charset);
    }


}
