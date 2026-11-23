public class BloodFridge extends StorageUnit{
    public BloodFridge(int id) {
        super("Blood Fridge", id);
    }

    @Override
    public double getMinTemp(){
        return 2.0;
    }

    @Override
    public double getMaxTemp(){
        return 6.0;
    }

}
