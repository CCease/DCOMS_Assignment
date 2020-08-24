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
        return null;
    }

    @Override
    public Account findAccountById(String id) {
        return null;
    }

    @Override
    public Account findAccountByUsername(String username) {

        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT * FROM `users` WHERE `username` = ?";
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();

            if (rs.next()){
                String id = rs.getString("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String ic = rs.getString("ic");
                String password = rs.getString("password");

                DomainBuilder domainBuilder = new DomainBuilder();
                return domainBuilder.newAccount(id, first_name, last_name, password, username);
                //password = password, phonenumber = username

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

}
