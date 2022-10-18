package racing;

import racing.transport.Transport;
import racing.util.TransportType;

import java.util.ArrayList;
import java.util.List;

public class Mechanic {
    private final String firstName;
    private final String lastName;

    private String company;
    private List<TransportType> transportTypes = new ArrayList<>();

    public Mechanic(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<TransportType> getTransportTypes() {
        return transportTypes;
    }

    public void setTransportTypes(TransportType transportType) {
        this.transportTypes.add(transportType);
    }

    public void diagnostic(Transport transport) {
        if (transportTypes.contains(transport.getTransportType())) {
            System.out.println(getFirstName() + " " + getLastName() + " провел диагностику " + transport.toString());
        } else {
            throw new RuntimeException(getFirstName() + " " + getLastName() + " не может провести диагностику "
                    + transport.toString());
        }
    }

    public void fixTransport(Transport transport) {
        if (transportTypes.contains(transport.getTransportType())) {
            System.out.println(getFirstName() + " " + getLastName() + " починил автомобиль " + transport.toString());
        } else {
            throw new RuntimeException(getFirstName() + " " + getLastName() + " не умеет чинить данный автомобиль "
                    + transport.toString());
        }
    }

}
