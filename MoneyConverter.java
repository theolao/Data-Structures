import java.util.Scanner;
public class MoneyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\uD83C\uDF08 Welcome! Enter the total amount of money in dollars and cents");
        String totalMoney = sc.nextLine().substring(1,4);
        float moneyDouble = Float.parseFloat(totalMoney) * 100;
        int moneyInCents = Math.round(moneyDouble);
        int quarter = moneyInCents / 25;
        int quarter_1 = moneyInCents % 25;
        int dime = quarter_1 / 10;
        int dime_1 = quarter_1 % 10;
        int nickel = dime_1 / 5;
        System.out.println("\uD83D\uDCB0 Quarters: " + quarter);
        System.out.println("\uD83D\uDCB0 Dimes: " + dime);
        System.out.println("\uD83D\uDCB0 Nickels: " + nickel);
        System.out.println("\n Thank you, have a nice day! \uD83C\uDF1F");
        }
    }