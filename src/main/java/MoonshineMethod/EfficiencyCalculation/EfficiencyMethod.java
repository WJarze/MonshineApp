package MoonshineMethod.EfficiencyCalculation;

import MoonshineData.DataEfficiency.DataEfficiency;
import MoonshineData.DataEfficiency.EfficiencyOption;
import MoonshineDataRead.DataReadEfficiency.DataReadEfficiency;
import MoonshineDataRead.InputReader;
import exception.NoSuchOptionException;

import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EfficiencyMethod {
private static final Logger log = Logger.getLogger (EfficiencyMethod.class.getName ());
    public void summaryEfficiency(
            InputReader inputReader
            , DataReadEfficiency dataReadEfficiency
            , DataEfficiency dataEfficiency
            , EfficiencyCalculation efficiencyCalculation) {
        EfficiencyOption efficiencyOption;
        do {
            efficiencyOption = getEfficiencyAlcChoice( inputReader , dataReadEfficiency);
            switch (efficiencyOption) {
                case EFFICIENCY -> {
                    dataEfficiency.setDistillationAlcYield ( dataReadEfficiency.readDistillationAlcYield ( inputReader ) );
                    dataEfficiency.setAlcRawMaterialYield ( dataReadEfficiency.readAlcRawMaterialYield ( inputReader ) );
                    efficiencyCalculation.efficiencyAlcoholCalculation ( dataEfficiency );
                    dataEfficiency.setEfficiencyOfObtainingAlcohol ( efficiencyCalculation.efficiencyAlcoholCalculation ( dataEfficiency ) );
                    log.log ( Level.INFO , "%s\n".formatted ( String.valueOf ( dataEfficiency ) ) );
                }
            }
        } while (efficiencyOption != EfficiencyOption.EXIT);
    }
    public EfficiencyOption getEfficiencyAlcChoice(InputReader inputReader , DataReadEfficiency dataReadEfficiency) {
        boolean efficiencyOptionOk = false;
        EfficiencyOption efficiencyOption = null;
        while (!efficiencyOptionOk) {
            try {
                efficiencyOption = EfficiencyOption.createFromInt(dataReadEfficiency.getOptionEfficiency ( inputReader ));
                efficiencyOptionOk = true;
            } catch (NoSuchOptionException e) {
                log.log ( Level.INFO , e.getMessage() + ", please re-enter:");
            } catch (InputMismatchException ignored) {
                log.log ( Level.INFO ,"You entered a value that is not a number, please re-enter:");
            }
        }
        return efficiencyOption;
    }
}
