package MoonshineMethod.ModelConcentrationAlc;

import MoonshineData.DataConcentrationAlc.AlcConcentration;
import MoonshineData.DataConcentrationAlc.Coefficient;
import MoonshineData.DataConcentrationAlc.ConcentrationOption;
import MoonshineDataRead.DataReadConcentrationAlc.DataReadConcentrationAlc;
import exception.NoSuchOptionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AlcCalculation {


    public double density(
            Scanner scanner
            , DataReadConcentrationAlc dataReadConcentrationAlc
            , InterpolationFunction interpolation
            , AlcConcentration alcConcentration
            , Coefficient coefficient) {
        alcConcentration.setTemperature ( dataReadConcentrationAlc.temp ( scanner ) );
        alcConcentration.setAlcConcentration ( dataReadConcentrationAlc.concentration ( scanner ) );
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
            Scanner scanner
            , DataReadConcentrationAlc dataReadConcentrationAlc
            , InterpolationFunction interpolation
            , InterpolationFunctionPureAlc interpolationPureAlc
            , AlcConcentration alcConcentration
            , Coefficient coefficient
            , Volume volume
            , Weight weight) throws NoSuchOptionException {
        ConcentrationOption concentrationOption;

        do {
            printConcentrationOptions ( );
            concentrationOption = getConcentrationOption( scanner, dataReadConcentrationAlc) ;
            switch (concentrationOption) {
                case WEIGHT -> {
                    density (
                            scanner
                            , dataReadConcentrationAlc
                            , interpolation
                            , alcConcentration
                            , coefficient );
                    densityPureAlc ( interpolationPureAlc , alcConcentration , coefficient );
                    weightConcentration ( weight , alcConcentration );
                    System.out.printf ( "%.2f %s" , weightConcentration ( weight , alcConcentration ) , "%" );
                    System.out.println ( );
                }
                case VOLUME -> {
                    density (
                            scanner
                            , dataReadConcentrationAlc
                            , interpolation
                            , alcConcentration
                            , coefficient );
                    densityPureAlc ( interpolationPureAlc , alcConcentration , coefficient );
                    volumeConcentration ( volume , alcConcentration );
                    System.out.printf ( "%.2f %s" , volumeConcentration ( volume , alcConcentration ) , "%" );
                    System.out.println ( );
                }
            }
        } while (concentrationOption != ConcentrationOption.EXIT);
    }
    private ConcentrationOption  getConcentrationOption(Scanner scanner, DataReadConcentrationAlc dataReadConcentrationAlc) {
        boolean concentrationOptionOk = false;
        ConcentrationOption concentrationOption = null;
        while (!concentrationOptionOk) {
            try {
                concentrationOption = ConcentrationOption.createFromInt(dataReadConcentrationAlc.getOptionConcentration ( scanner ));
                concentrationOptionOk = true;
            } catch (NoSuchOptionException e) {
                System.out.println ( e.getMessage() + ", please re-enter:");
            } catch (InputMismatchException ignored) {
                System.out.println("You entered a value that is not a number, please re-enter:");
            }
        }
        return concentrationOption;
    }
    private void printConcentrationOptions() {
        System.out.println ( "Choice the option: " );
        for (ConcentrationOption option : ConcentrationOption.values ( )) {
            System.out.println ( option );
        }
    }


}
