import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name, password and amount to create an account");
        //create user
        String name=sc.next();
        String password=sc.next();
        double amount=sc.nextDouble();
        SBIUser user=new SBIUser(name,amount,password);

        //add amount
        String message= user.addMoney(1000);
        System.out.println(message);

        //withdraw Money
        System.out.println("Enter amount u want to withdraw");
        int money=sc.nextInt();
        System.out.println("Enter your password");
        String pass=sc.next();
        System.out.println(user.withdrawMoney(money,pass));

        //rateOfInterest
        System.out.println("Enter years");
        int yrs= sc.nextInt();
        System.out.println(user.calculateInterest(yrs));
    }
}