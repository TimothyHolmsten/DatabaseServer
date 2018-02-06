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

        return preparedStatement.getGeneratedKeys().getInt(1);
    }

    public void startTransaction() {

    }

    public void endTransaction() {

    }
}
