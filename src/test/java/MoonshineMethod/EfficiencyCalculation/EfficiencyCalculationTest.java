package MoonshineMethod.EfficiencyCalculation;

import MoonshineData.DataConcentrationAlc.AlcConcentration;
import MoonshineData.DataEfficiency.DataEfficiency;
import MoonshineMethod.ModelConcentrationAlc.Volume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EfficiencyCalculationTest {
    @Test
    void should_be_return_volumeConcentration() {
        DataEfficiency dataEfficiency  = new DataEfficiency();
        EfficiencyCalculation efficiencyCalculation = new EfficiencyCalculation();
        dataEfficiency.setDistillationAlcYield (1.0);
        dataEfficiency.setAlcRawMaterialYield ( 1.0 );
        double result = efficiencyCalculation.efficiencyAlcoholCalculation ( dataEfficiency );
        double expected = 100;
        assertEquals(expected,result);
    }
}