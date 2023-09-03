import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.SQLScriptLoader;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class TestJUN1 {
    private Connection connection;

    @BeforeEach
    public void setup() throws SQLException, IOException {

        connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "user","user");
        SQLScriptLoader sqlScriptLoader = new SQLScriptLoader(connection);
        sqlScriptLoader.readAndExecute("src/test/resources/base.sql");

    }

    @Test
    public void test() throws SQLException {

        String sql = "SELECT COUNT(1) FROM members";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        int count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }

        Assertions.assertEquals(30, count);


        sql = "SELECT COUNT(1) FROM facilities";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }

        Assertions.assertEquals(9, count);

    }

}
