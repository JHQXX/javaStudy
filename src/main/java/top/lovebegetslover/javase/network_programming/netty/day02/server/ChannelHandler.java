package top.lovebegetslover.javase.network_programming.netty.day02.server;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/3 上午11:07
 **/
public class ChannelHandler {

    //用于存放用户的Channel信息 也可以建立map结构模拟不同的消息群
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
