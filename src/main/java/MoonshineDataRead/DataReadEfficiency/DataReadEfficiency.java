package MoonshineDataRead.DataReadEfficiency;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReadEfficiency {
    public static final Logger log = Logger.getLogger ( DataReadEfficiency.class.getName ( ) );

    public int getOptionEfficiency(Scanner scanner) {
        log.log ( Level.INFO , """
                        
                0 - EXIT\s
                1 - CALCULATE EFFICIENCY\s """ );
        try {
            return scanner.nextInt ( );
        } finally {
            scanner.nextLine ( );
        }
    }

    public double readDistillationAlcYield(Scanner scanner) {
        log.log ( Level.INFO , "enter the summary alcohol yield from distillation" );
        return scanner.nextDouble ( );
    }

    public double readAlcRawMaterialYield(Scanner scanner) {
        log.log ( Level.INFO , "enter the alcohol yield from raw material" );
        return scanner.nextDouble ( );
    }
}

