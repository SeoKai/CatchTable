package util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionUtil {

    private static DataSource dataSource;

    // static 블록을 통해 최초 한 번만 DataSource 초기화
    static {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/MysqlDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    // 필요할 때마다 Connection을 가져오는 메서드
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
