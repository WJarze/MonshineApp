package MoonshineDataRead.DataReadConcentrationAlc;

import MoonshineDataRead.InputReader;
import exception.NoBetweenPercents;

import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReadConcentrationAlc {
    public static final Logger log = Logger.getLogger ( DataReadConcentrationAlc.class.getName ( ) );



    public int getOptionConcentration(InputReader inputReader) {
        log.log ( Level.INFO , """
                
                0 - EXIT\s
                1 - CALCULATE WEIGHT CONCENTRATION\s
                2 - CALCULATE VOLUME CONCENTRATION\s""" );
        try {
            return inputReader.nextInt ( );
        } finally {
            inputReader.nextLine ( );
        }
    }

    public double concentration(InputReader inputReader) {
        log.log ( Level.INFO , "enter the concentration of ethanol" );
        boolean err = true;
        double concentration = 0;
        do {
            try {
                concentration = inputReader.nextDouble ( ) / 100;
                concentrationValidator ( concentration );
                err = false;
            } catch (InputMismatchException e) {
                log.log ( Level.INFO , "Select the right number: " );
                inputReader.nextLine ( );
            } catch (NoBetweenPercents e) {
                log.log ( Level.INFO , e.getMessage ( ) );
                inputReader.nextLine ( );
            }
        } while (err);
        return concentration;
    }

    public static void concentrationValidator(double concentration) {
        if ( (concentration < 0) || (concentration > 1) ) {
            throw new NoBetweenPercents ( "Choose a number between 0 - 100, no number " + concentration * 100 );
        }
    }

    public double temp(InputReader inputReader) {
        log.log ( Level.INFO , "enter the temperature" );
        return inputReader.nextDouble ( );
    }

}
