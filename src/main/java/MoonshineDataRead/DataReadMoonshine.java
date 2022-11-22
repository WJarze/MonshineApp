package MoonshineDataRead;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReadMoonshine {
    protected static final Logger log = Logger.getLogger ( DataReadMoonshine.class.getName ( ) );

    public int getOption(Scanner scanner) {
        log.log ( Level.INFO , """

                0 - EXIT\s
                1 - YIELD FROM RAW MATERIAL\s
                2 - YIELD FROM DISTILLATION\s
                3 - CONCENTRATION CONVERSION\s
                4 - TOTAL EFFICIENCY\s
                5 - CHEMICAL PROPERTIES\s""" );
        try {
            return scanner.nextInt ( );
        } finally {
            scanner.nextLine ( );
        }
    }

    public void close(Scanner scanner) {
        scanner.close ( );
    }

}
