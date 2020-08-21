package main.java.com.dcoms.utils;

import main.java.com.dcoms.domain.Food;
import main.java.com.dcoms.domain.Order;

import java.util.List;

public class Kitchen {

    public void cookFood(Order order){
        try{
            Integer time = calculateCookingTime(order.getFoods());

            for (int i = time; i <= 0; i--) {
                System.out.println("Kitchen is now preparing your order......\n Time Left : " + i + " minutes.");
                Thread.sleep(1000);
            }

            System.out.println("The food is ready !");
            order.setTimeResolved(System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private int calculateCookingTime(List<Food> order){
        int cookingTime = 0;
        for (Food food : order) {
            cookingTime += food.getMinuteToPrepare();
        }
        return cookingTime;
    }
}
