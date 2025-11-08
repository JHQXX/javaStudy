package top.lovebegetslover.netty.util;

import top.lovebegetslover.netty.domain.MsgBody;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/8 上午10:05
 **/
public class MsgUtil {
    /**
     * 构建protobuf消息体
     */
    public static MsgBody buildMsg(String channelId, String msgInfo) {
        MsgBody.Builder msg = MsgBody.newBuilder();
        msg.setChannelId(channelId);
        msg.setMsgInfo(msgInfo);
        return msg.build();
    }
}
