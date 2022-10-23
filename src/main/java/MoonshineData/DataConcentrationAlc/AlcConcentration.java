package MoonshineData.DataConcentrationAlc;

public class AlcConcentration {
    private double alcConcentration;
    private double temperature;
    private double alcVolumeConcentration;
    private double alcWeightConcentration;
    private double density;
    private double pureAlcDensity;
    private final int pureAlcWeightConcentration = 1;

    public double getAlcWeightConcentration() {
        return alcWeightConcentration;
    }

    public void setAlcWeightConcentration(double alcWeightConcentration) {
        this.alcWeightConcentration = alcWeightConcentration;
    }

    public int getPureAlcWeightConcentration() {
        return pureAlcWeightConcentration;
    }

    public double getAlcConcentration() {
        return alcConcentration;
    }

    public double getPureAlcDensity() {
        return pureAlcDensity;
    }

    public void setPureAlcDensity(double pureAlcDensity) {
        this.pureAlcDensity = pureAlcDensity;
    }

    public double setAlcConcentration(double alcWeightConcentration) {
        this.alcConcentration = alcWeightConcentration;
        return alcWeightConcentration;
    }

    public double getAlcVolumeConcentration() {
        return alcVolumeConcentration;
    }

    public void setAlcVolumeConcentration(double alcVolumeConcentration) {
        this.alcVolumeConcentration = alcVolumeConcentration;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return "Alc{" +
                "alcConcentration=" + alcConcentration +
                ", temperature=" + temperature +
                ", alcVolumeConcentration=" + alcVolumeConcentration +
                ", alcWeightConcentration=" + alcWeightConcentration +
                ", density=" + density +
                ", pureAlcDensity=" + pureAlcDensity +
                ", pureAlcWeightConcentration=" + pureAlcWeightConcentration +
                '}';
    }
}
