package com.dcoms.service.impl;

import com.dcoms.dao.IAccountDao;
import com.dcoms.domain.Account;
import com.dcoms.service.IAccountService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class AccountService extends UnicastRemoteObject implements IAccountService {

    IAccountDao iAccountDao;

    public AccountService(IAccountDao iAccountDao) throws RemoteException {
        super();
        this.iAccountDao = iAccountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return iAccountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(String id) {
        return iAccountDao.findAccountById(id);
    }

    @Override
    public void addAccount(Account account) {
        iAccountDao.addAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        iAccountDao.updateAccount(account);
    }

    @Override
    public boolean checkAccountByName(String firstName, String lastName) {
        if (iAccountDao.findAccountByName(firstName, lastName) == null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void deleteAccount(Account account) {
        iAccountDao.deleteAccount(account);
    }

    @Override
    public boolean login(Account account) {
        if (account == iAccountDao.findAccountById(account.getId())){
            return true;
        }
        else{
            return false;
        }
    }
}
