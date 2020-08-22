package main.java.com.dcoms.service.impl;

import main.java.com.dcoms.dao.IAccountDao;
import main.java.com.dcoms.domain.Account;
import main.java.com.dcoms.service.IAccountService;
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
        Account databaseAccount = iAccountDao.findAccountByUsername(account.getPhoneNumber());
        if (databaseAccount == null){
            return false;
        }
        if (account.getPassword() == databaseAccount.getPassword()){
            return true;
        }
        else{
            return false;
        }
    }
}
