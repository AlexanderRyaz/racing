package racing.util;

public enum BusCapacityType {
    ESPECIALLY_SMALL("до 10 мест"),
    SMALL("до 25 мест"),
    AVERAGE("40-50 мест"),
    BIG("60-80 мест"),
    EXTRA_LARGE("100-120 мест");
    private final String capacityType;

    BusCapacityType(String capacityType) {
        this.capacityType = capacityType;
    }

    public String getCapacityType() {
        return capacityType;
    }
}
