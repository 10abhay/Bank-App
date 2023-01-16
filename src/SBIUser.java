import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface{
    private String name;
    private String accountNo;
    private double balanceNo;
    private String password;
    private double rateOfInterest;

    public SBIUser(String name, double balanceNo, String password) {
        this.name = name;
        this.balanceNo = balanceNo;
        this.password = password;
        // bank initialization
        this.rateOfInterest=6.5;
        this.accountNo=String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalanceNo() {
        return balanceNo;
    }

    public void setBalanceNo(double balanceNo) {
        this.balanceNo = balanceNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return balanceNo;
    }

    @Override
    public String addMoney(int amount) {
        balanceNo=balanceNo+amount;
        return "your balance is "+balanceNo;
    }

    @Override
    public String withdrawMoney(int amount, String pass) {
        if(Objects.equals(pass,password)){
            if(balanceNo>amount){
                balanceNo=balanceNo-amount;
                return "Current balance is"+balanceNo;
            }
            else{return "insufficient balance";}
        }
        else{return "Password is wrong";}

    }

    @Override
    public double calculateInterest(int years) {
        return (balanceNo*rateOfInterest*years)/100;
    }
}
