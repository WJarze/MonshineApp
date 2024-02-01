package MoonshineDataRead.DataReadEfficiency;

import MoonshineDataRead.InputReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReadEfficiency {
    public static final Logger log = Logger.getLogger ( DataReadEfficiency.class.getName ( ) );

    public int getOptionEfficiency(InputReader inputReader) {
        log.log ( Level.INFO , """
                        
                0 - EXIT\s
                1 - CALCULATE EFFICIENCY\s """ );
        try {
            return inputReader.nextInt ( );
        } finally {
            inputReader.nextLine ( );
        }
    }

    public double readDistillationAlcYield(InputReader inputReader) {
        log.log ( Level.INFO , "enter the summary alcohol yield from distillation" );
        return inputReader.nextDouble ( );
    }

    public double readAlcRawMaterialYield(InputReader inputReader) {
        log.log ( Level.INFO , "enter the alcohol yield from raw material" );
        return inputReader.nextDouble ( );
    }
}

