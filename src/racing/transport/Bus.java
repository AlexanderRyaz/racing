package racing.transport;

import racing.Competing;
import racing.util.BusCapacityType;
import racing.util.TransportType;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.round;

public class Bus extends Transport implements Competing {

    private static final TransportType TRANSPORT_TYPE = TransportType.BUS;

    private final BusCapacityType busCapacityType;

    public Bus(String brand, String model, double engineVolume, BusCapacityType busCapacityType) {
        super(brand, model, engineVolume);
        this.busCapacityType = busCapacityType;
    }

    public BusCapacityType getBusCapacityType() {
        return busCapacityType;
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
    public void pitStop() {
        System.out.println(getBrand() + " " + getModel() + " заправлен, поменяли передние покрышки");
    }

    @Override
    public String bestTime() {
        int minutes = ThreadLocalRandom.current().nextInt(0, 5);
        int seconds = ThreadLocalRandom.current().nextInt(0, 60);
        return "Лучшее время круга: " + minutes + ":" + seconds;
    }

    @Override
    public boolean diagnostic() {
        System.out.println("автобус " + getBrand() + " " + getModel() + " не нуждается в диагностике");
        return true;
    }

    @Override
    public double maxSpeed() {
        return round(ThreadLocalRandom.current().nextDouble(110, 180));
    }

    @Override
    public String toString() {
        return "Автобус ("
               + super.toString()
               +  "вместимость: " + busCapacityType + ")";
    }
}
