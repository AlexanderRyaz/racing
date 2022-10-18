import racing.driver.Driver;
import racing.transport.Car;
import racing.transport.Transport;

import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    private static void diagnostic(Transport ... transports){
        for (Transport transport : transports) {
            try {
                if (transport.diagnostic()){
                    System.out.println(transport.toString() + " прошел диагностику");
                }else {
                    System.out.println(transport.toString() + " не прошел диагностику");
                }
            }
            catch (RuntimeException e){
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
