package MoonshineMethod.ChemicalProperties;

import MoonshineData.DataConcentrationAlc.AlcConcentration;
import MoonshineData.DataConcentrationAlc.Coefficient;
import MoonshineData.DensityChoice.DensityAlcChoice;
import MoonshineDataRead.DataReadConcentrationAlc.DataReadConcentrationAlc;
import MoonshineDataRead.DensityOption.OptionDensity;
import MoonshineDataRead.InputReader;
import MoonshineMethod.ModelConcentrationAlc.AlcCalculation;
import MoonshineMethod.ModelConcentrationAlc.InterpolationFunction;
import MoonshineMethod.ModelConcentrationAlc.InterpolationFunctionPureAlc;
import exception.NoSuchOptionException;

import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DensityAlc {
    private static final Logger log = Logger.getLogger ( DensityAlc.class.getName ( ) );

    public void alcDensity(
            InputReader inputReader
            , OptionDensity optionDensity
            , DataReadConcentrationAlc dataReadConcentrationAlc
            , InterpolationFunction interpolation
            , InterpolationFunctionPureAlc interpolationPureAlc
            , AlcConcentration alcConcentration
            , Coefficient coefficient
            , AlcCalculation alcCalculation
    ) {
        DensityAlcChoice densityAlcChoice;

        do {
            densityAlcChoice = getDensityAlcChoice ( inputReader , optionDensity );
            switch (densityAlcChoice) {
                case DENSITY_ALCOHOL -> log.log ( Level.INFO , String.format ( "%.2f %s" , alcCalculation.density (
                        inputReader
                        , dataReadConcentrationAlc
                        , interpolation
                        , alcConcentration
                        , coefficient ) , "kg/m3" + "\n" ) );
                case DENSITY_PURE_ALCOHOL -> {
                    alcConcentration.setTemperature ( dataReadConcentrationAlc.temp ( inputReader ) );
                    log.log ( Level.INFO ,
                            String.format ( "%.2f %s" , alcCalculation.densityPureAlc ( interpolationPureAlc
                                    , alcConcentration
                                    , coefficient ) , "kg/m3" + "\n" ));
                }
            }
        } while (densityAlcChoice != DensityAlcChoice.EXIT);
    }

    private DensityAlcChoice getDensityAlcChoice(InputReader inputReader , OptionDensity optionDensity) {
        boolean densityAlcChoiceOk = false;
        DensityAlcChoice densityAlcChoice = null;
        while (!densityAlcChoiceOk) {
            try {
                densityAlcChoice = DensityAlcChoice.createFromInt ( optionDensity.getOptionDensity ( inputReader ) );
                densityAlcChoiceOk = true;
            } catch (NoSuchOptionException e) {
                log.log ( Level.INFO , e.getMessage ( ) + ", please re-enter:" );
            } catch (InputMismatchException ignored) {
                log.log ( Level.INFO , "You entered a value that is not a number, please re-enter:" );
            }
        }
        return densityAlcChoice;
    }
}
