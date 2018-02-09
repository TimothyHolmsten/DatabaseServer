package test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by timothy on 2018-01-25, test.
 */
public class tester {
    public static void main(String[] args) throws IOException {
        String imageUrl = "http://localhost:8080/images/tre.jpg";
        String destinationUrl = "/Users/timothy/IdeaProjects/DatabaseServer/src/test/test.jpg";
        saveImage(imageUrl, destinationUrl);
    }


    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();

        BufferedImage image = ImageIO.read(is);
        ImageIO.write(image, "jpg", new File(destinationFile));

        is.close();
    }
}
