package MoonshineMethod.DestillateYieldCalculation;

import MoonshineData.DestillationData.Distillate;
import MoonshineData.DestillationData.DistillateOption;
import MoonshineDataRead.DataReadDestillate.DataReadDistillate;
import exception.NoSuchOptionException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DistillationYieldCalculation {

private static final Logger log = Logger.getLogger (DistillationYield.class.getName());
    public void distYieldCalculation(Scanner scanner , Distillate distillate , DataReadDistillate dataReadDistillate ,
                                     DistillationYield distillationYield) {

        DistillateOption distillateOption;
        do {
            distillateOption = getDistillateOption( scanner, dataReadDistillate);
            switch (distillateOption) {
                case DISTILLATE_YIELD -> {
                    distillate.setForeShotsWeight ( dataReadDistillate.getForeshotsMass ( scanner ) );
                    distillate.setForeShotsWeightConcentration ( dataReadDistillate.getForeshotsPercent ( scanner ) );
                    distillate.setHeadsWeight ( dataReadDistillate.getHeadsMass ( scanner ) );
                    distillate.setHeadsWeightConcentration ( dataReadDistillate.getHeadsPercent ( scanner ) );
                    distillate.setTailsWeight ( dataReadDistillate.getTailsMass ( scanner ) );
                    distillate.setTailsWeightConcentration ( dataReadDistillate.getTailsPercent ( scanner ) );
                    distillationYield.sumAlcDistillation ( distillate );
                    distillate.setDistillAlcSum ( distillationYield.sumAlcDistillation ( distillate ) );
                    log.log ( Level.INFO , "%s\n".formatted ( String.valueOf ( distillate ) ) );
                }
            }
        } while (distillateOption != DistillateOption.EXIT);
    }
    private DistillateOption getDistillateOption(Scanner scanner, DataReadDistillate dataReadDistillate) {
        boolean distillateOptionOk = false;
        DistillateOption distillateOption = null;
        while (!distillateOptionOk) {
            try {
                distillateOption = DistillateOption.createFromInt(dataReadDistillate.getDistillateOption ( scanner ));
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
