import java.util.ArrayList;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}

class ItemOrder {
    private Item item;
    private int quantity;
    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getOrderPrice() {
        return item.getPrice() * quantity;
    }
}
class ShoppingCart {
    private ArrayList < ItemOrder > orders;
    public ShoppingCart() {
        orders = new ArrayList <>();
    }

    public void addItemOrder(ItemOrder itemOrder) {
        orders.add(itemOrder);
    }
    public void removeItemOrder(ItemOrder itemOrder) {
        orders.remove(itemOrder);
    }
    public ItemOrder searchItemOrder(String itemName) {
        for (ItemOrder order : orders) {
            if (order.getItem().getName().equalsIgnoreCase(itemName)) {
                return order;
            }
        }
        return null;
    }
    public double getTotalPrice(){
        double totalPrice = 0.0;
        for (ItemOrder order : orders) {
            totalPrice += order.getOrderPrice();
        }
        return totalPrice;
    }
}

public class Main{
    public static void main(String[] args){
        Item tissues = new Item("Tissues", 3.0);
        Item apples = new Item("Apples", 1.5);

        ItemOrder order1 = new ItemOrder(tissues, 5);
        ItemOrder order2 = new ItemOrder(apples, 10);

        ShoppingCart cart = new ShoppingCart();

        cart.addItemOrder(order1);
        cart.addItemOrder(order2);

        System.out.println("Total Price: $" + cart.getTotalPrice());
    }
}