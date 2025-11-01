package top.lovebegetslover.javase.network_programming.bookTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Lee
 * @Description: Java原生BIO实现伪代码
 * @DateTime: 2025/10/31 下午2:37
 **/
public class BIO {
    public static void main(String[] args) {
        int port = 4399; //监听端口号
        try {
            //创建一个新的ServerSocket 用于监听指定端口上的连接
            ServerSocket serverSocket = new ServerSocket(port);
            //对accept方法的调用 将会在此处阻塞 直到建立一个连接
            Socket clientSocket = serverSocket.accept();
            //这些流对象都派生于该套接字的流对象
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            //创建请求和反应
            String request,response;
            //处理循环开始
            while ((request = in.readLine())!=null){
                //如果客户端发送了"Done",则退出处理循环
                if ("Done".equals(request)){
                    break;
                }
                //请求被传递给服务器的处理方法
                response=processRequest(request);
                //服务器的响应发送给了客户端
                out.println(response);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String processRequest(String request){
        return "Echo: "+request;
    }
}
