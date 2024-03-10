import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DemoPizza extends JFrame {
    private final String QUIT = "QUIT";
    private ArrayList<String> toppingsList = new ArrayList<>();
    private JTextArea toppingsTextArea;

    public DemoPizza() {
        setTitle("Pizza Order");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel toppingsPanel = new JPanel();
        JLabel toppingsLabel = new JLabel("Enter toppings for the Pizza(up to 10):");
        toppingsTextArea = new JTextArea(5, 30);
        JScrollPane toppingsScrollPane = new JScrollPane(toppingsTextArea);
        JButton orderButton = new JButton("Place Order");
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });

        toppingsPanel.add(toppingsLabel);
        toppingsPanel.add(toppingsScrollPane);
        toppingsPanel.add(orderButton);

        getContentPane().add(toppingsPanel);
        setVisible(true);
    }

    private void placeOrder() {
        String[] toppings = toppingsList.toArray(new String[0]);
        int numToppings = toppingsList.size();

        String deliveryOption = JOptionPane.showInputDialog(null, "Do you want the Pizza to be delivered? (yes/no)");
        if (deliveryOption != null && deliveryOption.equalsIgnoreCase("yes")) {
            String deliveryAddress = JOptionPane.showInputDialog(null, "Enter delivery address:");
            DeliveryPizza deliveryPizza = new DeliveryPizza(toppings, numToppings, deliveryAddress);
            JOptionPane.showMessageDialog(null, deliveryPizza.toString(), "Pizza Order Details", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Pizza pizza = new Pizza(toppings, numToppings);
            JOptionPane.showMessageDialog(null, pizza.toString(), "Pizza Order Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new DemoPizza();
    }
}
