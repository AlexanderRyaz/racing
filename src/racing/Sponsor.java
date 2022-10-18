package racing;

public class Sponsor {

    private final String name;

    private double amount;

    public Sponsor(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void sponsorRacing() {
        System.out.println(getName() + " спонсирует заезд на сумму " + getAmount());
    }

}
