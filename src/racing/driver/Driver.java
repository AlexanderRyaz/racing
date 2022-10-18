package racing.driver;

import racing.transport.Bus;
import racing.transport.Car;
import racing.transport.Transport;
import racing.transport.Truck;

public class Driver<T extends Category> {

    private final String name;

    private DriverLicense<T> driverLicense;

    private Transport transport;


    public Driver(String name, DriverLicense<T> driverLicense) {
        if (name == null) {
            this.name = "default";
        } else {
            this.name = name;
        }
        this.driverLicense = driverLicense;
    }

    public String getName() {
        return name;
    }

    public DriverLicense<T> getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicense<T> driverLicense) {
        this.driverLicense = driverLicense;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        if (driverLicense == null) {
            throw new RuntimeException("Водитель не может управлять автомобилем, так как у него отсутствуют водительские права");
        }
        String category = driverLicense.getCategory().getSimpleName();
        switch (category) {
            case "B":
                if (transport instanceof Car) {
                    this.transport = transport;
                    break;
                }
            case "C":
                if (transport instanceof Truck) {
                    this.transport = transport;
                    break;
                }
            case "D":
                if (transport instanceof Bus) {
                    this.transport = transport;
                    break;
                }
            default:
                throw new RuntimeException("Вадитель с категорией водительского удостоверения "
                        + driverLicense.getCategory().getSimpleName() + " не может управлять автомобилем " + transport.toString());
        }
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", driverLicense=" + driverLicense.getCategory().getSimpleName() +
                '}';
    }
}
