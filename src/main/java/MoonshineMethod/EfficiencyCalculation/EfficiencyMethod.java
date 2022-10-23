package MoonshineMethod.EfficiencyCalculation;

import MoonshineData.DataEfficiency.DataEfficiency;
import MoonshineData.DataEfficiency.EfficiencyOption;
import MoonshineDataRead.DataReadEfficiency.DataReadEfficiency;
import exception.NoSuchOptionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EfficiencyMethod {

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
                    System.out.println ( dataEfficiency );
                    System.out.println ( );
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
                System.out.println ( e.getMessage() + ", please re-enter:");
            } catch (InputMismatchException ignored) {
                System.out.println("You entered a value that is not a number, please re-enter:");
            }
        }
        return efficiencyOption;
    }
    private void printEfficiencyOptions() {
        System.out.println ( "Choice the option: " );
        for (EfficiencyOption option : EfficiencyOption.values ( )) {
            System.out.println ( option );
        }
    }
}
