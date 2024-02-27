import java.util.Scanner;

public class BadSubscriptCaught {
    public static void main(String[] args) {
        String[] firstNames = {
                "Theo", "kendall", "Sydney", "Jo", "Elsa",
                "Emelie", "Imani", "Azra", "Patrick", "Xavier"
        };
        Scanner sc = new Scanner(System.in);
        do{
            try{
                System.out.println("Enter an index for your first name from 0 to 9");
                int index = sc.nextInt();
                System.out.println("First name at index" + index + ": " + firstNames[index]);
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Error: Index out of bound. Please enter a valid index: ");
            }
        } while (true);

    }
}