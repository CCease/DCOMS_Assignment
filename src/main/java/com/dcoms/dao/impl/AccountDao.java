package com.dcoms.dao.impl;

import com.dcoms.client.customer.login.My_CNX;
import com.dcoms.dao.IAccountDao;
import com.dcoms.domain.Account;
import com.dcoms.utils.DomainBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

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

    @Override
    public void addAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Account account) {

    }

    private Account accountDataHandler(ResultSet resultSet){
        try{
            //String id = resultSet.getString("id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String ic = resultSet.getString("ic");
            String password = resultSet.getString("password");
            String username = resultSet.getString("username"); //TODO: Check if this correct. Sync with databse design.

            DomainBuilder domainBuilder = new DomainBuilder();
            return domainBuilder.newAccount(ic, first_name, last_name, password, username);
            //password = password, phonenumber = username
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
