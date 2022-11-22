package MoonshineDataRead.DensityOption;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OptionDensity {
    public static final Logger log = Logger.getLogger ( OptionDensity.class.getName ( ) );

    public int getOptionDensity(Scanner scanner) {
        log.log ( Level.INFO , """
                                
                0 - EXIT\s
                1 - DENSITY ALCOHOL\s
                2 - DENSITY PURE ALCOHOL\s"""
        );

        try {
            return scanner.nextInt ( );
        } finally {
            scanner.nextLine ( );
        }
    }
}
