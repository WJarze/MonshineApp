package MoonshineMethod.EfficiencyCalculation;

import MoonshineData.DataEfficiency.DataEfficiency;
import MoonshineData.DataEfficiency.EfficiencyOption;
import MoonshineDataRead.DataReadEfficiency.DataReadEfficiency;
import exception.NoSuchOptionException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EfficiencyMethod {
private static final Logger log = Logger.getLogger (EfficiencyMethod.class.getName ());
    public void summaryEfficiency(
            Scanner scanner
            , DataReadEfficiency dataReadEfficiency
            , DataEfficiency dataEfficiency
            , EfficiencyCalculation efficiencyCalculation) {
        EfficiencyOption efficiencyOption;
        do {
            printEfficiencyOptions ( );
            efficiencyOption = getEfficiencyAlcChoice( scanner, dataReadEfficiency);
            switch (efficiencyOption) {
                case EFFICIENCY -> {
                    dataEfficiency.setDistillationAlcYield ( dataReadEfficiency.readDistillationAlcYield ( scanner ) );
                    dataEfficiency.setAlcRawMaterialYield ( dataReadEfficiency.readAlcRawMaterialYield ( scanner ) );
                    efficiencyCalculation.efficiencyAlcoholCalculation ( dataEfficiency );
                    dataEfficiency.setEfficiencyOfObtainingAlcohol ( efficiencyCalculation.efficiencyAlcoholCalculation ( dataEfficiency ) );
                    log.log ( Level.INFO , "%s\n".formatted ( String.valueOf ( dataEfficiency ) ) );
                }
            }
        } while (efficiencyOption != EfficiencyOption.EXIT);
    }
    private EfficiencyOption getEfficiencyAlcChoice(Scanner scanner, DataReadEfficiency dataReadEfficiency) {
        boolean efficiencyOptionOk = false;
        EfficiencyOption efficiencyOption = null;
        while (!efficiencyOptionOk) {
            try {
                efficiencyOption = EfficiencyOption.createFromInt(dataReadEfficiency.getOptionEfficiency ( scanner ));
                efficiencyOptionOk = true;
            } catch (NoSuchOptionException e) {
                log.log ( Level.INFO , e.getMessage() + ", please re-enter:");
            } catch (InputMismatchException ignored) {
                log.log ( Level.INFO ,"You entered a value that is not a number, please re-enter:");
            }
        }
        return efficiencyOption;
    }
    private void printEfficiencyOptions() {
        log.log ( Level.INFO , "Choice the option: " );
        for (EfficiencyOption option : EfficiencyOption.values ( )) {
            log.log ( Level.INFO , String.valueOf ( option ) );
        }
    }
}
