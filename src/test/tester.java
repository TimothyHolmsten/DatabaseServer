package test;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by timothy on 2018-01-25, test.
 */
public class tester {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        String message = "IMAGE_GET 1\n";
        socket.getOutputStream().write(message.getBytes());
    }
}
