import scrap.Server;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by timothy on 2018-01-25, PACKAGE_NAME.
 */
public class Run {
    public static void main(String[] args) throws IOException, SQLException {
        //Server server = new Server(5000);
        Database database = new Database();
        //database.insertImagePath("/hej");
        try {
            String path = database.getImagePath(7);
            System.out.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
