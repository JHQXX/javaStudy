package top.lovebegetslover.netty_2_01;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.lovebegetslover.netty_2_01.server.NettyServer;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/8 上午9:21
 **/
@RestController
@RequestMapping(value = "/nettyserver",method = RequestMethod.GET)
public class NettyController {

    @Resource
    private NettyServer nettyServer;

    @RequestMapping("/localAddress")
    public String localAddress(){
        return "nettyServer localAddress" + nettyServer.getChannel().localAddress();
    }

    @RequestMapping("/isOpen")
    public String isOpen(){
        return "nettyServer isOpen" + nettyServer.getChannel().isOpen();
    }




}
