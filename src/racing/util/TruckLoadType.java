package racing.util;

public enum TruckLoadType {
    N1("полная масса до 3.5 тонн"), N2("поная масса от 3.5 до 12 тонн"), N3("полная масса свыше 12 тонн");
    private final String loadType;

    TruckLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getLoadType() {
        return loadType;
    }
}
