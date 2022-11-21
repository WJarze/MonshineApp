package MoonshineDataRead.DensityOption;

import java.util.Scanner;

public class OptionDensity {
    public int getOptionDensity(Scanner scanner) {
        System.out.print ( "0 - EXIT " );
        System.out.print ( "1 - DENSITY ALCOHOL " );
        System.out.println ( "2 - DENSITY PURE ALCOHOL " );

        try {
            return scanner.nextInt ( );
        } finally {
            scanner.nextLine ( );
        }
    }
}
