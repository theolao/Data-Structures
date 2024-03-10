class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;

    public DeliveryPizza(String[] toppings, int numToppings, String deliveryAddress) {
        super(toppings, numToppings);
        this.deliveryAddress = deliveryAddress;
        if (price > 18) {
            this.deliveryFee = 3;
        } else {
            this.deliveryFee = 5;
        }
    }
    public String toString() {
        return super.toString() + ", Delivery fee: $" + deliveryFee + ", Delivery address: " + deliveryAddress;
    }
}
