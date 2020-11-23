package com.dcoms.utils;

import com.dcoms.domain.Account;
import com.dcoms.domain.Food;
import com.dcoms.domain.Order;

import java.util.List;

public class DomainBuilder {


    public Order newOrder(List< Food > foods, String customerID) {

        Order order = new Order();

        order.setId(UUIDGenerator.getUUID());
        order.setFoods(foods);
        order.setTimeCreated(System.currentTimeMillis());
        order.setCustomerID(customerID);

        return order;
    } 
    
    public Order newCompleteOrder(String OrderID, List<Food> foodList, boolean isSuccess){
        Order order = new Order();
        order.setId(OrderID);
        order.setFoods(foodList);        
        order.setSuccess(isSuccess);
        return order;
    }

    public Account newAccount(String id, String firstname, String lastname, String ic, String password, String username){

        Account account = new Account();
        account.setId(id);
        account.setFirstName(firstname);
        account.setLastName(lastname);
        account.setIc(ic);
        account.setPassword(password);
        account.setUsername(username);

        return account;
    }
    
    public Food newFood(String id){
    
        if (id.equals("1")) {
            Food food= new Food();
            food.setId("1");
            food.setName("Salad");
            food.setPrice(Double.NaN);
            food.setDescription("Good choice for vege and fruit lovers!");
            return food;
        }
        if (id.equals("2")) {
            Food food= new Food();
            food.setId("2");
            food.setName("Japanese Noodles");
            food.setPrice(Double.NaN);
            food.setDescription("Noodles with a Japanese flavor!");
            return food;
        }
        if (id.equals("3") ){
            Food food= new Food();
            food.setId("3");
            food.setName("Spaghetti");
            food.setPrice(Double.NaN);
            food.setDescription("Spaghetti with your favourite tomato sauce");
            return food;
        }
        if (id.equals("4")) {
            Food food= new Food();
            food.setId("4");
            food.setName("Macaroni");
            food.setPrice(Double.NaN);
            food.setDescription("Kids' favourite food!");
            return food;
        }
        if (id.equals("5")) {
            Food food= new Food();
            food.setId("5");
            food.setName("Ramen Noodles");
            food.setPrice(Double.NaN);
            food.setDescription("Yummy and elastic noodles");
            return food;
        }
        if (id.equals("6")) {
            Food food= new Food();
            food.setId("6");
            food.setName("Chicken Rice");
            food.setPrice(Double.NaN);
            food.setDescription("Ipoh Traditional Chicken Rice");
            return food;
        }
        return null;
    }
}
