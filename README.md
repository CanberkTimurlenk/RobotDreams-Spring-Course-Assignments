The repository includes the completed assignments in the Java & Spring Framework Course (February 14 - April 17 2024) provided by RobotDreams.


<h2> Assignment 2 </h2>

<h3> Task </h3>
We have designed a university organizational structure in code during the lecture. Introduce new methods through interfaces and create a new UML diagram to reflect the latest additions.

<hr>

<h3> Solution </h3>

The Example folder contains the classes and interfaces present in the UML diagram.


<img width="1000" height="600" alt="Assignment2-UML" src="https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignments/assets/18058846/c67b381b-2947-4b67-a598-db5fd432daca">


<br>
<br>

<h2> Assignment 3 </h2>

<h3> Task </h3>

Consider an online store that uses a database to store its products. The columns of the database are specified as follows in the code below

```java
private String name;
private String category;
private String photoUrl;
private String description;
private Double price;
```

Write code for an API that be able to list all products of the store by category. NOTE: The API you will create should take "category" as a parameter, and JDBC Template should be used to filter products by category (using the WHERE clause).

<hr>

<h3> Solution Notes </h3>

If the query string is proven, the api delivers the products based on the given category, otherwise (If the request does not include the query string for categoryName) The api delivers all of the products.

<img width="1200" height="600" alt="Assignment3" src="https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment3/assets/18058846/fd40dd00-52b8-4bd9-9c3a-fca5229f8b6c">

<br>
<br>

<h2> Assignment 4 </h2>

<h3> Task </h3>

* Create an API to enable the creation of a new product entry. This API should accept product details, which are provided in the previous task. Use Hibernate to persist the incoming data. 
After the registration process, return a message to the customer like "The operation has been completed."
* Implement a layered architecture. 


<hr>

<h3> Solution Notes </h3>


An example Post Request to create a resource
<img width="1300" height="500" alt="Assignment4-PostRequest" src="https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment4/assets/18058846/136ef7b7-5116-4aca-903c-c74e6b8dabe5">


An example Get Request after the previous post request
<img width="1200" height="600" alt="Assignment4-FinalGetRequest" src="https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment4/assets/18058846/11397acd-840f-40bd-a183-0a7c0715f89b">

<br>
<br>

<h2> Assignment 5</h2>

<h3> Task </h3>

Specify the fetch strategy for the product and order entities you created. Write an API to create a common entity for order and product and establish this relationship. Allow users to create a product using the product API. Then, through the order API, create an order associated with this product.

<hr>

<h3> Solution Notes </h3>


<h4>Requests</h4>
<br>

Save a product
<img width="964" alt="ProductSave" src="https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment5/assets/18058846/7ce1f134-56f5-463b-b9b9-8beacd77ac79">

Save an order
<img width="969" alt="OrderCreated" src="https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment5/assets/18058846/255ea29c-99b8-48da-8e82-140ddcddcc6e">

<br>
<hr>
<br>

<h4>Table Content</h4>
<br>

Product Table <br>
<img width="542" alt="ProductsTable" src="https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment5/assets/18058846/700cc438-f80d-4030-bef0-d157215ca9af">

Order Table <br>
<img width="424" alt="OrdersTable" src="https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment5/assets/18058846/6b703979-9e84-4320-92e1-631ca29da2c8">

OrderProducts Table <br>
<img width="435" alt="OrderProductsTable" src="https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment5/assets/18058846/6282c96d-4551-400a-9070-870d80b92353">


<br>
<br>

<h2> Assignment 6</h2>

<h3> Task </h3>

Using the Spring Framework, implement cascade operations in the product, order, and orderproduct entities where the relationships exist. For example, if there is an order record and it has a relationship with a product, when the order is deleted, the related entity should also be deleted. Implement this scenario using cascade.

<hr>

<h3> Solution Notes </h3>

Examples were created using 'CascadeType.REMOVE' and 'CascadeType.PERSIST' to demonstrate the impact of the cascade type on entities.

<br>
  
<h2>CascadeType.PERSIST</h2>

I have created a new entity named "ProductDetail" with a OneToOne relationship with the "Product" entity. 

When saving a Product through a POST request, the ProductDetail information will also be provided in the request body. Since the Cascade type is set to persist, the ProductDetail entity will be saved to the database along with its one-to-one relation.

``Product.java``

```java
@Table(name = "Products")
@Entity
public class Product extends BaseEntity implements Serializable {

    // codes here...

    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ProductDetail productDetail;

    // codes here...
```

<br>

![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment6/assets/18058846/18df1bc5-7f07-4c4b-be24-9517118925af)

<br>

Product Table
![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment6/assets/18058846/0dee6754-dee2-483a-9d83-89440d394684)

<br>

ProductDetail Table
![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment6/assets/18058846/9967450e-a70e-48ca-9e6a-c7220f7c44f6)

<br>
<hr>
<br>

<h2>CascadeType.REMOVE</h2>

When an order is deleted, the related orderProducts must also be deleted.


``Order.java``
```java
@Table(name = "Orders")
@Entity
public class Order extends BaseEntity implements Serializable {

    //codes here

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<OrderProduct> orderProducts;

    //codes here

```

<br>

Post an order
![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment6/assets/18058846/667fddaa-6496-41a6-a9f0-e0c7671b38ea)

<br>

Orders Table <br>
![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment6/assets/18058846/eb5bf637-e0f6-4ded-a3da-451e33e5367f)

<br>

OrderProducts Table <br>

![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment6/assets/18058846/42999fc4-d8bc-4809-a155-1c916d1d4bea)

<br> 

Delete request to delete created Order <br>
![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment6/assets/18058846/93341d79-bb83-4152-a3f2-68cb057c94e8)


<br>

Orders Table <br>
![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment6/assets/18058846/28c2ffb2-7c41-4fcf-938d-f21a546f9a25)

<br>

OrderProducts Table <br>
![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment6/assets/18058846/da0a1fce-e728-4035-88be-a80597beb982)

<br>
<br>

<h2> Assignment 7</h2>

<h3> Task </h3>

When a user places an order in the application, the user should receive a notification via SMS. The SMS service sends information about the order and operates asynchronously.

<hr>

<h3> Solution Notes </h3>

* package ``customFunctions`` includes the smsFunction which is a functional interface

``SmsService`` includes the method ``sendSms`` which runs asynchronously

* package ``util`` includes the class ``UtilTest`` to used persist test data


<br>
<br>

<h2> Assignment 8</h2>

<h3> Task </h3>

Implement exception handling in the order and product services where you deem necessary. Create your own exceptions and handle them accordingly.

<hr>

<h3> Solution Notes </h3>

<h2>InsufficentOrderAmountException</h2>

<br>
<br>

1- A post request was sent to create product with price "1"
![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment8/assets/18058846/650217da-326c-489a-b167-9769b82b85e5)

<br>
<br>

2- A post request was sent to create an order with a product which was created in previous step
![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment8/assets/18058846/e878afb6-3fde-41bf-8701-b562bfac4eb1)


Observed Console Output

![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment8/assets/18058846/1aef7b16-8f84-4d38-a343-1403b7a717e5)


```java
private void checkIfOrderAmountIsSufficent(List<Product> products)
        throws InsufficientOrderAmountException{

        double minOrderAmount = 50.0;

        var total = products.stream()
                    .map(Product::getPrice)
                    .reduce(0.0,Double::sum);

        if(minOrderAmount > total)
            throw new InsufficientOrderAmountException(total);

    }
```


try-catch block
```java
    try {
            checkIfOrderAmountIsSufficent(products);
        } catch (InsufficientOrderAmountException e) {
            System.out.println("Logged !");
            throw new GeneralException("The order amount is insufficient ");
        }
```

<hr>
<br>

<h2>InvalidPriceException</h2>

1- A post request was sent to create product with a price "-100"

![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment8/assets/18058846/49e480e8-bb3e-4a8a-ab14-f1fa006f9ad3)


Observed Console Output

![resim](https://github.com/CanberkTimurlenk/RobotDreams-Spring-Course-Assignment8/assets/18058846/2b3262b1-c881-48c1-97a3-2d0f851f1a87)


```java
private void checkIfPriceIsValid(double price)
            throws InvalidPriceException {

        if(price <= 0.0)
            throw new InvalidPriceException("The price must be greater than 0. The input was: " + price);
    }
```


try-catch block

```java
        try {
            checkIfPriceIsValid(createProductRequestDto.getPrice());
        } catch (InvalidPriceException e) {
            System.out.println("Logged!");
            throw new GeneralException("Invalid price");
        }
```

<br>
<br>

<h2> Assignment 9</h2>

<h3> Task </h3>

Write a unit tests for one of the methods in the service layer of the existing structure, either for order creation or for product APIs.

<hr>

<h3> Solution Notes </h3>
The unit tests existed in 

``
OrderServiceUnitTests.java
``

<br>
<br>

<h2> Assignment 10</h2>

<h3> Task </h3>

In the existing project, use Lombok annotations appropriately. Implement the calculation of shipping fees when creating an order. You can apply the Strategy design pattern for this task. Similarly, create an API where users can modify their own user information. After changes are made to an existing user, implement a feature to send an SMS to the user.

When sending the SMS, provide two different options for companies. If the user is premium, use a different SMS provider. You can use the Strategy pattern for this structure.

NOTE: There are two tasks in this assignment, and completing one is sufficient. You can choose to either implement the shipping fee calculation or the user SMS sending feature.
<hr>

<h3> Solution Notes </h3>

Both Sms and Shipping features are completed. They locates in package
``
sms
``
and ``shipping``

<br>
<br>

<h2> Assignment 11</h2>

<h3> Task </h3>

Dockerize the developed java application.

<hr>

<h3> Solution Notes </h3>

Docker Image <br>
https://hub.docker.com/repository/docker/canberkt/assignment11-rd/general





