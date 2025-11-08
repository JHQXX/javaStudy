package top.lovebegetslover.netty_2_01.server;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/8 上午8:57
 **/
@Slf4j
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(MyServerHandler.class);
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel)ctx.channel();
        logger.info("连接报告开始");
        logger.info("连接报告信息 ：有一条客户端信息连接到本地服务器");
        logger.info("IP：{}" , channel.localAddress().getHostString());
        logger.info("Porty：{}" , channel.localAddress().getPort());
        logger.info("报告完毕");
        //通知客户端

        String str = "建立连接成功" + " " + "连接时间 ： " + new Date() + " " + channel.localAddress().getHostString() + "\r\n";
        ctx.writeAndFlush(str);
    }

    /**
     * 断开连接后的操作
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端断开了连接：{}" , ctx.channel().localAddress().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "服务器接受到信息:" + msg);
         //通知客户端消息接受成功
        String str = "服务端接受到信息" + new Date() + " " + msg + "\r\n";
        ctx.writeAndFlush(str);
    }


    /**
     * 异常处理
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        logger.error("异常信息 ： {}" , cause.getMessage());
    }
}
