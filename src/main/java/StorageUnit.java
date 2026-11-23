

public abstract class StorageUnit {
    private final String name;
    private final int id;

    public StorageUnit(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract double getMinTemp();
    public abstract double getMaxTemp();

    public double getTargetTemp() {
        return (getMinTemp() + getMaxTemp()) / 2;
    }

    public boolean isInRange(double temp) {
        return temp >= getMinTemp() && temp <= getMaxTemp();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " (safe " + getMinTemp() + " to " + getMaxTemp()
                + "C, target " + getTargetTemp() + ")";
    }



}
