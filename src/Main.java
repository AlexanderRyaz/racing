import racing.Mechanic;
import racing.Sponsor;
import racing.driver.*;
import racing.transport.Bus;
import racing.transport.Car;
import racing.transport.Transport;
import racing.transport.Truck;
import racing.util.BusCapacityType;
import racing.util.CarCategory;
import racing.util.TransportType;
import racing.util.TruckLoadType;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Bus bus1 = new Bus("Икарус", "И-1000", 4.0, BusCapacityType.BIG);
        Car car1 = new Car("Lada", "Grande", 1.6, CarCategory.COUPE);
        Truck truck1 = new Truck("Камаз", "Т-500", 6.0, TruckLoadType.N3);
        Driver<CategoryB> driver1 = new Driver<>("вася иванов", new DriverLicense<>(new CategoryB(), 5));
        Driver<CategoryC> driver2 = new Driver<>("петя петров", new DriverLicense<>(new CategoryC(), 8));
        Driver<CategoryD> driver3 = new Driver<>("иван иванов", new DriverLicense<>(new CategoryD(), 10));
        Sponsor sponsor = new Sponsor("газпром", 10000);
        Sponsor sponsor1 = new Sponsor("роснефть", 50000);
        Sponsor sponsor2 = new Sponsor("лукойл", 80000);
        Sponsor sponsor3 = new Sponsor("татнефть", 60000);
        Sponsor sponsor4 = new Sponsor("илон маск", 200000);
        Mechanic mechanic = new Mechanic("сергей", "иванов", "строймаш");
        Mechanic mechanic1 = new Mechanic("вася", "фролов", "сервискар");
        Mechanic mechanic2 = new Mechanic("миша", "евсеев", "спорткар");
        mechanic.setTransportTypes(TransportType.CAR, TransportType.BUS);
        mechanic1.setTransportTypes(TransportType.TRUCK);
        mechanic2.setTransportTypes(TransportType.BUS, TransportType.TRUCK, TransportType.CAR);
        bus1.setDriver(driver3);
        bus1.addMechanics(mechanic, mechanic2,mechanic2,mechanic2);
        bus1.addSponsors(sponsor, sponsor2);
        car1.setDriver(driver1);
        car1.addMechanics(mechanic);
        car1.addSponsors(sponsor4);
        truck1.setDriver(driver2);
        truck1.addMechanics(mechanic1);
        truck1.addSponsors(sponsor1, sponsor3);
        printTransportInfo(car1);
        printTransportInfo(bus1);
        printTransportInfo(truck1);
    }

    private static void printTransportInfo(Transport transport) {
        System.out.println("водитель: " + transport.getDriver());
        for (Mechanic mechanic : transport.getMechanics()) {
            System.out.println("Механик " + mechanic.getFirstName() + " " + mechanic.getLastName());
        }
        for (Sponsor sponsor : transport.getSponsors()) {
            System.out.println("спонсор: " + sponsor.getName());
        }
    }

    private static void diagnostic(Transport... transports) {
        for (Transport transport : transports) {
            try {
                if (transport.diagnostic()) {
                    System.out.println(transport.toString() + " прошел диагностику");
                } else {
                    System.out.println(transport.toString() + " не прошел диагностику");
                }
            } catch (RuntimeException e) {
                System.out.println(transport + " не прошел диагностику. причина: " + e.getMessage());
            }
        }
    }

    private static void printRaceInfo(List<Driver> driverList) {
        for (Driver driver : driverList) {
            if (driver.getTransport() != null) {
                System.out.println("водитель " + driver.getName() + " управляет автомобилем " + driver.getTransport() + "" +
                        " и будет участвовать в заезде");
            } else {
                System.out.println("водитель " + driver.getName() +
                        " не будет участвовать в заезде");
            }
        }
    }

}
