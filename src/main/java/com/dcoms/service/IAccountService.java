package main.java.com.dcoms.service;

import main.java.com.dcoms.domain.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import main.java.com.dcoms.dao.IAccountDao;

public interface IAccountService extends Remote {

    List<Account> findAllAccount() throws RemoteException;
    
    public void setiAccountDao(IAccountDao iAccountDao) throws RemoteException;

    Account findAccountById(String id) throws RemoteException;

    boolean checkAccountByName(String fistName, String lastName) throws RemoteException;

    void addAccount(Account account) throws RemoteException;

    void updateAccount(Account account) throws RemoteException;

    void deleteAccount(Account account) throws RemoteException;

    boolean login(Account account) throws RemoteException;

}
