package main.java.com.dcoms.utils;

import main.java.com.dcoms.domain.Account;
import main.java.com.dcoms.domain.Food;
import main.java.com.dcoms.domain.Order;

import java.util.List;

public class DomainBuilder {


    public Order newOrder(String id, List< Food > foods, String customerID) {

        Order order = new Order();

        order.setId(UUIDGenerator.getUUID());
        order.setFoods(foods);
        order.setTimeCreated(System.currentTimeMillis());
        order.setCustomerID(customerID);

        return order;
    }

    public Account newAccount(String id, String firstname, String lastname, String password, String phoneNumber){

        Account account = new Account();
        account.setId(id);
        account.setFirstName(firstname);
        account.setLastName(lastname);
        account.setPassword(password);
        account.setPhoneNumber(phoneNumber);

        return account;
    }
}
