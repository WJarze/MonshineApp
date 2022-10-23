package MoonshineMethod.ModelConcentrationAlc;

import MoonshineData.DataConcentrationAlc.AlcConcentration;

public class Weight {
    protected double weightConcentration(AlcConcentration alcConcentration) {
        double weightConcentration = alcConcentration.getAlcConcentration ( ) * alcConcentration.getPureAlcDensity ( ) / alcConcentration.getDensity ( ) * 100;
        alcConcentration.setAlcWeightConcentration ( weightConcentration );
        return alcConcentration.getAlcWeightConcentration ( );
    }
}
