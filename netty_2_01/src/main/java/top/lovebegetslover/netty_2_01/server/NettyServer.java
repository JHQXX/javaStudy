package top.lovebegetslover.netty_2_01.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/8 上午8:57
 **/
@Component("nettyServer")
public class NettyServer {

    private Logger logger = LoggerFactory.getLogger(NettyServer.class);


    //配置服务端NIO线程组

    private final EventLoopGroup parentGroup = new NioEventLoopGroup();
    private final EventLoopGroup childGroup = new NioEventLoopGroup();

    private Channel channel;


    public ChannelFuture bing(InetSocketAddress address){
        ChannelFuture channelFuture = null;
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(parentGroup,childGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childHandler(new MyChannelInitializer());
            channelFuture = b.bind(address).syncUninterruptibly();
            channel = channelFuture.channel();


        }catch (Exception e){
            logger.error("服务端，服务器异常: {}" , e.getMessage());
        }finally {
            if (null != channelFuture && channelFuture.isSuccess()){
                logger.info("服务器启动成功");
            }else {
                logger.info("服务器启动失败");
            }

        }
        return channelFuture;
    }

    public void destroy(){
        if (null==channel) return;
        channel.config();
        parentGroup.shutdownGracefully();
        childGroup.shutdownGracefully();
    }

    public Channel getChannel(){
        return channel;
    }
}
