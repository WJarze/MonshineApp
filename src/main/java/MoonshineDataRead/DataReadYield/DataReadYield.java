package MoonshineDataRead.DataReadYield;

import MoonshineDataRead.InputReader;
import exception.NoPositiveNumberException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReadYield {
    public static final Logger log = Logger.getLogger(DataReadYield.class.getName ());
    public int getOptionYield(InputReader inputReader) {
        log.log ( Level.INFO, """
                 
                 0 - EXIT\s
                 1 - SUGAR\s
                 2 - WHEAT\s
                 3 - CORN\s
                 4 - POTATO\s""");
        try {
            return inputReader.nextInt ( );

        } finally {
            inputReader.nextLine ( );
        }
    }

    public double rawMaterialMass(InputReader inputReader) {
        log.log (Level.INFO , " Enter the raw material mass" );
        boolean err = true;
        double optionRawMaterialMass = 0;
        do {
            try {
                optionRawMaterialMass = inputReader.nextDouble ( );
                if ( optionRawMaterialMass < 0 ) {
                    throw new NoPositiveNumberException ("Number must be >= 0, no negative number " + optionRawMaterialMass);
                }
                err = false;
            } catch (InputMismatchException e) {
                log.log (Level.INFO ,  "Select the right number: " );
                inputReader.nextLine ( );
            } catch (NoPositiveNumberException e) {
                log.log (Level.INFO , e.getMessage () );
                inputReader.nextLine ( );
            }
        } while (err);
        return optionRawMaterialMass;
    }
}
