package MoonshineMethod.ChemicalProperties;

import MoonshineData.DataConcentrationAlc.AlcConcentration;
import MoonshineData.DataConcentrationAlc.Coefficient;
import MoonshineData.DensityChoice.DensityAlcChoice;
import MoonshineDataRead.DataReadConcentrationAlc.DataReadConcentrationAlc;
import MoonshineDataRead.DensityOption.OptionDensity;
import MoonshineMethod.ModelConcentrationAlc.AlcCalculation;
import MoonshineMethod.ModelConcentrationAlc.InterpolationFunction;
import MoonshineMethod.ModelConcentrationAlc.InterpolationFunctionPureAlc;
import exception.NoSuchOptionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DensityAlc {

    public void alcDensity(
            Scanner scanner
            , OptionDensity optionDensity
            , DataReadConcentrationAlc dataReadConcentrationAlc
            , InterpolationFunction interpolation
            , InterpolationFunctionPureAlc interpolationPureAlc
            , AlcConcentration alcConcentration
            , Coefficient coefficient
            ,AlcCalculation alcCalculation
    ) {
        DensityAlcChoice densityAlcChoice;

        do {
            printDensityOptions ( );
            densityAlcChoice = getDensityAlcChoice( scanner, optionDensity);
            switch (densityAlcChoice) {
                case DENSITY_ALCOHOL -> {
                    System.out.printf ( "%.2f %s" , alcCalculation.density (
                            scanner
                            , dataReadConcentrationAlc
                            , interpolation
                            , alcConcentration
                            , coefficient ) , "kg/m3" );
                    System.out.println ( );
                }
                case DENSITY_PURE_ALCOHOL -> {
                    alcConcentration.setTemperature ( dataReadConcentrationAlc.temp ( scanner ) );
                    System.out.printf ( "%.2f %s" , alcCalculation.densityPureAlc ( interpolationPureAlc , alcConcentration , coefficient ) , "kg/m3" );
                    System.out.println ( );
                }
            }
        } while (densityAlcChoice != DensityAlcChoice.EXIT);
    }
    private DensityAlcChoice getDensityAlcChoice(Scanner scanner, OptionDensity optionDensity) {
        boolean densityAlcChoiceOk = false;
        DensityAlcChoice densityAlcChoice = null;
        while (!densityAlcChoiceOk) {
            try {
                densityAlcChoice = DensityAlcChoice.createFromInt(optionDensity.getOptionDensity ( scanner ));
                densityAlcChoiceOk = true;
            } catch (NoSuchOptionException e) {
                System.out.println ( e.getMessage() + ", please re-enter:");
            } catch (InputMismatchException ignored) {
                System.out.println("You entered a value that is not a number, please re-enter:");
            }
        }
        return densityAlcChoice;
    }
    private void printDensityOptions() {
        System.out.println ( "Choice the option: " );
        for (DensityAlcChoice option : DensityAlcChoice.values ( )) {
            System.out.println ( option );
        }
    }

}
