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
import MoonshineDataRead.InputReader;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoonshineMethod {
    private static final Logger log = Logger.getLogger ( MoonshineData.class.getName ( ) );

    public void moonshineMethod(
            InputReader inputReader
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
            moonshineData = getMoonshineData ( inputReader , dataReadMoonshine );
            switch (moonshineData) {
                case YIELD_FROM_RAW_MATERIAL ->
                        controlLoopYield.alcYieldRawMaterial ( inputReader , dataReadYield , rawMaterial , alcMethod );

                case YIELD_FROM_DISTILLATION ->
                        distillationYieldCalculation.distYieldCalculation ( inputReader , distillate , dataReadDistillate , distillationYield );

                case CONCENTRATION_CONVERSION -> alcCalculation.alcConversion (
                        inputReader
                        , dataReadConcentrationAlc
                        , interpolation
                        , interpolationPureAlc
                        , alcConcentration
                        , coefficient
                        , volume
                        , weight );

                case TOTAL_EFFICIENCY -> efficiencyMethod.summaryEfficiency (
                        inputReader
                        , dataReadEfficiency
                        , dataEfficiency
                        , efficiencyCalculation );

                case CHEMICAL_PROPERTIES -> densityAlc.alcDensity (
                        inputReader
                        , optionDensity
                        , dataReadConcentrationAlc
                        , interpolation
                        , interpolationPureAlc
                        , alcConcentration
                        , coefficient
                        , alcCalculation );

                case EXIT -> exit ( inputReader , dataReadMoonshine );
                default -> log.log ( Level.INFO , "There is no such option, enter again: " );
            }
        } while (moonshineData != moonshineData.EXIT);
    }

    private MoonshineData getMoonshineData(InputReader inputReader , DataReadMoonshine dataReadMoonshine) {
        boolean moonshineDataOk = false;
        MoonshineData moonshineData = null;
        while (!moonshineDataOk) {
            try {
                moonshineData = MoonshineData.createFromInt ( dataReadMoonshine.getOption ( inputReader ) );
                moonshineDataOk = true;
            } catch (NoSuchOptionException e) {
                log.log ( Level.INFO , e.getMessage ( ) + ", please re-enter:" );
            } catch (InputMismatchException ignored) {
                log.log ( Level.INFO , "You entered a value that is not a number, please re-enter:" );
            }
        }
        return moonshineData;
    }

    private void exit(InputReader inputReader , DataReadMoonshine dataReadMoonshine) {
        log.log ( Level.INFO , "exit from the program" );
        dataReadMoonshine.close ( inputReader );
    }
}
