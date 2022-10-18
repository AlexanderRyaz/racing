package racing.transport;

import racing.Competing;
import racing.util.CarCategory;
import racing.util.TransportType;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.round;

public class Car extends Transport implements Competing {

    private static final TransportType TRANSPORT_TYPE = TransportType.CAR;
    private final CarCategory category;

    public Car(String brand, String model, double engineVolume, CarCategory carCategory) {
        super(brand, model, engineVolume);
        this.category = carCategory;
    }

    public CarCategory getCategory() {
        return category;
    }

    @Override
    public TransportType getTransportType(){
        return TRANSPORT_TYPE;
    }

    @Override
    public void startDrive() {
        System.out.println(getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void stopDrive() {
        System.out.println(getBrand() + " " + getModel() + " закончил движение");
    }

    @Override
    public boolean diagnostic() {
        return ThreadLocalRandom.current().nextInt() % 2 == 0;
    }

    @Override
    public void pitStop() {
        System.out.println(getBrand() + " " + getModel() + " заправлен, ипоменяли резину");
    }

    @Override
    public String bestTime() {
        int minutes = ThreadLocalRandom.current().nextInt(0, 5);
        int seconds = ThreadLocalRandom.current().nextInt(0, 60);
        return "Лучшее время круга: " + minutes + ":" + seconds;
    }

    @Override
    public double maxSpeed() {
        return round(ThreadLocalRandom.current().nextDouble(180, 250));
    }

    @Override
    public String toString() {
        return "Легковой автомобиль ("
               + super.toString()
               +  "категория: " + category + ")";
    }

}
