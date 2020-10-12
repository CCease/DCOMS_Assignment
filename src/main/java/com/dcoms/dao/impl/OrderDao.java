package com.dcoms.dao.impl;

import com.dcoms.client.customer.login.My_CNX;
import com.dcoms.dao.IOrderDao;
import com.dcoms.domain.Food;
import com.dcoms.domain.Order;
import com.dcoms.utils.DomainBuilder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

public class OrderDao implements IOrderDao {

    @Override
    public Order findOrderById(String id) {
        return null;
    }

    @Override
    public void addOrder(Order order) {
        PreparedStatement st;
        String orderFoodQuery = "INSERT INTO `order`(`userID`, `food`, `orderID`, `isTakeAway`, `isSuccess`) VALUES (?,?,?,?,?)";
        try {
            st = com.dcoms.client.customer.login.My_CNX.getConnection().prepareStatement(orderFoodQuery);
            st.setString(1, order.getCustomerID());
            st.setString(2, foodListToString(order.getFoods()));
            st.setString(3, order.getId());
            st.setString(4, String.valueOf(order.isTakeAway()));
            st.setString(5, String.valueOf(order.isSuccess()));
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> findOrderByCustomerId(String id) {
        
        List<Order> result = new ArrayList();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT * FROM `order` WHERE `userID` = ?";
        try{
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, id);
            rs = st.executeQuery();

            while (rs.next()){
                result.add(orderDataHandler(rs));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private String foodListToString(List<Food> foodList) {
        String result = "";
        for (int i = 0; i < foodList.size(); i++) {
            result = result + foodList.get(i).getId();
        }
        return result;
    }

    private List<Food> stringToFoodList(String foodstring) {
        List<String> foodListString = new ArrayList();
        DomainBuilder domainBuilder = new DomainBuilder();
        
        for (int i = 0; i < foodstring.length(); i++) {
            char c = foodstring.charAt(i);
            //Process char
            foodListString.add(String.valueOf(c));
        }
        
        List<Food> foodList = new ArrayList();

        for (int i = 0; i < foodListString.size(); i++) {
            foodList.add(domainBuilder.newFood(foodListString.get(i)));
        }
        
        return foodList;
    }
    
    private Order orderDataHandler(ResultSet rs){
        try{
            String id = rs.getString("orderID");
            List<Food> foodList = stringToFoodList(rs.getString("food"));
            boolean isSuccessString = Boolean.parseBoolean(rs.getString("isSuccess"));
            
            DomainBuilder domainBuilder = new DomainBuilder();
            return domainBuilder.newCompleteOrder(id, foodList, isSuccessString);
            
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
