package scrap;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Random;

/**
 * Created by timothy on 2018-01-25, PACKAGE_NAME.
 */
public class ImageHandler {
    public static void getImageById(Socket socket, String arg) {
        int id = Integer.parseInt(arg);
        System.out.println(id);
    }

    public static void uploadImage(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] sizeAr = new byte[4];
            inputStream.read(sizeAr);
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
            System.out.println(size);
            byte[] imageAr = new byte[size];
            inputStream.read(imageAr);

            int number = new Random().nextInt();
            String path = "/Users/timothy/IdeaProjects/DatabaseServer/src/images/" + number + ".png";
            OutputStream output = new FileOutputStream(new File(path));

            try {
                output.write(imageAr);
            }
            finally {
                output.close();
            }
            /*
            int number = new Random().nextInt();
            String path = "/Users/timothy/IdeaProjects/DatabaseServer/src/images/" + number + ".png";
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));//ImageIO.read(new ByteArrayInputStream(imageAr));
            ImageIO.write(image, "PNG", new File(path));
            */
            //ImageIO.write(image, "png", new File(path));

            /*Database database = new Database();
            try {
                database.insertImagePath(path);
            } catch (SQLException e) {
                e.printStackTrace();
            }*/

        } catch (IOException e) {
            e.printStackTrace();
            ClientHandler.sendResendMessage(socket);
        }
    }
}
