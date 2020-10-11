package com.dcoms.client.kitchen;

import com.dcoms.domain.Food;
import com.dcoms.domain.Order;
import com.dcoms.service.IKitchenService;
import com.dcoms.service.impl.KitchenService;
import com.dcoms.utils.DomainBuilder;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.dcoms.utils.UUIDGenerator.getUUID;

public class Kitchen {

    private static IKitchenService kitchenService;
    private static Scanner scanner;

    public static void main(String[] args) throws RemoteException {

        try{
            kitchenService = (IKitchenService) Naming.lookup("rmi://localhost:2003"+"/KitchenService");
        }catch (Exception e){
            e.printStackTrace();
        }

        scanner = new Scanner(System.in);

        addDummyData(kitchenService);
        addDummyData(kitchenService);
        addDummyData(kitchenService);
        addDummyData(kitchenService);
        addDummyData(kitchenService);
        addDummyData(kitchenService);
        System.out.println("=======Welcome to kitchen client.=======");

        //Password + Username Maybe

        while (true){
            System.out.println("============================");
            System.out.println("=======KITCHEN SYSTEM=======");
            System.out.println("============================");
            printOnGoingOrder(kitchenService.getOnGoingOrder());

            System.out.println("\nEnter <r> to refresh, <c> to complete an order , <q> to quit :");
            String input = scanner.next();
            System.out.println(input);

            if (input.equalsIgnoreCase("q")){
                break;
            }
            if (input.equalsIgnoreCase("c")){
                completeOrder();
            }
        }
        System.out.println("=======Program Shut Down=======");
        scanner.close();
    }

    private static void printOnGoingOrder(List<Order> OnGoingOrder){
        System.out.println("List of On Going Order.");
        for (int i = 0; i < OnGoingOrder.size() ; i++) {

            System.out.println("\nOrder " + i + " :");
            System.out.print(OnGoingOrder.get(i)+"\n");
        }
    }

    private static void completeOrder() throws RemoteException{

        printOnGoingOrder(kitchenService.getOnGoingOrder());
        System.out.println("\n=======Choose the number of the order that are completed.=======\n");
        System.out.println("Choose the order :");
        String input = scanner.next();

        if (input != null){
            try {
                if(!kitchenService.completeOrder(kitchenService.getOnGoingOrder().get(Integer.parseInt(input)))){
                    throw new RuntimeException("Error at server side. Order cannot be completed.");
                };
            }
            catch (Exception e){

            }
        }
        System.out.println("\n Order "+input+" has completed.\n");
    }

    private static void addDummyData(IKitchenService kitchenService) throws RemoteException{

        DomainBuilder domainBuilder = new DomainBuilder();
        List<Food> listOfFood = new ArrayList<>();

        Food food1 = new Food();
        Food food2 = new Food();
        Food food3 = new Food();

        listOfFood.add(food1);
        listOfFood.add(food2);
        listOfFood.add(food3);

        for (int i = 0; i < listOfFood.size(); i++) {
            Food temp = listOfFood.get(i);
            temp.setId(String.valueOf(i));
            listOfFood.set(i,temp);
        }

        Order order1 = domainBuilder.newOrder(getUUID(),listOfFood,getUUID());
        kitchenService.addOrder(order1);
    }
}
