package com.dcoms.server;

import com.dcoms.dao.*;
import com.dcoms.dao.impl.*;
import com.dcoms.service.*;
import com.dcoms.service.impl.*;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {

    public static void main(String[] args) {
        try{
            IAccountService accountService = new AccountService();
            accountService.setiAccountDao(new AccountDao());
            LocateRegistry.createRegistry(2000);
            Naming.rebind("rmi://localhost:2000"+"/AccountService",accountService);

            IFoodService foodService = new FoodService();
            foodService.setIFoodDao(new FoodDao());
            LocateRegistry.createRegistry(2001);
            Naming.rebind("rmi://localhost:2001"+"/FoodService",foodService);

            IOrderService orderService = new OrderService();
            orderService.setIOrderDao(new OrderDao());
            LocateRegistry.createRegistry(2002);
            Naming.rebind("rmi://localhost:2002"+"/OrderService",orderService);

            IKitchenService kitchenService = new KitchenService();
            kitchenService.setiOrderService(orderService);
            LocateRegistry.createRegistry(2003);
            Naming.rebind("rmi://localhost:2003"+"/KitchenService",kitchenService);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
