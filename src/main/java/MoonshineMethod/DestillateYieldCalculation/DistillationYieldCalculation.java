package MoonshineMethod.DestillateYieldCalculation;

import MoonshineData.DestillationData.Distillate;
import MoonshineData.DestillationData.DistillateOption;
import MoonshineDataRead.DataReadDestillate.DataReadDistillate;
import MoonshineDataRead.InputReader;
import exception.NoSuchOptionException;

import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DistillationYieldCalculation {

private static final Logger log = Logger.getLogger (DistillationYield.class.getName());
    public void distYieldCalculation(InputReader inputReader , Distillate distillate , DataReadDistillate dataReadDistillate ,
                                     DistillationYield distillationYield) {

        DistillateOption distillateOption;
        do {
            distillateOption = getDistillateOption( inputReader , dataReadDistillate);
            switch (distillateOption) {
                case DISTILLATE_YIELD -> {
                    distillate.setForeShotsWeight ( dataReadDistillate.getForeshotsMass ( inputReader ) );
                    distillate.setForeShotsWeightConcentration ( dataReadDistillate.getForeshotsPercent ( inputReader ) );
                    distillate.setHeadsWeight ( dataReadDistillate.getHeadsMass ( inputReader ) );
                    distillate.setHeadsWeightConcentration ( dataReadDistillate.getHeadsPercent ( inputReader ) );
                    distillate.setTailsWeight ( dataReadDistillate.getTailsMass ( inputReader ) );
                    distillate.setTailsWeightConcentration ( dataReadDistillate.getTailsPercent ( inputReader ) );
                    distillationYield.sumAlcDistillation ( distillate );
                    distillate.setDistillAlcSum ( distillationYield.sumAlcDistillation ( distillate ) );
                    log.log ( Level.INFO , "%s\n".formatted ( String.valueOf ( distillate ) ) );
                }
            }
        } while (distillateOption != DistillateOption.EXIT);
    }
    private DistillateOption getDistillateOption(InputReader inputReader , DataReadDistillate dataReadDistillate) {
        boolean distillateOptionOk = false;
        DistillateOption distillateOption = null;
        while (!distillateOptionOk) {
            try {
                distillateOption = DistillateOption.createFromInt(dataReadDistillate.getDistillateOption ( inputReader ));
                distillateOptionOk = true;
            } catch (NoSuchOptionException e) {
                log.log ( Level.INFO , e.getMessage() + ", please re-enter:");
            } catch (InputMismatchException ignored) {
                log.log ( Level.INFO ,"You entered a value that is not a number, please re-enter:");
            }
        }
        return distillateOption;
    }
}
