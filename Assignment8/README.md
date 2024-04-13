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


