package chattingApp.lv1;

import java.io.BufferedReader;
import java.io.IOException;

public class InputThread extends Thread{
    BufferedReader in;
    public InputThread(BufferedReader in) {
        this.in = in;
    }
    
    @Override
    public void run() {
        try {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
