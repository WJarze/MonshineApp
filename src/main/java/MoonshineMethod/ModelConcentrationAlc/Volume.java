package MoonshineMethod.ModelConcentrationAlc;

import MoonshineData.DataConcentrationAlc.AlcConcentration;

public class Volume {
    public double volumeConcentration(AlcConcentration alcConcentration) {
        double volumeConcentration = alcConcentration.getAlcConcentration ( ) * alcConcentration.getDensity ( ) / alcConcentration.getPureAlcDensity ( ) * 100;
        alcConcentration.setAlcVolumeConcentration ( volumeConcentration );
        return alcConcentration.getAlcVolumeConcentration ( );
    }
}
