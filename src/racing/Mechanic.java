package racing;

import racing.transport.Transport;
import racing.util.TransportType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Mechanic {
    private final String firstName;
    private final String lastName;

    private String company;
    private Set<TransportType> transportTypes = new HashSet<>();

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

    public Set<TransportType> getTransportTypes() {
        return transportTypes;
    }

    public void setTransportTypes(TransportType... transportTypes) {
        this.transportTypes.addAll(Arrays.asList(transportTypes));
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
