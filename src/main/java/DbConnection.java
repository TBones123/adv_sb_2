import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
    private Connection connection;

    public DbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankTest", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void save(String username) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO USER (name) VALUE (?)");
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        PreparedStatement p = null;
        try {
            p = this.connection.prepareStatement("SELECT * FROM  user");
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String string = resultSet.getString(2);
//                User user = new User(id, string);
//                users.add(user);
                users.
                        add(new User(
                                resultSet.getInt(1),
                                resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void delete(int id) {
        try {
            PreparedStatement p = this.connection.
                    prepareStatement("DELETE FROM  user  where id =?");
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public User findOne(int id) {
        User user = null;
        PreparedStatement p = null;
        try {
            p = this.connection.prepareStatement("SELECT * FROM user  WHERE id=?");
            p.setInt(1, id );
            ResultSet resultSet = p.executeQuery();
            resultSet.next();
            user = new User(resultSet.getInt(1), resultSet.getString(2));
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void update(Integer id, String name) {
        PreparedStatement p = null;
        try {
            p = this.connection.prepareStatement("UPDATE USER SET NAME  =? WHERE id =?");
            p.setString(1, name);
            p.setInt(2, id);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
