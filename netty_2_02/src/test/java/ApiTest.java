import com.googlecode.protobuf.format.JsonFormat;
import top.lovebegetslover.netty.domain.MsgBody;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2025/11/8 上午10:43
 **/
public class ApiTest {
    public static void main(String[] args) throws JsonFormat.ParseException {
        MsgBody.Builder msg = MsgBody.newBuilder();
        msg.setChannelId("abD01223");
        msg.setMsgInfo("hi helloworld");
        MsgBody msgBody = msg.build();

        //protobuf转Json 需要引入protobuf-java-format
        String msgBodyStr = JsonFormat.printToString(msgBody);
        System.out.println(msgBodyStr);

        //json转protobuf 需要引入protobuf-java-format
        JsonFormat.merge("{\"channelId\": \"HBdhi993\",\"msgInfo\": \"hi bugstack虫洞栈\"}", msg);
        msgBody = msg.build();
        System.out.println(msgBody.getChannelId());
        System.out.println(msgBody.getMsgInfo());

    }
}
