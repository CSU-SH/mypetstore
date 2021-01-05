package org.csu.mypetstore.persistence.Impl;

import org.csu.mypetstore.domain.LineItem;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.LineItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LineItemDAOImpl implements LineItemDAO {
    private static final String getLineItemsByOrderIdString = " SELECT ORDERID, LINENUM AS lineNumber, ITEMID, QUANTITY, UNITPRICE FROM LINEITEM WHERE ORDERID = ?";
    private static final String insertLineItemString = "INSERT INTO LINEITEM (ORDERID, LINENUM, ITEMID, QUANTITY, UNITPRICE) VALUES (?, ?, ?, ?, ?)";

    public List<LineItem> getLineItemsByOrderId(int orderId) throws Exception {
        List<LineItem> result = new ArrayList<LineItem>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection
                .prepareStatement(getLineItemsByOrderIdString);
        pStatement.setInt(1, orderId);
        ResultSet resultSet = pStatement.executeQuery(getLineItemsByOrderIdString);
        while (resultSet.next()){
            LineItem lineItem = new LineItem();
            lineItem.setOrderId(resultSet.getInt(1));
            lineItem.setLineNumber(resultSet.getInt(2));
            lineItem.setItemId(resultSet.getString(3));
            lineItem.setQuantity(resultSet.getInt(4));
            lineItem.setUnitPrice(resultSet.getBigDecimal(5));
            result.add(lineItem);
        }
        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedStatement(pStatement);
        DBUtil.closeConnection(connection);
        return result;
    }

    public void insertLineItem(LineItem lineItem) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection
                .prepareStatement(insertLineItemString);
        pStatement.setInt(1, lineItem.getOrderId());
        pStatement.setInt(2, lineItem.getLineNumber());
        pStatement.setString(3, lineItem.getItemId());
        pStatement.setInt(4, lineItem.getQuantity());
        pStatement.setBigDecimal(5, lineItem.getUnitPrice());
        pStatement.executeUpdate();
        DBUtil.closePreparedStatement(pStatement);
        DBUtil.closeConnection(connection);
    }
}
