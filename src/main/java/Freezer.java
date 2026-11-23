public class Freezer extends StorageUnit{
    public Freezer(int id) {
        super("Freezer", id);
    }

    @Override
    public double getMinTemp(){
        return -25.0;
    }

    @Override
    public double getMaxTemp(){
        return -15.0;
    }

}
