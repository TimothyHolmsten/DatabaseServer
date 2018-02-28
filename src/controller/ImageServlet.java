package controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by timothy on 2018-02-07, ${PACKAGE_NAME}.
 */
public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");

        BufferedImage bi = ImageIO.read(
                new File("/Users/timothy/IdeaProjects/DatabaseServer/web" + request.getRequestURI()));
        OutputStream os = response.getOutputStream();

        ImageIO.write(bi, "jpeg", os);

    }
}
