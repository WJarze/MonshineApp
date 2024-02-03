package MoonshineData.DataAlcYield;

public class AlcYieldResult {
    private double alcYield;

    public void setAlcYield(double alcYield) {
        this.alcYield = alcYield;
    }

    public double getAlcYield() {
        return alcYield;
    }

    @Override
    public String toString() {
        return String.format ( "pure alcohol from raw material %.2f kg" , alcYield );
    }
}
