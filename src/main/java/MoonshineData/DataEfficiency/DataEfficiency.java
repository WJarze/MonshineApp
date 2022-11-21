package MoonshineData.DataEfficiency;

public class DataEfficiency {
    private double alcRawMaterialYield;
    private double distillationAlcYield;
    private double efficiencyOfObtainingAlcohol;

    public double getAlcRawMaterialYield() {
        return alcRawMaterialYield;
    }

    public void setAlcRawMaterialYield(double alcRawMaterialYield) {
        this.alcRawMaterialYield = alcRawMaterialYield;
    }

    public double getDistillationAlcYield() {
        return distillationAlcYield;
    }

    public void setDistillationAlcYield(double distillationAlcYield) {
        this.distillationAlcYield = distillationAlcYield;
    }

    public double getEfficiencyOfObtainingAlcohol() {
        return efficiencyOfObtainingAlcohol;
    }

    public void setEfficiencyOfObtainingAlcohol(double efficiencyOfObtainingAlcohol) {
        this.efficiencyOfObtainingAlcohol = efficiencyOfObtainingAlcohol;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s",efficiencyOfObtainingAlcohol , "%");
    }
}
