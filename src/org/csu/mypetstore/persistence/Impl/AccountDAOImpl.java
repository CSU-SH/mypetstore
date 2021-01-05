package org.csu.mypetstore.persistence.Impl;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountDAO;
import org.csu.mypetstore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAOImpl implements AccountDAO {
    private static final String getAccountByUsernameString = "SELECT SIGNON.USERNAME, ACCOUNT.EMAIL, ACCOUNT.FIRSTNAME, ACCOUNT.LASTNAME," +
            " ACCOUNT.STATUS,  ACCOUNT.ADDR1 AS address1, ACCOUNT.ADDR2 AS address2, ACCOUNT.CITY, ACCOUNT.STATE, ACCOUNT.ZIP, ACCOUNT.COUNTRY," +
            " ACCOUNT.PHONE, PROFILE.LANGPREF AS languagePreference, PROFILE.FAVCATEGORY AS favouriteCategoryId, PROFILE.MYLISTOPT AS listOption," +
            " PROFILE.BANNEROPT AS bannerOption, BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ?" +
            " AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
    private static final String getAccountByUsernameAndPasswordString = "    SELECT SIGNON.USERNAME, ACCOUNT.EMAIL," +
            "ACCOUNT.FIRSTNAME, ACCOUNT.LASTNAME, ACCOUNT.STATUS,  ACCOUNT.ADDR1 AS address1, ACCOUNT.ADDR2 AS address2," +
            "ACCOUNT.CITY, ACCOUNT.STATE, ACCOUNT.ZIP, ACCOUNT.COUNTRY, ACCOUNT.PHONE, PROFILE.LANGPREF AS languagePreference," +
            "PROFILE.FAVCATEGORY AS favouriteCategoryId,  PROFILE.MYLISTOPT AS listOption,  PROFILE.BANNEROPT AS bannerOption," +
            "BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ? AND SIGNON.PASSWORD = ?" +
            "AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
    private static final String insertProfileString = "INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, MYLISTOPT, BANNEROPT, USERID) VALUES (?, ?, ?, ?, ?)";
    private static final String insertSignonString = "INSERT INTO SIGNON (PASSWORD,USERNAME) VALUES (?, ?)";
    private static final String insertAccountString = "INSERT INTO ACCOUNT (EMAIL, FIRSTNAME, LASTNAME, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE, USERID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String updateProfileString = "UPDATE PROFILE SET LANGPREF = ?, FAVCATEGORY = ? WHERE USERID = ?";
    private static final String updateSignonString = "UPDATE SIGNON SET PASSWORD = ? WHERE USERNAME = ?";
    private static final String updateAccountString = "UPDATE ACCOUNT SET FIRSTNAME = ?, LASTNAME = ?, STATUS = ?, ADDR1 = ?, ADDR2 =  ?, CITY = ?, STATE = ?, ZIP = ?, COUNTRY = ?, PHONE = ? WHERE USERID = ?";

    public Account getAccountByUsername(String username){
        Account account = null;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection
                    .prepareStatement(getAccountByUsernameString);
            pStatement.setString(1, username);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()){
                account = new Account();
                account.setUsername(resultSet.getString(1));
                account.setPassword(resultSet.getString(2));
                account.setFirstName(resultSet.getString(3));
                account.setLastName(resultSet.getString(4));
                account.setEmail(resultSet.getString(5));
                account.setPhone(resultSet.getString(6));
                account.setAddress1(resultSet.getString(7));
                account.setAddress2(resultSet.getString(8));
                account.setCity(resultSet.getString(9));
                account.setState(resultSet.getString(10));
                account.setZip(resultSet.getString(11));
                account.setCountry(resultSet.getString(12));
                account.setLanguagePreference(resultSet.getString(13));
                account.setFavouriteCategoryId(resultSet.getString(14));
                account.setListOption(resultSet.getBoolean(15));
                account.setBannerOption(resultSet.getBoolean(16));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return account;
    }

    public Account getAccountByUsernameAndPassword(Account account){
        Account account1 = null;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection
                    .prepareStatement(getAccountByUsernameAndPasswordString);
            pStatement.setString(1, account.getUsername());
            pStatement.setString(2, account.getPassword());
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()){
                account1 = new Account();
                account1.setUsername(resultSet.getString(1));
                account1.setPassword(resultSet.getString(2));
                account1.setFirstName(resultSet.getString(3));
                account1.setLastName(resultSet.getString(4));
                account1.setEmail(resultSet.getString(5));
                account1.setPhone(resultSet.getString(6));
                account1.setAddress1(resultSet.getString(7));
                account1.setAddress2(resultSet.getString(8));
                account1.setCity(resultSet.getString(9));
                account1.setState(resultSet.getString(10));
                account1.setZip(resultSet.getString(11));
                account1.setCountry(resultSet.getString(12));
                account1.setLanguagePreference(resultSet.getString(13));
                account1.setFavouriteCategoryId(resultSet.getString(14));
                account1.setListOption(resultSet.getBoolean(15));
                account1.setBannerOption(resultSet.getBoolean(16));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return account1;
    }

    public void insertAccount(Account account){
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection
                    .prepareStatement(insertAccountString);
            pStatement.setString(1, account.getEmail());
            pStatement.setString(2, account.getFirstName());
            pStatement.setString(3, account.getLastName());
            pStatement.setString(4, account.getAddress1());
            pStatement.setString(5, account.getAddress2());
            pStatement.setString(6, account.getCity());
            pStatement.setString(7, account.getState());
            pStatement.setString(8, account.getZip());
            pStatement.setString(9, account.getCountry());
            pStatement.setString(10, account.getPhone());
            pStatement.setString(11, account.getUsername());
            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertProfile(Account account){
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection
                    .prepareStatement(insertProfileString);
            pStatement.setString(1, account.getLanguagePreference());
            pStatement.setString(2, account.getFavouriteCategoryId());
            pStatement.setBoolean(3, account.isListOption());
            pStatement.setBoolean(4, account.isBannerOption());
            pStatement.setString(5, account.getUsername());
            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertSignon(Account account){
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection
                    .prepareStatement(insertSignonString);
            pStatement.setString(1, account.getPassword());
            pStatement.setString(2, account.getUsername());
            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account){
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection
                    .prepareStatement(updateAccountString);
            pStatement.setString(1, account.getFirstName());
            pStatement.setString(2, account.getLastName());
            pStatement.setString(3, account.getStatus());
            pStatement.setString(4, account.getAddress1());
            pStatement.setString(5, account.getAddress2());
            pStatement.setString(6, account.getCity());
            pStatement.setString(7, account.getState());
            pStatement.setString(8, account.getZip());
            pStatement.setString(9, account.getCountry());
            pStatement.setString(10, account.getPhone());
            pStatement.setString(11, account.getUsername());
            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateProfile(Account account){
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection
                    .prepareStatement(updateProfileString);
            pStatement.setString(1, account.getLanguagePreference());
            pStatement.setString(2, account.getFavouriteCategoryId());
            pStatement.setString(3, account.getUsername());
            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateSignon(Account account){
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection
                    .prepareStatement(updateSignonString);
            pStatement.setString(1, account.getPassword());
            pStatement.setString(2, account.getUsername());
            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
