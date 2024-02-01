package MoonshineDataRead;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReadMoonshine {
    public static final Logger log = Logger.getLogger ( DataReadMoonshine.class.getName ( ) );

    public int getOption(InputReader inputReader) {
        log.log ( Level.INFO , """

                0 - EXIT\s
                1 - YIELD FROM RAW MATERIAL\s
                2 - YIELD FROM DISTILLATION\s
                3 - CONCENTRATION CONVERSION\s
                4 - TOTAL EFFICIENCY\s
                5 - CHEMICAL PROPERTIES\s""" );
        try {
            return inputReader.nextInt ( );
        } finally {
            inputReader.nextLine ( );
        }
    }

    public void close(InputReader inputReader) {
        inputReader.close ( );
    }

}
