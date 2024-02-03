package MoonshineMethod.ModelConcentrationAlc;

import MoonshineData.DataConcentrationAlc.AlcConcentration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeightTest {

    @Test
    void weightConcentration() {
        AlcConcentration alcConcentration  = new AlcConcentration();
        Weight weight = new Weight();
        alcConcentration.setAlcConcentration (1.0);
        alcConcentration.setPureAlcDensity ( 1.0 );
        alcConcentration.setDensity ( 1.0 );
        double result = weight.weightConcentration ( alcConcentration );
        double expected = 100;
        assertEquals(expected,result);
    }


}