package racing.transport;

import racing.Mechanic;
import racing.Sponsor;
import racing.driver.Category;
import racing.driver.Driver;
import racing.util.TransportType;

import java.util.*;

public abstract class Transport {

    private final String brand;
    private final String model;
    private final double engineVolume;

    private Driver<? extends Category> driver;
    private Set<Sponsor> sponsors = new HashSet<>();
    private Set<Mechanic> mechanics = new HashSet<>();


    public Transport(String brand, String model, double engineVolume) {
        if (isEmptyString(brand)) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (isEmptyString(model)) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (engineVolume < 0) {
            this.engineVolume = 2.0;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public Driver<? extends Category> getDriver() {
        return driver;
    }

    public void setDriver(Driver<? extends Category> driver) {
        if (driver.getDriverLicense() == null) {
            throw new RuntimeException("у данного водителя нет прав");
        }
        String driverLicenseCategory = driver.getDriverLicense().getCategory().getSimpleName();
        if (driverLicenseCategory.equals("B") && this.getTransportType().equals(TransportType.CAR)) {
            this.driver = driver;
        } else if (driverLicenseCategory.equals("D") && this.getTransportType().equals(TransportType.BUS)) {
            this.driver = driver;
        } else if (driverLicenseCategory.equals("C") && this.getTransportType().equals(TransportType.TRUCK)) {
            this.driver = driver;
        } else {
            throw new RuntimeException("водитель " + driver.getName() + " не может управлять данным авто");
        }
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public void addSponsors(Sponsor... sponsors) {
        this.sponsors.addAll(Arrays.asList(sponsors));
    }

    public Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public void addMechanics(Mechanic... mechanics) {
        this.mechanics.addAll(Arrays.asList(mechanics));
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }


    public boolean isEmptyString(String s) {
        return s == null || "".equals(s);
    }

    public abstract void startDrive();

    public abstract void stopDrive();

    public abstract boolean diagnostic();

    public abstract TransportType getTransportType();

    @Override
    public String toString() {
        return "марка: " + brand + ", модель: " + model;
    }

}
