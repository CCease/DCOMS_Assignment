package main.java.com.dcoms.service;

import main.java.com.dcoms.domain.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import main.java.com.dcoms.dao.IAccountDao;

public interface IAccountService extends Remote {

    List<Account> findAllAccount();
    
    public void setiAccountDao(IAccountDao iAccountDao)throws RemoteException;

    Account findAccountById(String id);

    boolean checkAccountByName(String fistName, String lastName);

    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);

    boolean login(Account account);

}
