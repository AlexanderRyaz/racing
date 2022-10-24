package racing;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return Double.compare(sponsor.amount, amount) == 0 && name.equals(sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }
}
