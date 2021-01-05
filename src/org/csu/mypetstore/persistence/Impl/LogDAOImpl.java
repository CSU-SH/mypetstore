package org.csu.mypetstore.persistence.Impl;

import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.LogDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LogDAOImpl implements LogDAO {
    private static final String insertLogString = "INSERT INTO LOG (LOGUSERID, LOGINFO) VALUES (?, ?) ";

    public void insertLog(String username, String logIfo){
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection
                    .prepareStatement(insertLogString);
            pStatement.setString(1,username);
            pStatement.setString(2,logIfo);
            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
