public class VaccineFridge extends StorageUnit{
    public VaccineFridge(int id) {
        super("Vaccine Fridge", id);
    }

    @Override
    public double getMinTemp(){
        return 2.0;
    }

    @Override
    public double getMaxTemp(){
        return 8.0;
    }

}
