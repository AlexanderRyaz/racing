package racing.transport;

import racing.Competing;
import racing.util.TransportType;
import racing.util.TruckLoadType;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.round;

public class Truck extends Transport implements Competing {

    private static final TransportType TRANSPORT_TYPE = TransportType.TRUCK;

    private final TruckLoadType loadType;

    public Truck(String brand, String model, double engineVolume, TruckLoadType loadType) {
        super(brand, model, engineVolume);
        this.loadType = loadType;
    }

    @Override
    public TransportType getTransportType(){
        return TRANSPORT_TYPE;
    }

    public TruckLoadType getLoadType() {
        return loadType;
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
        System.out.println(getBrand() + " " + getModel() + "  заправлен, поменяли задние покрышки");
    }

    @Override
    public String bestTime() {
        int minutes = ThreadLocalRandom.current().nextInt(0, 5);
        int seconds = ThreadLocalRandom.current().nextInt(0, 60);
        return "Лучшее время круга: " + minutes + ":" + seconds;
    }
    @Override
    public boolean diagnostic() {
        return ThreadLocalRandom.current().nextInt() % 3 == 0;
    }
    @Override
    public double maxSpeed() {
        return round(ThreadLocalRandom.current().nextDouble(120, 190));
    }
    @Override
    public String toString() {
        return "Грузовой автомобиль ("
               + super.toString()
               +  "грузоподъёмность: " + loadType + ")";
    }
}
