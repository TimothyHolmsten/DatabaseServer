import java.net.Socket;

/**
 * Created by timothy on 2018-01-25, PACKAGE_NAME.
 */
public class ProtocolHandler {
    public static void handleProtocolMessage(Socket socket, Protocol protocol, String arg) {
        switch (protocol) {
            case IMAGE_UPLOAD:
                ImageHandler.uploadImage(socket);
                break;
            case IMAGE_GET:
                ImageHandler.getImageById(socket, arg);
                break;
            default:
                // Unknown message
        }
    }
}
