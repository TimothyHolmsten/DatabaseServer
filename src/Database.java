import java.sql.*;

/**
 * Created by timothy on 2018-02-05, PACKAGE_NAME.
 */
public class Database {
    final static String db = "pricevision";
    final static String user = "root";
    final static String password = "password";

    private Connection connection;

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/pricevision?" +
                            "user=root&password=password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertImagePath(String path) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "INSERT INTO Image (imagePath) VALUES (?)",
                        Statement.RETURN_GENERATED_KEYS
                );

        preparedStatement.setString(1, path);
        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0)
            throw new SQLException("No rows affected");

        int id = -1;
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next())
            id = rs.getInt(1);
        rs.close();
        preparedStatement.close();

        return id;
    }

    public String getImagePath(int id) throws Exception {
        String imagePath = "";
        try {
            ResultSet rs;
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT imagePath FROM Image WHERE imageId = ?");
            preparedStatement.setInt(1, id);

            rs = preparedStatement.executeQuery();

            if (rs.next())
                imagePath = rs.getString(1);

            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (imagePath.length() > 0)
            return imagePath;
        throw new Exception("No image found");
    }

    public void startTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void endTransaction() {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
