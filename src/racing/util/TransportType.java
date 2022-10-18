package racing.util;

public enum TransportType {
    CAR("легковой автомобиль"),
    TRUCK("грузовой автомобиль"),
    BUS("автобус");

    private final String transportType;

    TransportType(String loadType) {
        this.transportType = loadType;
    }

    public String getLoadType() {
        return transportType;
    }
}
