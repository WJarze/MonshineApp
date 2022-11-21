package MoonshineDataRead.DataReadEfficiency;

import java.util.Scanner;

public class DataReadEfficiency {
    public int getOptionEfficiency(Scanner scanner) {
        System.out.print ( "0 - EXIT " );
        System.out.print ( "1 - CALCULATE EFFICIENCY " );
        try {
            return scanner.nextInt ( );
        } finally {
            scanner.nextLine ( );
        }
    }
           public double readDistillationAlcYield(Scanner scanner) {
               System.out.println ("enter the summary alcohol yield from distillation" );
               return scanner.nextDouble ();
           }
         public double readAlcRawMaterialYield(Scanner scanner) {
               System.out.println ("enter the alcohol yield from raw material" );
               return scanner.nextDouble ();
           }
        }

