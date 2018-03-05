import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by timothy on 2018-01-25, PACKAGE_NAME.
 */
public class Run {
    public static void main(String[] args) throws IOException, SQLException {
        //Server server = new Server(5000);
        HttpServer httpServer = HttpServerFactory.create("http://localhost:5000/");
        httpServer.start();
        //test
    }
}
