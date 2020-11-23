package com.dcoms.dao.impl;

import com.dcoms.client.customer.login.My_CNX;
import com.dcoms.dao.IAccountDao;
import com.dcoms.domain.Account;
import com.dcoms.utils.DomainBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AccountDao implements IAccountDao {

    @Override
    public List<Account> findAllAccount() {

        List<Account> accountList = null;
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT * FROM `users`";
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            rs = st.executeQuery();

            while (rs.next()){
                accountList.add(accountDataHandler(rs));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public Account findAccountById(String id) {//TODO: Add check if multiple account found.

        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT * FROM `users` WHERE `id` = ?";
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, id);
            rs = st.executeQuery();

            if (rs.next()){
                return accountDataHandler(rs);
            }else{
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findAccountByUsername(String username) {//TODO: Add check if multiple account found.

        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT * FROM `users` WHERE `username` = ?";
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            if (rs.next()){
                return accountDataHandler(rs);
            }else{
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findAccountByName(String firstName, String lastName) {

        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT * FROM `users` WHERE `first_name` = ? AND `last_name` = ? ";
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, firstName);
            st.setString(2, lastName);
            rs = st.executeQuery();

            if (rs.next()){
                return accountDataHandler(rs);
            }else{
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    //Customer is 2, Admin is 1.
    @Override
    public int findAccountTypeByUsername(String username) {
      
        PreparedStatement st;
        ResultSet rs;
        String userType = "";
        String query = "SELECT * FROM `users` WHERE `username` = ?";
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            
            if (rs.next()){
                userType = rs.getString("user_type");
            }else{
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(userType.equals("Customer")){
          return 2;
        }
        if(userType.equals("Admin")){
          return 1;
        }
        return 0;
    }

    @Override
    public void addAccount(Account account) {
           
    }

    @Override
    public void updateAccount(Account account) {
        String firstName = account.getFirstName();
        String lastName = account.getLastName();
        String ic = account.getIc();
        String username = account.getUsername();
        String password = account.getPassword();
        System.out.println("Update Success !!!!!!!");
        PreparedStatement st; 
        /*String updateQuery = "UPDATE users SET `firstName` ="+account.getFirstName()+
                ", `lastName` =" +account.getLastName()+
                ", `ic` =" +account.getIc()+ 
                ", `username` =" +account.getUsername()+ 
                ", `password` =" +account.getPassword()+ 
                "WHERE `userID` ="+account.getId();*/
        String updateQuery = "UPDATE `users` SET `first_name` =?, `last_name` =?, `ic` =?, `username` =?, `password` =? WHERE `userID` ="+account.getId();
   
        try {
            st = My_CNX.getConnection().prepareStatement(updateQuery);
            st.setString(1, firstName);
            st.setString(2, lastName);
            st.setString(3, ic);
            st.setString(4, username);
            st.setString(5, password);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void deleteAccount(Account account) {
        System.out.println("Delete Success !!!!!!!");
        PreparedStatement st; 
        String deleteQuery = "DELETE FROM `users` WHERE `userID` ="+account.getId();
        try {
            st = My_CNX.getConnection().prepareStatement(deleteQuery);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Account accountDataHandler(ResultSet resultSet){
        try{
            String id = resultSet.getString("userID");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String ic = resultSet.getString("ic");
            String password = resultSet.getString("password");
            String username = resultSet.getString("username"); 

            DomainBuilder domainBuilder = new DomainBuilder();
            return domainBuilder.newAccount(id, first_name, last_name, ic, password, username);
            
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
