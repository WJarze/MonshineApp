package MoonshineData.DestillationData;

public class Distillate {
    private double foreShotsWeight;
    private double foreShotsWeightConcentration;
    private double headsWeight;
    private double headsWeightConcentration;
    private double tailsWeight;
    private double tailsWeightConcentration;
    private double distillAlcSum;

    public double getDistillAlcSum() {
        return distillAlcSum;
    }

    public void setDistillAlcSum(double distillAlcSum) {
        this.distillAlcSum = distillAlcSum;
    }

    public double getForeShotsWeight() {
        return foreShotsWeight;
    }

    public void setForeShotsWeight(double foreShotsWeight) {
        this.foreShotsWeight = foreShotsWeight;
    }

    public double getForeShotsWeightConcentration() {
        return foreShotsWeightConcentration;
    }

    public void setForeShotsWeightConcentration(double foreShotsWeightConcentration) {
        this.foreShotsWeightConcentration = foreShotsWeightConcentration;
    }

    public double getHeadsWeight() {
        return headsWeight;
    }

    public void setHeadsWeight(double headsWeight) {
        this.headsWeight = headsWeight;
    }

    public double getHeadsWeightConcentration() {
        return headsWeightConcentration;
    }

    public void setHeadsWeightConcentration(double headsWeightConcentration) {
        this.headsWeightConcentration = headsWeightConcentration;
    }

    public double getTailsWeight() {
        return tailsWeight;
    }

    public void setTailsWeight(double tailsWeight) {
        this.tailsWeight = tailsWeight;
    }

    public double getTailsWeightConcentration() {
        return tailsWeightConcentration;
    }

    public void setTailsWeightConcentration(double tailsWeightConcentration) {
        this.tailsWeightConcentration = tailsWeightConcentration;
    }

    @Override
    public String toString() {
        return String.format("Yield pure Alcohol %.2f kg",distillAlcSum);
    }
}
