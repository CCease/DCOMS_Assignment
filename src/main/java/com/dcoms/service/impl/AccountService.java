package com.dcoms.service.impl;

import com.dcoms.dao.IAccountDao;
import com.dcoms.domain.Account;
import com.dcoms.service.IAccountService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class AccountService extends UnicastRemoteObject implements IAccountService {
    
    public AccountService()throws RemoteException{
        super();
    }

    IAccountDao iAccountDao;
    
    @Override
    public void setiAccountDao(IAccountDao iAccountDao)throws RemoteException{      
        this.iAccountDao = iAccountDao;
    }

    @Override
    public List<Account> findAllAccount() throws RemoteException{
        return iAccountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(String id) throws RemoteException {
        return iAccountDao.findAccountById(id);
    }

    @Override
    public void addAccount(Account account) throws RemoteException {
        iAccountDao.addAccount(account);
    }

    @Override
    public void updateAccount(Account account) throws RemoteException {
        iAccountDao.updateAccount(account);
    }

    @Override
    public boolean checkAccountByName(String firstName, String lastName) throws RemoteException {
        if (iAccountDao.findAccountByName(firstName, lastName) == null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void deleteAccount(Account account) throws RemoteException {
        iAccountDao.deleteAccount(account);
    }

    @Override
    public boolean login(Account account) throws RemoteException {
        Account databaseAccount = iAccountDao.findAccountByUsername(account.getUsername());
        System.out.println(databaseAccount);
        System.out.println(account.getPassword());
        System.out.println(databaseAccount.getPassword());
        System.out.println(account.getPassword().equals(databaseAccount.getPassword()));
        if (databaseAccount == null){
            return false;
        }
        if (account.getPassword().equals(databaseAccount.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }
    
    //0 means login fail, 1 means user is customer, 2 means customer is admin.
    @Override
    public int newLogin(Account account) throws RemoteException {
        Account databaseAccount = iAccountDao.findAccountByUsername(account.getUsername());
        System.out.println(databaseAccount);
        System.out.println(account.getPassword());
        System.out.println(databaseAccount.getPassword());
        System.out.println(account.getPassword().equals(databaseAccount.getPassword()));
        if (databaseAccount == null){
            return 0;
        }
        if (account.getPassword().equals(databaseAccount.getPassword())){
            return iAccountDao.findAccountTypeByUsername(account.getUsername());
        }
        else{
            return 0;
        }
    }
}
