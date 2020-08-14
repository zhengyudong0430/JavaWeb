package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDao {
    public void add(Order order) {
        addOrderUser(order);
        addOrderDish(order);
    }

    private void addOrderUser(Order order) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into order_user values(null, ?, now(), 0)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
    }
    private void addOrderDish(Order order) {

    }
}
