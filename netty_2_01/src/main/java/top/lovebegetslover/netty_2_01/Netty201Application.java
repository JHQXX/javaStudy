package top.lovebegetslover.netty_2_01;

import io.netty.channel.ChannelFuture;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.lovebegetslover.netty_2_01.server.NettyServer;

import java.net.InetSocketAddress;

@SpringBootApplication
public class Netty201Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Netty201Application.class, args);
    }
    @Value("${netty.host}")
    private String host;

    @Value("${netty.port}")
    private int port;

    @Resource
    private NettyServer nettyServer;

    @Override
    public void run(String... args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(host,port);
        ChannelFuture channelFuture = nettyServer.bing(address);
        Runtime.getRuntime().addShutdownHook(new Thread(()->nettyServer.destroy()));
        channelFuture.channel().closeFuture().syncUninterruptibly();
    }
}
