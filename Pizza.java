import java.util.ArrayList;

class Pizza {
    private String[] toppings;
    protected double price;

    public Pizza(String[] toppings, int numToppings) {
        this.toppings = new String[numToppings];
        for (int i = 0; i < numToppings; i++) {
            this.toppings[i] = toppings[i];
        }
        this.price = 14 + 2 * numToppings;
    }
    public String toString() {
        return "Pizza with toppings: " + String.join(", ", toppings) + ", Price: $" + price;
    }
}
