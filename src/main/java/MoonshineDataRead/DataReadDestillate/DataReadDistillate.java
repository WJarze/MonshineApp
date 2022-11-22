package MoonshineDataRead.DataReadDestillate;

import exception.NoBetweenPercents;
import exception.NoPositiveNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReadDistillate {
    public static final Logger log = Logger.getLogger (DataReadDistillate.class.getName ( ));
    public int getDistillateOption(Scanner scanner) {
        log.log (Level.INFO ,  """
        
        0 - EXIT\s
        1 - DISTILLATE YIELD\s """ );
        try {
            return scanner.nextInt ( );
        } finally {
            scanner.nextLine ( );
        }
    }

    public double getTailsMass(Scanner scanner) {
        log.log ( Level.INFO ,  "enter the tails mass" );
        boolean err = true;
        double tailMass = 0;
        do {
            try {
                tailMass = scanner.nextDouble ( );
                if ( tailMass < 0 ) {
                    throw new NoPositiveNumberException ( "Number must be >= 0, no number " + tailMass );
                }
                err = false;
            } catch (InputMismatchException e) {
                log.log (Level.INFO , "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoPositiveNumberException e) {
                log.log (Level.INFO ,  e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return tailMass;
    }

    public double getTailsPercent(Scanner scanner) {
        log.log (Level.INFO ,  "enter the tails percent" );
        boolean err = true;
        double tailsPercent = 0;
        do {
            try {
                tailsPercent = scanner.nextDouble ( );
                if ( tailsPercent < 0 || tailsPercent > 100 ) {
                    throw new NoBetweenPercents ( "Choose a number between 0 - 100, no number " + tailsPercent );
                }
                err = false;
            } catch (InputMismatchException e) {
                log.log (Level.INFO ,  "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoBetweenPercents e) {
                log.log (Level.INFO ,  e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return tailsPercent;
    }

    public double getHeadsMass(Scanner scanner) {
        log.log (Level.INFO ,  "enter the heads mass" );
        boolean err = true;
        double HeadsMass = 0;
        do {
            try {
                HeadsMass = scanner.nextDouble ( );
                if ( HeadsMass < 0 ) {
                    throw new NoPositiveNumberException ( "Number must be >= 0, no number " + HeadsMass );
                }
                err = false;
            } catch (InputMismatchException e) {
                log.log (Level.INFO ,  "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoPositiveNumberException e) {
                log.log (Level.INFO ,  e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return HeadsMass;
    }

    public double getHeadsPercent(Scanner scanner) {
        log.log (Level.INFO ,  "enter the heads percent" );
        boolean err = true;
        double headsPercent = 0;
        do {
            try {
                headsPercent = scanner.nextDouble ( );
                if ( headsPercent < 0 || headsPercent > 100 ) {
                    throw new NoBetweenPercents ( "Choose a number between 0 - 100, no number " + headsPercent );
                }
                err = false;
            } catch (InputMismatchException e) {
                log.log (Level.INFO ,  "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoBetweenPercents e) {
                log.log (Level.INFO ,  e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return headsPercent;
    }

    public double getForeshotsMass(Scanner scanner) {
        log.log (Level.INFO ,  "enter the foreshots mass" );
        boolean err = true;
        double forestsMass = 0;
        do {
            try {
                forestsMass = scanner.nextDouble ( );
                if ( forestsMass < 0 ) {
                    throw new NoPositiveNumberException ( "Number must be >= 0, no number " + forestsMass );
                }
                err = false;
            } catch (InputMismatchException e) {
                log.log (Level.INFO , "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoPositiveNumberException e) {
                log.log (Level.INFO ,  e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return forestsMass;
    }

    public double getForeshotsPercent(Scanner scanner) {
        log.log (Level.INFO ,  "enter the foreshots percent" );
        boolean err = true;
        double foreshotsPercent = 0;
        do {
            try {
                foreshotsPercent = scanner.nextDouble ( );
                if ( foreshotsPercent < 0 || foreshotsPercent > 100 ) {
                    throw new NoBetweenPercents ( "Choose a number between 0 - 100, no number " + foreshotsPercent );
                }
                err = false;
            } catch (InputMismatchException e) {
                log.log (Level.INFO ,  "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoBetweenPercents e) {
                log.log (Level.INFO ,  e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return foreshotsPercent;
    }

}
