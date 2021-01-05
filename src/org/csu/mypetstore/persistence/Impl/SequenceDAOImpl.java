package org.csu.mypetstore.persistence.Impl;

import org.csu.mypetstore.domain.Sequence;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.SequenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SequenceDAOImpl implements SequenceDAO {
    private static final String getSequenceString = "SELECT name, nextid FROM SEQUENCE WHERE NAME = ?";
    private static final String updateSequenceString = "UPDATE SEQUENCE SET NEXTID = ? WHERE NAME = ?";

    public Sequence getSequence(Sequence sequence) throws Exception {
        Sequence sequence1 = null;
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection
                .prepareStatement(getSequenceString);
        pStatement.setString(1, sequence.getName());
        ResultSet resultSet = pStatement.executeQuery();
        while (resultSet.next()){
            sequence1 = new Sequence();
            sequence1.setName(resultSet.getString(1));
            sequence1.setNextId(resultSet.getInt(2));
        }
        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedStatement(pStatement);
        DBUtil.closeConnection(connection);
        return sequence1;
    }

    public void updateSequence(Sequence sequence) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection
                .prepareStatement(updateSequenceString);
        pStatement.setInt(1, sequence.getNextId());
        pStatement.setString(2, sequence.getName());
        pStatement.executeUpdate();
        DBUtil.closePreparedStatement(pStatement);
        DBUtil.closeConnection(connection);
    }
}
