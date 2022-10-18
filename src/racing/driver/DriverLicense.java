package racing.driver;

public class DriverLicense<T extends Category> {

    private T      category;
    private int    drivingExperience;

    public DriverLicense(T category, int drivingExperience) {
        this.category = category;
        this.drivingExperience = drivingExperience;
    }

    public T getCategory() {
        return category;
    }

    public void setCategory(T category) {
        this.category = category;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        if (drivingExperience > 0) {
            this.drivingExperience = drivingExperience;
        } else {
            this.drivingExperience = 0;
        }
    }

}
