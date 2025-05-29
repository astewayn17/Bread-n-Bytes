<h1 align="center">🥪 Welcome to the Bread 'n Bytes Sandwich Shop!</h1>

## 📋 Description
Bread 'n Bytes is a CLI-based application built in Java that simulates a point-of-sale system for a sandwich shop. Customers can create and fully customize their orders, choosing from various sandwich sizes, breads, toppings, drinks, and chips. Receipts are generated and saved for every order. The shop supports both custom and signature sandwich options, with an optional secret menu unlocked by a .
This application is meant to demonstrate various object-oriented programming (OOP) principles.
---
## 💻 Features
- 🏠 [Home Screen](#home-screen) - Start a new order & exit the application 
- 📋 [Order Menu](#order-menu) - Make a custom or signature sandwich; add drinks and chips; confirm or cancel order 
- 🥪 [Sandwich Building](#sandwich-building) - Choose bread, size, toast or not; add meat, cheese, regular toppings, sauces/sides
- 🥤 [Drinks](#drinks) - Choose size and from 12 different flavors
- 🥔 [Chips](#chips) - Choose from 9 brands
- 💵 [Checkout](#checkout) - Display complete order summary, confirm or cancel to save a receipt
- 🧾 [Receipt](#receipt) - Saves a separate receipt file every time an order is confirmed
- 🕵️ [Secret Menu](#secret-menu) - [Password](#password) locked and includes exclusive sandwiches

---

## 📁 File Structure
```
Bread-n-Bytes/
├── .idea/                         # IntelliJ project settings
├── Screenshots/                   # (Optional) Screenshots for documentation
├── src/                           
│   ├── main/
│   │   ├── java/
│   │   │   └── com.pluralsight/
│   │   │       ├── models/
│   │   │       │   ├── signatures/
│   │   │       │   │   └── secret/
│   │   │       │   │       ├── BLT.java
│   │   │       │   │       ├── PhillyCheeseSteakWrap.java
│   │   │       │   │       ├── TexMexWrap.java
│   │   │       │   │       └── VeggieCrunch.java
│   │   │       │   ├── Chips.java
│   │   │       │   ├── Drink.java
│   │   │       │   ├── Order.java
│   │   │       │   ├── Sandwich.java
│   │   │       │   ├── Topping.java
│   │   │       │   └── ToppingType.java
│   │   │       ├── userinterface/
│   │   │       │   └── UserInterface.java
│   │   │       ├── utilities/
│   │   │       │   └── ReceiptWriter.java
│   │   │       └── App.java
│   │   └── resources/
│   │       └── receipts/         # Receipt .txt files stored here
│   └── test/
│       └── java/                 # (Optional) Unit tests
├── target/                       # Compiled build output
├── .gitignore                    # Git ignore rules
├── class_diagram.png             # Class diagram image
├── pom.xml                       # Maven build configuration
└── README.md                     # Project documentation
```
View the [class diagram](#-class-diagram) for the code structure.

---

## 📸 Example Screens
### Home Screen
<div align="center">
  <table width="100%">
    <tr>
      <td align="center">
        <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/home_screen.png" width="420"/>
        <br/>
        <sub><i>Home Screen</i></sub>
      </td>
    </tr>
  </table>
</div>

### Order Menu
<div align="center">
  <table width="100%">
    <tr>
      <td align="center">
        <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/order_screen.png" width="420"/>
        <br/>
        <sub><i>Order Screen</i></sub>
      </td>
    </tr>
  </table>
</div>

### Sandwich Building
<table>
  <tr>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/add_sandwich.png" width="400"/><br/>
      <sub><i>Adding a Sandwich</i></sub>
    </td>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/bread_type.png" width="340"/><br/>
      <sub><i>Choosing Bread Type</i></sub>
    </td>
  </tr>
</table>

<table>
  <tr>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/sandwich_size.png" width="400"/><br/>
      <sub><i>Choosing Bread Size</i></sub>
    </td>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/add_meats.png" width="340"/><br/>
      <sub><i>Adding Meats</i></sub>
    </td>
  </tr>
</table>

<table>
  <tr>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/add_cheeses.png" width="400"/><br/>
      <sub><i>Adding Cheese</i></sub>
    </td>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/add_reg_toppings_and_toasted.png" width="340"/><br/>
      <sub><i>Adding Regular Toppings</i></sub>
    </td>
  </tr>
</table>

<table>
  <tr>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/add_cheeses.png" width="400"/><br/>
      <sub><i>Adding Sauces & Sides</i></sub>
    </td>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/add_reg_toppings_and_toasted.png" width="340"/><br/>
      <sub><i>Signature Sandwich Screen</i></sub>
    </td>
  </tr>
</table>

### Drinks
<table>
  <tr>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/add_drink.png" width="400"/><br/>
      <sub><i>Adding Drink Flavor</i></sub>
    </td>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/drink_size.png" width="340"/><br/>
      <sub><i>Adding Drink Size</i></sub>
    </td>
  </tr>
</table>

### Chips
<div align="center">
  <table width="100%">
    <tr>
      <td align="center">
        <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/add_chips.png" width="420"/>
        <br/>
        <sub><i>Adding Chips</i></sub>
      </td>
    </tr>
  </table>
</div>

### Checkout
<div align="center">
  <table width="100%">
    <tr>
      <td align="center">
        <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/order_summary_confirm.png" width="420"/>
        <br/>
        <sub><i>Viewing & Confirm Order Summary</i></sub>
      </td>
    </tr>
  </table>
</div>

### Receipt
<div align="center">
  <table width="100%">
    <tr>
      <td align="center">
        <img src="https://github.com/astewayn17/Bread-n-Bytes/blob/main/Screenshots/receipt.png" width="420"/>
        <br/>
        <sub><i>Receipt Example</i></sub>
      </td>
    </tr>
  </table>
</div>

### Secret Menu
<table>
  <tr>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/CarDealership/blob/main/screenshots/home_screen.png" width="400"/><br/>
      <sub><i>Home Screen</i></sub>
    </td>
    <td align="center" width="500">
      <img src="https://github.com/astewayn17/CarDealership/blob/main/screenshots/exit_the_app.png" width="340"/><br/>
      <sub><i>Exit Confirmation</i></sub>
    </td>
  </tr>
</table>

---

## 💡 Interesting Code

---

## 🧩 Class Diagram
```mermaid
classDiagram
    direction TB

    %% ========== Core Classes ==========
    class App {
        +main(String[] args)
    }

    class UserInterface {
        -Scanner scanner
        -Order currentOrder
        -boolean secretMenuUnlocked
        +run()
    }

    class ReceiptWriter {
        +saveReceipt(Order)
    }

    class Order {
        -String orderNumber
        -LocalDateTime orderDateTime
        -List~Sandwich~ sandwiches
        -List~Drink~ drinks
        -List~Chips~ chips
        +addSandwich(Sandwich)
        +addDrink(Drink)
        +addChips(Chips)
        +getOrderSummary()
        +getSubTotalPrice()
        +getTotalPrice()
        +cancel()
        +isEmpty()
    }

    class Sandwich {
        -int size
        -String breadType
        -boolean isToasted
        -boolean isSecret
        -List~Topping~ meats
        -List~Topping~ cheeses
        -List~Topping~ regularToppings
        -List~Topping~ sauces
        +addMeat(Topping)
        +addCheese(Topping)
        +addRegularTopping(Topping)
        +addSauce(Topping)
        +getMeatNCheesePrice()
        +getSummary()
    }

    class Topping {
        -String name
        -ToppingType type
        -Map~Integer, Double~ costPerSize
        -boolean isExtra
        +getName()
        +getPrice(int size)
        +isExtra()
        +getInstance(Topping, boolean)
    }

    class ToppingType {
        <<enumeration>>
        +MEAT
        +CHEESE
        +REGULAR
        +SAUCE
    }

    class Drink {
        -String size
        -String flavor
        -double price
        +getSummary()
        +getPrice()
    }

    class Chips {
        -String brand
        -double price
        +getSummary()
        +getPrice()
    }

    %% ========== Signature Sandwiches ==========
    class BLT
    class PhillyCheeseSteak
    class TexMexWrap
    class VeggieCrunch

    BLT --|> Sandwich
    PhillyCheeseSteak --|> Sandwich
    TexMexWrap --|> Sandwich
    VeggieCrunch --|> Sandwich

    %% ========== Secret Sandwiches ==========
    class Cheesequake
    class MOAS
    class TheButchersSecret

    Cheesequake --|> Sandwich
    MOAS --|> Sandwich
    TheButchersSecret --|> Sandwich

    %% ========== Relationships ==========
    App --> UserInterface
    UserInterface --> Order
    Order --> Sandwich
    Order --> Drink
    Order --> Chips
    Sandwich --> Topping
    Topping --> ToppingType
    ReceiptWriter --> Order
```

---
<span id="password"></span>

<p align="center"><em>Secret Menu Password: <code>iluvfood</code></em></p>

