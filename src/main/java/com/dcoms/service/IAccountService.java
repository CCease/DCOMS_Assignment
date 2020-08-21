package com.dcoms.service;

import com.dcoms.domain.Account;

import java.rmi.Remote;
import java.util.List;

public interface IAccountService extends Remote {

    List<Account> findAllAccount();

    Account findAccountById(String id);

    boolean checkAccountByName(String fistName, String lastName);

    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);

    boolean login(Account account);

}
