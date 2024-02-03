package MoonshineMethod.DestillateYieldCalculation;

import MoonshineData.DestillationData.Distillate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistillationYieldTest {
    public double sumAlcDistillation(Distillate distillate) {
        double sumAlc = (distillate.getForeShotsWeight ( ) * distillate.getForeShotsWeightConcentration ( )
                + distillate.getHeadsWeight ( ) * distillate.getHeadsWeightConcentration ( )
                + distillate.getTailsWeight ( ) * distillate.getTailsWeightConcentration ( )) / 100;
        distillate.setDistillAlcSum ( sumAlc );
        return distillate.getDistillAlcSum ();
    }
    @Test
    void should_be_return_volumeConcentration() {
        Distillate distillate  = new Distillate ();
        DistillationYield distillationYield = new DistillationYield ();
        distillate.setForeShotsWeight (1.0);
        distillate.setForeShotsWeightConcentration ( 1.0 );
        distillate.setHeadsWeight (1.0);
        distillate.setHeadsWeightConcentration ( 1.0 );
        distillate.setTailsWeight (1.0);
        distillate.setTailsWeightConcentration ( 1.0 );
        double result = distillationYield.sumAlcDistillation ( distillate ) * 100;
        double expected = 3;
        assertEquals(expected,result);
    }
}