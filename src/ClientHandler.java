import java.io.InputStream;
import java.net.Socket;

/**
 * Created by timothy on 2018-01-25, PACKAGE_NAME.
 */
public class ClientHandler extends Thread implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        this.start();
    }

    public static void sendResendMessage(Socket socket) {
        try {
            Thread.sleep(200);
            String resend = "RESEND\n";
            socket.getOutputStream().write(resend.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            try {
                byte[] buffer = new byte[32];
                int length = inputStream.read(buffer);
                System.out.println(length);
                String message = new String(buffer, 0, length);
                System.out.println(message);
                String[] splitMessage = message.split(" ");

                Protocol protocol = Protocol.valueOf(splitMessage[0]);
                String arg = "";
                if (splitMessage.length > 1) {
                    arg = splitMessage[1];
                }
                ProtocolHandler.handleProtocolMessage(socket, protocol, arg);
            } catch (Exception e) {
                sendResendMessage(socket);
            }
            String ok = "OK\n";
            socket.getOutputStream().write(ok.getBytes());
            socket.close();

        } catch (Exception e) {
            sendResendMessage(socket);
        }
    }
}
