package com.StudySocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class ServerDemo {
    public static int PORT = 54321;
    public static String BYE = "bye";

    public static void main(String[] args) {
        comWithClient();
    }

    // 连接客户端
    private static void comWithClient() {
        System.out.println("Server已启动，在端口" + PORT + "处监听... ...");
        try(
                ServerSocket ss = new ServerSocket(PORT);
                Socket s = ss.accept();
                ){
            Chat chat = new Chat("客户端","，我们可以开始交流了",s);
            chat.chatting();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("服务退出！");
    }
}
