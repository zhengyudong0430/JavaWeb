package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public void add(User user) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into user values (null,?,?,?)";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            statement.setInt(3,user.getIsAdmin());
            int ret = statement.executeUpdate();
            if(ret!=1) {
                throw new OrderSystemException("插入用户失败");
            }
            System.out.println("插入用户成功");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入用户失败");
        }
        finally {
            DBUtil.close(connection,statement,null);
        }
    }
    public User selectByName(String name) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            // 3. 执行 SQL
            resultSet = statement.executeQuery();
            // 4. 遍历结果集(按照名字查找, 只能查到一个记录, 要求名字不能重复)
            if (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按姓名查找用户失败");
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }
    public User selectById(int userId) throws OrderSystemException {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "select * from user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            // 3. 执行 SQL
            resultSet = statement.executeQuery();
            // 4. 遍历结果集, userId 是主键. 不会重复的. 最多只能查到一条记录
            if (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按 id 查找用户失败");
        } finally {
            // 5. 断开连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    public static void main(String[] args) throws OrderSystemException {
        UserDao userDao = new UserDao();
        /*User user = new User();
        user.setUserID(1);
        user.setName("郑");
        user.setPassword("123");
        user.setIsAdmin(1);
        userDao.add(user);*/
        System.out.println(userDao.selectById(1));

    }
}
