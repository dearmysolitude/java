package chattingApp.lv2;

import java.io.BufferedReader;
import java.io.IOException;

public class InputThread extends Thread {
    private BufferedReader br;
    public InputThread(BufferedReader br) {
        this.br = br;
    }
    
    @Override
    public void run() {
        try {
            String line = null;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioException) {
            System.out.println("-----");
        }
    }
}
