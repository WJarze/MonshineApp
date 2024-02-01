package MoonshineDataRead.DensityOption;

import MoonshineDataRead.InputReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OptionDensity {
    public static final Logger log = Logger.getLogger ( OptionDensity.class.getName ( ) );

    public int getOptionDensity(InputReader inputReader) {
        log.log ( Level.INFO , """
                    
                0 - EXIT\s
                1 - DENSITY ALCOHOL\s
                2 - DENSITY PURE ALCOHOL\s"""
        );

        try {
            return inputReader.nextInt ( );
        } finally {
            inputReader.nextLine ( );
        }
    }
}
