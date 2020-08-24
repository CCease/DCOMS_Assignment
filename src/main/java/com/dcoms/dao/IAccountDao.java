package com.dcoms.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import com.dcoms.domain.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAllAccount();

    Account findAccountById(String id);

    Account findAccountByUsername(String username);

    Account findAccountByName(String firstName, String lastName);

    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);

}
