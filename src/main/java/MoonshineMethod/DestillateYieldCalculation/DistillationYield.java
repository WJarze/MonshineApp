package MoonshineMethod.DestillateYieldCalculation;

import MoonshineData.DestillationData.Distillate;

public class DistillationYield {

    public double sumAlcDistillation(Distillate distillate) {
        double sumAlc = (distillate.getForeShotsWeight ( ) * distillate.getForeShotsWeightConcentration ( )
                + distillate.getHeadsWeight ( ) * distillate.getHeadsWeightConcentration ( )
                + distillate.getTailsWeight ( ) * distillate.getTailsWeightConcentration ( )) / 100;
        distillate.setDistillAlcSum ( sumAlc );
        return distillate.getDistillAlcSum ();
    }
}
