package MoonshineMethod.ModelConcentrationAlc;

import MoonshineData.DataConcentrationAlc.AlcConcentration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {
    @Test
    void should_be_return_volumeConcentration() {
        AlcConcentration alcConcentration  = new AlcConcentration();
        Volume volume = new Volume();
        alcConcentration.setAlcConcentration (1.0);
        alcConcentration.setPureAlcDensity ( 1.0 );
        alcConcentration.setDensity ( 1.0 );
        double result = volume.volumeConcentration ( alcConcentration );
        double expected = 100;
        assertEquals(expected,result);
    }

}