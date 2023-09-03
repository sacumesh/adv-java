import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringApplicationContext.class)
public class TestSPR2 {

    @Autowired
    private DataSource ds;


    @Test
    public void testConnection() throws SQLException {
        Assertions.assertEquals("PUBLIC", ds.getConnection().getSchema());


    }


    @Test
    public void testMemberCount() throws SQLException {

        // When
        Connection connection = ds.getConnection();
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
        Connection connection = ds.getConnection();
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
