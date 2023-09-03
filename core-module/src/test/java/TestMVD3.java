import services.SQLScriptLoader;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMVD3 {

    public static void main(String[] args) throws SQLException, IOException {

        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "user","user");
        SQLScriptLoader sqlScriptLoader = new SQLScriptLoader(connection);
        sqlScriptLoader.readAndExecute("core-module/src/test/resources/base.sql");

    }
}
