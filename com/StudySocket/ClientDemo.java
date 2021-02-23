package com.StudySocket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import static com.StudySocket.ServerDemo.PORT;


/**
 * 客户端
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        comwithServer();
    }

    private static void comwithServer() {
        try(
                Socket socket = new Socket("localhost",PORT);
        ){
            Chat c = new Chat("服务端",null,socket);
            c.chatting();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("客户端退出！");
    }
}
