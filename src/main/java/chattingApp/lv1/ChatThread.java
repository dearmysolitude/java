package chattingApp.lv1;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ChatThread extends Thread {
    private Socket socket;
    private List<PrintWriter>outList;
    private PrintWriter out;
    private BufferedReader in;
    
    public ChatThread(Socket socket, List<PrintWriter> outList) {
        this.socket = socket;
        this.outList = outList;
        
        // 1. socket으로부터 읽을 수 있는 객체를 얻는다.
        // 2. socket에 쓰기 위한 객체를 얻는다.
        try {
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            outList.add(out);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        String line = null;
        try{
            while ((line = in.readLine()) != null) {
                for(int i = 0; i < outList.size(); i++) {
                    PrintWriter o = outList.get(i);
                    o.println(line);
                    o.flush();
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                outList.remove(out); // 리스트에서 스스로를제거
            } catch (Exception e) {
                e.printStackTrace();
            }
            //  모든 연결을 끊었으면 메세지를 브로드캐스팅한다.
            
            for(int i = 0; i < outList.size(); i++) {
                PrintWriter o = outList.get(i);
                o.println("어떤 클라이언트의 접속이 끊어졌습니다.");
                o.flush();
            }
        }
    }
}
