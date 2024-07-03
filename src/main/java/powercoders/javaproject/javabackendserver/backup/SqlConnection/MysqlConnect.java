package powercoders.javaproject.javabackendserver.backup.SqlConnection;

import java.sql.*;

public class MysqlConnect {
    public static void SqlConnect() {
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JavaBackend","root","hing626102"
            );
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from usernameAndPassword");
            if (rs != null){
//                System.out.println(rs);
                System.out.println("Mysql Connected Successfully");
            }
//            while(rs.next()) {
//                System.out.println(rs.getInt("id"));
//                System.out.println(rs.getString("username"));
//                System.out.println(rs.getString("password"));
//
//            }
            connection.close();
        } catch(SQLException e){ e.printStackTrace();}
    }
    public static Object SqlConnect(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/JavaBackend";
        String user = "root";
        String pass = "abcabc";

        String sql = "SELECT * FROM usernameAndPassword WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                System.out.println(rs.next());
                if (rs.next()) {
                    return "Login Successfully";
                } else {
                    return "Login Failed";
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
