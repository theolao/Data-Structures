import java.util.Scanner;
public class ArrayLab{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = new double[20];
        System.out.println("Enter up to 20 double values");

        int count = 0;
        while (count < 20 && scanner.hasNextDouble()) {
            System.out.println("Entered values" + (count + 1) + ": ");
            values[count] = scanner.nextDouble();
            count++;
        }
//        System.out.println("Entered values" + (count + 1) + ": ");
        for (int i = 0; i < count; i++) {
            System.out.println(values[i]);
        }
    }

}