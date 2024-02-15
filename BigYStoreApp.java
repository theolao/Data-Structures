package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BigYStoreApp extends JFrame {
    private JComboBox<String> pizzaComboBox;
    private JComboBox<String> sizeComboBox;
    private JCheckBox[] toppingsCheckBoxes;
    private JButton calculateButton;
    private JLabel totalPriceLabel;

    private String[] pizzaOptions = {"Pepperoni", "Cheese", "Vegetarian", "Hawaiian", "Meat Lovers"};
    private String[] sizeOptions = {"Small ($5)", "Medium ($10)", "Large ($15)", "Super ($20)"};
    private String[] toppingOptions = {"Extra Cheese", "Pepperoni", "Mushrooms", "Peppers", "Onions", "Bacon"};

    public BigYStoreApp() {
        setTitle("BigY Store Pizza Order");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Pizza selection
        JPanel pizzaPanel = new JPanel();
        pizzaPanel.add(new JLabel("Select Pizza:"));
        pizzaComboBox = new JComboBox<>(pizzaOptions);
        pizzaPanel.add(pizzaComboBox);
        add(pizzaPanel);

        // Size selection
        JPanel sizePanel = new JPanel();
        sizePanel.add(new JLabel("Select Size:"));
        sizeComboBox = new JComboBox<>(sizeOptions);
        sizePanel.add(sizeComboBox);
        add(sizePanel);

        // Toppings selection
        JPanel toppingsPanel = new JPanel();
        toppingsPanel.add(new JLabel("Select Toppings (Max 3):"));
        toppingsCheckBoxes = new JCheckBox[toppingOptions.length];
        for (int i = 0; i < toppingOptions.length; i++) {
            toppingsCheckBoxes[i] = new JCheckBox(toppingOptions[i]);
            toppingsPanel.add(toppingsCheckBoxes[i]);
        }
        add(toppingsPanel);

        // Calculate button
        calculateButton = new JButton("Calculate Total");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotalPrice();
            }
        });
        add(calculateButton);

        // Total price label
        totalPriceLabel = new JLabel("Total Price: ");
        add(totalPriceLabel);

        setVisible(true);
    }

    private void calculateTotalPrice() {
        double basePrice = getSizePrice();
        double toppingPrice = getToppingsPrice();
        double totalPrice = basePrice + toppingPrice;
        totalPriceLabel.setText("Total Price: $" + String.format("%.2f", totalPrice));
    }

    private double getSizePrice() {
        String selectedSize = (String) sizeComboBox.getSelectedItem();
        switch (selectedSize) {
            case "Small ($5)":
                return 5.0;
            case "Medium ($10)":
                return 10.0;
            case "Large ($15)":
                return 15.0;
            case "Super ($20)":
                return 20.0;
            default:
                return 0.0;
        }
    }

    private double getToppingsPrice() {
        int selectedToppings = 0;
        for (JCheckBox checkBox : toppingsCheckBoxes) {
            if (checkBox.isSelected()) {
                selectedToppings++;
            }
        }

        double toppingPrice;
        if (selectedToppings <= 1) {
            toppingPrice = selectedToppings * 0.50;
        } else if (selectedToppings == 2) {
            toppingPrice = 1.0;
        } else {
            toppingPrice = 1.25;
        }

        return toppingPrice;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BigYStoreApp();
            }
        });
    }
}