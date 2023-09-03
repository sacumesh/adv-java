import org.junit.jupiter.api.*;
import services.SQLScriptLoader;

import java.io.IOException;
import java.sql.*;

public class TestJUN2 {

    private Connection connection;

    @BeforeEach
    public void setup() throws SQLException, IOException {

        connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "user","user");
        SQLScriptLoader sqlScriptLoader = new SQLScriptLoader(connection);
        sqlScriptLoader.readAndExecute("src/test/resources/base.sql");

    }


    @AfterEach
    public void cleanup() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE IF EXISTS members;");
        statement.executeUpdate("DROP TABLE IF EXISTS facilities;");
        // Add more DROP TABLE statements for other tables

        // Commit the changes
        connection.commit();

        // Close the connection
        connection.close();

    }

    @Test
    public void testMemberCount() throws SQLException {

        // When
        String sql = "SELECT COUNT(1) FROM members";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        int count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }

        // Then
        Assertions.assertEquals(30, count);

    }


    @Test
    public void testFacilityCount() throws SQLException {

        // When
        String sql = "SELECT COUNT(1) FROM facilities";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        int count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }


        // Then
        Assertions.assertEquals(9, count);
    }

}
