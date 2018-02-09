package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by timothy on 2018-02-09, model.
 */
public class ImageGrabber {
    public static boolean saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();

        BufferedImage image = ImageIO.read(is);
        ImageIO.write(image, "jpg", new File(destinationFile));

        is.close();

        return true;
    }
}
