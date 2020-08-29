# DCOMS_Assignment

**Tasks :**

1. Client haven't implement RMI
2. DAO haven't implement
3. Login logic need add user type verification
5. Implementation of Admin Client side.
5. **TESTING FOR ALL (Except login)**



Port : in com.dcoms.server.Main.java

Account Service

`Naming.rebind("rmi://localhost:2000"+"/AccountService",accountService);`

Food Service

`Naming.rebind("rmi://localhost:2001"+"/FoodService",foodService);`

Order Service

`Naming.rebind("rmi://localhost:2002"+"/OrderService",orderService);`

Kitchen Service

`Naming.rebind("rmi://localhost:2003"+"/KitchenService",kitchenService);`



## Package Introduction

- **com.dcoms.client** - store client side ui and logic.
- **com.dcoms.dao** - the file which execute the SQL statement,interacts with database and return data. ( For example. `public Account findAccountByUsername(String name)`) Account is a custom defined class.
- **com.dcoms.domain** - The class use to store data retrieve from database, for example Account, Food, Order.
- **com.dcoms.server** - servers side main function.
- **com.dcoms.service** - the class with use DAO class to accomplish business logic. (For example. login, uses dao find account by username and compare password then return result)
- **com.dcoms.utils** - utility, for example UUIDGenerator that use to generate UUID for new registered user.






# Domain

Object created to store data extract from database.

Getters and setters are defined for each field.

Constructor is **not defined**.

Creation of domain object use DomainBuilder.java in Utils package.

## Account  (phoneNumber need change to username)

```
private String id;
private String firstName;
private String lastName;
private String username;
private String password;
```



## Food

```
private String id;
private String name;
private Double price;
private String description;
private int minuteToPrepare;
```



## Order

```
private String id;
private List<Food> foods;
private long timeCreated;
private long timeResolved;
private String customerID;
private boolean isSuccess;
```



---





# DAO

Data Access Object. Direct access to database. 

**Haven't implement yet.**

## IAccountDao 

```
List<Account> findAllAccount();

Account findAccountById(String id);

Account findAccountByName(String firstName, String lastName);

void addAccount(Account account);

void updateAccount(Account account);

void deleteAccount(Account account);
```



## IFoodDao

```
List<Food> findAllFood();

Food findFoodById(Integer id);

List<Food> findFoodByPriceRange(Double upperBound, Double lowerBound);

List<Food> findFoodByKeyword(String keyword);
```



## IOrderDao

```
Order findOrderById(String id);

List<Order> findOrderByCustomerId(String id);

void addOrder(Order order);
```



---



# Service

The service use by client.

The class use by client to do things.

## IAccountService

```
List<Account> findAllAccount() throws RemoteException;
    
public void setiAccountDao(IAccountDao iAccountDao) throws RemoteException;

Account findAccountById(String id) throws RemoteException;

boolean checkAccountByName(String fistName, String lastName) throws RemoteException;

void addAccount(Account account) throws RemoteException;

void updateAccount(Account account) throws RemoteException;

void deleteAccount(Account account) throws RemoteException;

boolean login(Account account) throws RemoteException;
```



## IFoodService

```
    void setIFoodDao(IFoodDao iFoodDao) throws RemoteException;

    List<Food> findAllFood() throws RemoteException;

    List<Food> findFoodByPriceRange(Double upperBound, Double lowerBound) throws RemoteException;

    List<Food> findFoodByKeyword(String keyword) throws RemoteException;

    Food findFoodById(String id) throws RemoteException;

```



 ## IOrderService

```
    void setIOrderDao(IOrderDao iOrderDao) throws RemoteException ;

    void orderComplete(Order order) throws RemoteException;

    void cancelOrder(Order order) throws RemoteException ;

    Order findOrderById(String id) throws RemoteException ;

    List<Order> findOrderByCustomerId(String id) throws RemoteException ;
```


##IKitchenService

```

    void addOrder(Order order) throws RemoteException;

    void deleteOrder(Order order) throws RemoteException ;

    Order getAndDeleteOrder(Order order) throws RemoteException ;

    List<Order> getOnGoingOrder() throws RemoteException ;


```




# Utils

Utility thingy.

## DomainBuilder

Build object for domain objects. Because no constructor in domain object.

```
public Order newOrder(String id, List< Food > foods, String customerID)

public Account newAccount(String id, String firstname, String lastname)
```



## Kitchen

Simulate Kitchen Cooking.

CookFood invoke `Thread.Sleep` to simulate kitchen cooking

```
public void cookFood(Order order)

private int calculateCookingTime(List<Food> order)
```

## UUIDGenerator

Generate UUID.

```
public class UUIDGenerator {

    public static final String getUUID(){
        return UUID.randomUUID().toString();
    }
}
```
