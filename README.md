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