package chattingApp.lv1;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);

        List<PrintWriter> outList = Collections.synchronizedList(new ArrayList<>());
        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("접속: "+ socket);
            
            ChatThread chatThread = new ChatThread(socket, outList);
            chatThread.start();
        }
    }
}
