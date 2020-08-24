# DCOMS_Assignment

1. Client havent implement RMI
2. DAO havent implement
3. Login logic need add user type verication
4. Implementation of Kitchen Logic (CLI Fastest way)
5. Implementation of Admin Logic


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
private String phoneNumber;
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
List<Account> findAllAccount();

Account findAccountById(String id);

boolean checkAccountByName(String fistName, String lastName);

void addAccount(Account account);

void updateAccount(Account account);

void deleteAccount(Account account);

boolean login(Account account);
```



## IFoodService

```
List<Food> findAllFood();

List<Food> findFoodByPriceRange(Double upperBound, Double lowerBound);

List<Food> findFoodByKeyword(String keyword);
```



 ## IOrderService

```
void orderComplete(Order order);

void cancelOrder(Order order);

Order findOrderById(String id);

List<Order> findOrderByCustomerId(String id);
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
