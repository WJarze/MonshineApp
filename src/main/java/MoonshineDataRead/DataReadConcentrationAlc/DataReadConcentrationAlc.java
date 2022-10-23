package MoonshineDataRead.DataReadConcentrationAlc;

import exception.NoBetweenPercents;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReadConcentrationAlc {
    public int getOptionConcentration(Scanner scanner) {
        System.out.print ( "0 - EXIT " );
        System.out.print ( "1 - CALCULATE WEIGHT CONCENTRATION " );
        System.out.println ( "2 - CALCULATE VOLUME CONCENTRATION " );
        try {
            return scanner.nextInt ( );
        } finally {
            scanner.nextLine ( );
        }
    }

    public double concentration(Scanner scanner) {
        System.out.println ( "enter the concentration of ethanol" );
        boolean err = true;
        double concentration = 0;
        do {
            try {
                concentration = scanner.nextDouble ( ) / 100;
                if ( concentration < 0 || concentration > 1 ) {
                    throw new NoBetweenPercents ( "Choose a number between 0 - 100, no number " + concentration * 100 );
                }
                err = false;
            } catch (InputMismatchException e) {
                System.out.println ( "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoBetweenPercents e) {
                System.out.println ( e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return concentration;
    }

    public double temp(Scanner scanner) {
        System.out.println ( "enter the temperature" );
        return scanner.nextDouble ( );
    }

}
