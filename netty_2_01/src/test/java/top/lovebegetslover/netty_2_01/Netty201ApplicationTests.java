package top.lovebegetslover.netty_2_01;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
class Netty201ApplicationTests {



    //创建客户端
    public static void main(String[] args) {
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.AUTO_READ,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //基于换行符
                            ChannelPipeline line = ch.pipeline();
                            //基于换行符
                            line.addLast(new LineBasedFrameDecoder(1024));
                            //编解码器
                            line.addLast(new StringDecoder(Charset.forName("GBK")));
                            line.addLast(new StringEncoder(Charset.forName("GBK")));
                            //添加自己接受数据的实现方法
                            line.addLast(new ChannelInboundHandlerAdapter(){
                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 客户端接收到消息：" + msg);
                                }
                            });
                        }
                    });
            //傻逼了，为啥我要写绑定，应该是连接才对
            ChannelFuture f = b.connect("127.0.0.1", 7397).sync();

            System.out.println("客户端连接服务端成功");
            //发送消息
            f.channel().writeAndFlush("你好，这里是Springboot启动的Netty服务器，是客户端  检查处理传输的半包粘包问题 \r\n");
            f.channel().writeAndFlush("你好，这里是Springboot启动的Netty服务器，是客户端  检查处理传输的半包粘包问题 \r\n");
            f.channel().writeAndFlush("你好，这里是Springboot启动的Netty服务器，是客户端  检查处理传输的半包粘包问题 \r\n");
            f.channel().writeAndFlush("你好，这里是Springboot启动的Netty服务器，是客户端  检查处理传输的半包粘包问题 \r\n");
            f.channel().writeAndFlush("你好，这里是Springboot启动的Netty服务器，是客户端  检查处理传输的半包粘包问题 \r\n");

            f.channel().closeFuture().syncUninterruptibly();
        }catch (Exception e){
            System.out.println("服务端，服务器异常:" + e.getMessage());
        }finally {
            workGroup.shutdownGracefully();
    }
    }

}
