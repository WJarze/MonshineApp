package MoonshineDataRead;

import java.util.Scanner;

public class DataReadMoonshine {
    public int getOption(Scanner scanner) {
        System.out.print ( "0 - EXIT " );
        System.out.print ( "1 - YIELD FROM RAW MATERIAL " );
        System.out.print ( "2 - YIELD FROM DISTILLATION " );
        System.out.print ( "3 - CONCENTRATION CONVERSION " );
        System.out.print ( "4 - TOTAL EFFICIENCY " );
        System.out.println ( " 5 - CHEMICAL PROPERTIES " );
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
