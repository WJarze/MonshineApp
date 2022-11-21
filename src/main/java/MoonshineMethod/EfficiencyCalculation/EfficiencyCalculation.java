package MoonshineMethod.EfficiencyCalculation;

import MoonshineData.DataEfficiency.DataEfficiency;

public class EfficiencyCalculation {
    public double efficiencyAlcoholCalculation(DataEfficiency dataEfficiency) {
        double efficiencyAlcoholCalculation = dataEfficiency.getDistillationAlcYield ( ) / dataEfficiency.getAlcRawMaterialYield ( ) * 100;
        dataEfficiency.setEfficiencyOfObtainingAlcohol ( efficiencyAlcoholCalculation );
        return dataEfficiency.getEfficiencyOfObtainingAlcohol ( );
    }
}
