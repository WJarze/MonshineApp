package MoonshineDataRead.DataReadConcentrationAlc;

import exception.NoBetweenPercents;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReadConcentrationAlc {
    public static final Logger log = Logger.getLogger ( DataReadConcentrationAlc.class.getName ( ) );

    public int getOptionConcentration(Scanner scanner) {
        log.log ( Level.INFO , """
                
                0 - EXIT\s
                1 - CALCULATE WEIGHT CONCENTRATION\s
                2 - CALCULATE VOLUME CONCENTRATION\s""" );
        try {
            return scanner.nextInt ( );
        } finally {
            scanner.nextLine ( );
        }
    }

    public double concentration(Scanner scanner) {
        log.log ( Level.INFO , "enter the concentration of ethanol" );
        boolean err = true;
        double concentration = 0;
        do {
            try {
                concentration = scanner.nextDouble ( ) / 100;
                concentrationValidator ( concentration );
                err = false;
            } catch (InputMismatchException e) {
                log.log ( Level.INFO , "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoBetweenPercents e) {
                log.log ( Level.INFO , e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return concentration;
    }

    private static void concentrationValidator(double concentration) {
        if ( (concentration < 0) || (concentration > 1) ) {
            throw new NoBetweenPercents ( "Choose a number between 0 - 100, no number " + concentration * 100 );
        }
    }

    public double temp(Scanner scanner) {
        log.log ( Level.INFO , "enter the temperature" );
        return scanner.nextDouble ( );
    }

}
