package MoonshineMethod.ModelConcentrationAlc;

import MoonshineData.DataConcentrationAlc.AlcConcentration;
import MoonshineData.DataConcentrationAlc.Coefficient;
import MoonshineData.DataConcentrationAlc.ConcentrationOption;
import MoonshineDataRead.DataReadConcentrationAlc.DataReadConcentrationAlc;
import MoonshineDataRead.InputReader;
import exception.NoSuchOptionException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.String.format;

public class AlcCalculation {

public static final Logger log = Logger.getLogger (AlcConcentration.class.getName ( ));
    public double density(
            InputReader inputReader
            , DataReadConcentrationAlc dataReadConcentrationAlc
            , InterpolationFunction interpolation
            , AlcConcentration alcConcentration
            , Coefficient coefficient) {
        alcConcentration.setTemperature ( dataReadConcentrationAlc.temp ( inputReader ) );
        alcConcentration.setAlcConcentration ( dataReadConcentrationAlc.concentration ( inputReader) );
        alcConcentration.setDensity ( interpolation.density ( coefficient , alcConcentration ) );
        return alcConcentration.getDensity ( );
    }

    public double densityPureAlc(InterpolationFunctionPureAlc interpolationPureAlc , AlcConcentration alcConcentration , Coefficient coefficient) {
        alcConcentration.setPureAlcDensity ( interpolationPureAlc.densityPureAlc ( coefficient , alcConcentration ) );
        return alcConcentration.getPureAlcDensity ( );
    }

    public double volumeConcentration(Volume volume , AlcConcentration alcConcentration) {
        return volume.volumeConcentration ( alcConcentration );

    }

    public double weightConcentration(Weight weight , AlcConcentration alcConcentration) {
        return weight.weightConcentration ( alcConcentration );
    }

    public void alcConversion(
            InputReader inputReader
            , DataReadConcentrationAlc dataReadConcentrationAlc
            , InterpolationFunction interpolation
            , InterpolationFunctionPureAlc interpolationPureAlc
            , AlcConcentration alcConcentration
            , Coefficient coefficient
            , Volume volume
            , Weight weight) throws NoSuchOptionException {
        ConcentrationOption concentrationOption;

        do {
            concentrationOption = getConcentrationOption( inputReader, dataReadConcentrationAlc) ;
            switch (concentrationOption) {
                case WEIGHT -> {
                    density (
                            inputReader
                            , dataReadConcentrationAlc
                            , interpolation
                            , alcConcentration
                            , coefficient );
                    densityPureAlc ( interpolationPureAlc , alcConcentration , coefficient );
                    weightConcentration ( weight , alcConcentration );
                    log.log ( Level.INFO , "%s\n".formatted ( format ( "%.2f %s" , weightConcentration ( weight , alcConcentration ) , "%" ) ) );
                }
                case VOLUME -> {
                    density (
                            inputReader
                            , dataReadConcentrationAlc
                            , interpolation
                            , alcConcentration
                            , coefficient );
                    densityPureAlc ( interpolationPureAlc , alcConcentration , coefficient );
                    volumeConcentration ( volume , alcConcentration );
                    log.log ( Level.INFO , "%s\n".formatted ( format ( "%.2f %s" , volumeConcentration ( volume , alcConcentration ) , "%" ) ) );
                }
            }
        } while (concentrationOption != ConcentrationOption.EXIT);
    }
    private ConcentrationOption  getConcentrationOption(InputReader inputReader, DataReadConcentrationAlc dataReadConcentrationAlc) {
        boolean concentrationOptionOk = false;
        ConcentrationOption concentrationOption = null;
        while (!concentrationOptionOk) {
            try {
                concentrationOption = ConcentrationOption.createFromInt(dataReadConcentrationAlc.getOptionConcentration (  inputReader ));
                concentrationOptionOk = true;
            } catch (NoSuchOptionException e) {
                log.log ( Level.INFO , "%s, please re-enter:".formatted ( e.getMessage ( ) ) );
            } catch (InputMismatchException ignored) {
                log.log (Level.INFO , "You entered a value that is not a number, please re-enter:");
            }
        }
        return concentrationOption;
    }
}
