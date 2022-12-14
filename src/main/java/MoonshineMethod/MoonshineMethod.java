package MoonshineMethod;

import MoonshineData.DataAlcYield.RawMaterial;
import MoonshineData.DataConcentrationAlc.AlcConcentration;
import MoonshineData.DataConcentrationAlc.Coefficient;
import MoonshineData.DataEfficiency.DataEfficiency;
import MoonshineData.DestillationData.Distillate;
import MoonshineData.MoonshineData;
import MoonshineDataRead.DataReadConcentrationAlc.DataReadConcentrationAlc;
import MoonshineDataRead.DataReadDestillate.DataReadDistillate;
import MoonshineDataRead.DataReadEfficiency.DataReadEfficiency;
import MoonshineDataRead.DataReadMoonshine;
import MoonshineDataRead.DataReadYield.DataReadYield;
import MoonshineDataRead.DensityOption.OptionDensity;
import MoonshineMethod.ChemicalProperties.DensityAlc;
import MoonshineMethod.DestillateYieldCalculation.DistillationYield;
import MoonshineMethod.DestillateYieldCalculation.DistillationYieldCalculation;
import MoonshineMethod.EfficiencyCalculation.EfficiencyCalculation;
import MoonshineMethod.EfficiencyCalculation.EfficiencyMethod;
import MoonshineMethod.MethodsCalculatingYield.AlcMethodYield;
import MoonshineMethod.MethodsCalculatingYield.ControlLoopYield;
import MoonshineMethod.ModelConcentrationAlc.AlcCalculation;
import MoonshineMethod.ModelConcentrationAlc.InterpolationFunction;
import MoonshineMethod.ModelConcentrationAlc.InterpolationFunctionPureAlc;
import MoonshineMethod.ModelConcentrationAlc.Volume;
import MoonshineMethod.ModelConcentrationAlc.Weight;
import exception.NoSuchOptionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MoonshineMethod {

    public void moonshineMethod(
            Scanner scanner
            , DataReadDistillate dataReadDistillate
            , DataReadMoonshine dataReadMoonshine
            , DistillationYield distillationYield , Distillate distillate
            , DistillationYieldCalculation distillationYieldCalculation
            , ControlLoopYield controlLoopYield
            , RawMaterial rawMaterial
            , AlcMethodYield alcMethod
            , DataReadYield dataReadYield
            , AlcCalculation alcCalculation
            , DataReadConcentrationAlc dataReadConcentrationAlc
            , InterpolationFunction interpolation
            , InterpolationFunctionPureAlc interpolationPureAlc
            , AlcConcentration alcConcentration
            , Coefficient coefficient
            , Volume volume
            , Weight weight
            , EfficiencyMethod efficiencyMethod
            , DataReadEfficiency dataReadEfficiency
            , DataEfficiency dataEfficiency
            , EfficiencyCalculation efficiencyCalculation
            , DensityAlc densityAlc
            , OptionDensity optionDensity
    ) throws NoSuchOptionException {
        MoonshineData moonshineData;

        do {
            printOptions ( );
            moonshineData = getMoonshineData( scanner, dataReadMoonshine);
            switch (moonshineData) {
                case YIELD_FROM_RAW_MATERIAL -> {
                    controlLoopYield.alcYieldRawMaterial ( scanner , dataReadYield , rawMaterial , alcMethod );
                }
                case YIELD_FROM_DISTILLATION -> {
                    distillationYieldCalculation.distYieldCalculation ( scanner , distillate , dataReadDistillate , distillationYield );
                }
                case CONCENTRATION_CONVERSION -> {
                    alcCalculation.alcConversion (
                            scanner
                            , dataReadConcentrationAlc
                            , interpolation
                            , interpolationPureAlc
                            , alcConcentration
                            , coefficient
                            , volume
                            , weight );
                }
                case TOTAL_EFFICIENCY -> {
                    efficiencyMethod.summaryEfficiency (
                            scanner
                            , dataReadEfficiency
                            , dataEfficiency
                            , efficiencyCalculation );
                }
                case CHEMICAL_PROPERTIES -> {
                    densityAlc.alcDensity (
                            scanner
                            , optionDensity
                            , dataReadConcentrationAlc
                            , interpolation
                            , interpolationPureAlc
                            , alcConcentration
                            , coefficient
                            , alcCalculation );
                }

                case EXIT -> exit ( scanner , dataReadMoonshine );
                default -> System.out.println ( "There is no such option, enter again: " );
            }
        } while (moonshineData != moonshineData.EXIT);
    }

    private MoonshineData getMoonshineData(Scanner scanner, DataReadMoonshine dataReadMoonshine) {
        boolean moonshineDataOk = false;
        MoonshineData moonshineData = null;
        while (!moonshineDataOk) {
            try {
                moonshineData = MoonshineData.createFromInt(dataReadMoonshine.getOption ( scanner ));
                moonshineDataOk = true;
            } catch (NoSuchOptionException e) {
                System.out.println ( e.getMessage() + ", please re-enter:");
            } catch (InputMismatchException ignored) {
                System.out.println("You entered a value that is not a number, please re-enter:");
            }
        }
        return moonshineData;
    }

    private void printOptions() {
        System.out.println ( "Choice the option: " );
        for (MoonshineData moonshineData : MoonshineData.values ( )) {
            System.out.println ( moonshineData );
        }
    }

    private void exit(Scanner scanner , DataReadMoonshine dataReadMoonshine) {
        System.out.println ( "exit from the program" );
        dataReadMoonshine.close ( scanner );
    }
}
