package com.dcoms.dao.impl;

import com.dcoms.domain.Account;
import com.dcoms.service.IAccountService;

import java.util.List;

public class AccountDao implements IAccountService {

    @Override
    public List<Account> findAllAccount() {
        return null;
    }

    @Override
    public Account findAccountById(String id) {
        return null;
    }

    @Override
    public boolean checkAccountByName(String fistName, String lastName) {
        return false;
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

    @Override
    public boolean login(Account account) {
        return false;
    }
}
