package scrap;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by timothy on 2018-01-25, PACKAGE_NAME.
 */
public class Server extends Thread implements Runnable {
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                new ClientHandler(serverSocket.accept());
                System.out.println("Got connection!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
