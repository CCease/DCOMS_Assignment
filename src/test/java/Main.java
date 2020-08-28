import com.dcoms.domain.Food;
import com.dcoms.domain.Order;
import com.dcoms.service.impl.KitchenService;
import com.dcoms.utils.DomainBuilder;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static com.dcoms.utils.UUIDGenerator.getUUID;

public class Main {

    public static void main(String[] args) throws RemoteException {
        kitchenServiceTest();
    }

    public static void kitchenServiceTest() throws RemoteException {
        //Testing of KitchenService.
        KitchenService kitchenService = new KitchenService();
        DomainBuilder domainBuilder = new DomainBuilder();
        List<Food> listOfFood = new ArrayList<>();

        Food food1 = new Food();
        Food food2 = new Food();
        Food food3 = new Food();
        Food food4 = new Food();
        Food food5 = new Food();

        listOfFood.add(food1);
        listOfFood.add(food2);
        listOfFood.add(food3);
        listOfFood.add(food4);
        listOfFood.add(food5);

        for (int i = 0; i < listOfFood.size(); i++) {
            Food temp = listOfFood.get(i);
            temp.setId(String.valueOf(i));
            listOfFood.set(i,temp);
        }

        Order order1 = domainBuilder.newOrder(getUUID(),listOfFood,"RandomCustomer1");


        List<Food> listOfFood2 = new ArrayList<>();

        for (int i = 0; i < listOfFood.size(); i++) {
            Food temp = new Food();
            temp.setId(listOfFood.get(i).getId()+5);
            listOfFood2.add(temp);
        }

        Order order2 = domainBuilder.newOrder(getUUID(),listOfFood2,"RandomCustomer2");

        System.out.println("Order 1:"+order1+"\n Order2:"+order2+"\n");
        kitchenService.addOrder(order1);
        kitchenService.addOrder(order2);
        System.out.println(kitchenService.getOnGoingOrder());
        System.out.println("\n Deleting order1.\n ");

        kitchenService.deleteOrder(order1);
        System.out.println(kitchenService.getOnGoingOrder());

        System.out.println("\n Get and delete Order2.\n ");
        System.out.println(kitchenService.completeOrder(order2));
        System.out.println("\n OnGoingOrder :" + kitchenService.getOnGoingOrder());
    }
}
