package com.StudySocket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static com.StudySocket.ServerDemo.BYE;

/**
 * 聊天逻辑封装类
 */
public class Chat {
    public static String from;
    public static String greets;
    private static Socket socket;

    public Chat(String from,String greets,Socket socket) {
        this.from = from;
        this.greets = greets;
        this.socket = socket;
    }

    public void chatting(){
        Scanner scanner = new Scanner(System.in);  //
        try(
                // 输入输出
                BufferedReader bu = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter pr = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8));
                ){
            System.out.println("Socket连接成功，请开始交流吧！！");
            // 是否接收问候语判断
            if(greets != null){
                pr.println("你好" + from + greets);
                pr.flush();
            }
            // 对话
            while (true){
                // 读取一行
                String line = bu.readLine();
                if(line.trim().equalsIgnoreCase(BYE)){
                    System.out.println("对方要求断开连接");
                    pr.println(BYE);
                    pr.flush();
                    break;
                } else {
                    System.out.println("来自" + from + "的内容：" + line);
                }

                // 继续交流
                line = scanner.nextLine();
                pr.println(line);
                pr.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束");
    }
}
