package MoonshineDataRead.DataReadYield;

import exception.NoPositiveNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReadYield {
    public int getOptionYield(Scanner scanner) {
        System.out.print ( "0 - EXIT " );
        System.out.print ( "1 - SUGAR " );
        System.out.print ( "2 - WHEAT " );
        System.out.print ( "3 - CORN " );
        System.out.println ( "4 - POTATO " );

        try {
            return scanner.nextInt ( );

        } finally {
            scanner.nextLine ( );
        }
    }

    public double rawMaterialMass(Scanner scanner) {
        System.out.println ( "Enter the raw material mass" );
        boolean err = true;
        double optionRawMaterialMass = 0;
        do {
            try {
                optionRawMaterialMass = scanner.nextDouble ( );
                if ( optionRawMaterialMass < 0 ) {
                    throw new NoPositiveNumberException ("Number must be >= 0, no negative number " + optionRawMaterialMass);
                }
                err = false;
            } catch (InputMismatchException e) {
                System.out.println ( "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoPositiveNumberException e) {
                System.out.println (e.getMessage () );
                scanner.nextLine ( );
            }
        } while (err);
        return optionRawMaterialMass;
    }
}
