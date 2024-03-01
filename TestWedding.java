import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class TestWedding {
    public static void main(String[] args) {
        // Prompt user for data
        String brideFirstName = JOptionPane.showInputDialog("Enter bride's first name:");
        String brideLastName = JOptionPane.showInputDialog("Enter bride's last name:");
        String groomFirstName = JOptionPane.showInputDialog("Enter groom's first name:");
        String groomLastName = JOptionPane.showInputDialog("Enter groom's last name:");
        String weddingDateStr = JOptionPane.showInputDialog("Enter wedding date (YYYY-MM-DD):");
        String location = JOptionPane.showInputDialog("Enter wedding location:");

        // Create Person objects for bride and groom
        Person bride = new Person(brideFirstName, brideLastName);
        Person groom = new Person(groomFirstName, groomLastName);

        // Parse wedding date
        LocalDate weddingDate = LocalDate.parse(weddingDateStr);

        // Create Couple and Wedding objects
        Couple couple = new Couple(bride, groom);
        Wedding wedding = new Wedding(couple, weddingDate, location);

        // Display wedding details
        JOptionPane.showMessageDialog(null, "Wedding Details:\n" +
                "Bride: " + wedding.getCouple().getBride().getFirstName() + " " + wedding.getCouple().getBride().getLastName() + "\n" +
                "Groom: " + wedding.getCouple().getGroom().getFirstName() + " " + wedding.getCouple().getGroom().getLastName() + "\n" +
                "Date: " + wedding.getWeddingDate() + "\n" +
                "Location: " + wedding.getLocation());
    }
}