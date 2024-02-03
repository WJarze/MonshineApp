package MoonshineDataRead.DataReadDestillate;

import MoonshineDataRead.InputReader;
import exception.NoBetweenPercents;
import exception.NoPositiveNumberException;

import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReadDistillate {
    public static final Logger log = Logger.getLogger ( DataReadDistillate.class.getName ( ) );

    public int getDistillateOption(InputReader inputReader) {
        log.log ( Level.INFO , """
                        
                0 - EXIT\s
                1 - DISTILLATE YIELD \s""" );
        try {
            return inputReader.nextInt ( );
        } finally {
            inputReader.nextLine ( );
        }
    }

    public double getTailsMass(InputReader inputReader) {
        log.log ( Level.INFO , "enter the tails mass" );
        boolean err = true;
        double tailMass = 0;
        do {
            try {
                tailMass = inputReader.nextDouble ( );
                isMassPositive ( tailMass );
                err = false;
            } catch (InputMismatchException e) {
                log.log ( Level.INFO , "Select the right number: " );
                inputReader.nextLine ( );
            } catch (NoPositiveNumberException e) {
                log.log ( Level.INFO , e.getMessage ( ) );
                inputReader.nextLine ( );
            }
        } while (err);
        return tailMass;
    }




    public double getTailsPercent(InputReader inputReader) {
        log.log ( Level.INFO , "enter the tails percent" );
        boolean err = true;
        double tailsPercent = 0;
        do {
            try {
                tailsPercent = inputReader.nextDouble ( );
                isPercentForRange ( tailsPercent );
                err = false;
            } catch (InputMismatchException e) {
                log.log ( Level.INFO , "Select the right number: " );
                inputReader.nextLine ( );
            } catch (NoBetweenPercents e) {
                log.log ( Level.INFO , e.getMessage ( ) );
                inputReader.nextLine ( );
            }
        } while (err);
        return tailsPercent;
    }
    public double getHeadsMass(InputReader inputReader) {
        log.log ( Level.INFO , "enter the heads mass" );
        boolean err = true;
        double headsMass = 0;
        do {
            try {
                headsMass = inputReader.nextDouble ( );
                isMassPositive(headsMass);

                err = false;
            } catch (InputMismatchException e) {
                log.log ( Level.INFO , "Select the right number: " );
                inputReader.nextLine ( );
            } catch (NoPositiveNumberException e) {
                log.log ( Level.INFO , e.getMessage ( ) );
                inputReader.nextLine ( );
            }
        } while (err);
        return headsMass;
    }

    public double getHeadsPercent(InputReader inputReader) {
        log.log ( Level.INFO , "enter the heads percent" );
        boolean err = true;
        double headsPercent = 0;
        do {
            try {
                headsPercent = inputReader.nextDouble ( );
                isPercentForRange ( headsPercent );
                err = false;
            } catch (InputMismatchException e) {
                log.log ( Level.INFO , "Select the right number: " );
                inputReader.nextLine ( );
            } catch (NoBetweenPercents e) {
                log.log ( Level.INFO , e.getMessage ( ) );
                inputReader.nextLine ( );
            }
        } while (err);
        return headsPercent;
    }

    public double getForeshotsMass(InputReader inputReader) {
        log.log ( Level.INFO , "enter the foreshots mass" );
        boolean err = true;
        double forestsMass = 0;
        do {
            try {
                forestsMass = inputReader.nextDouble ( );
                isMassPositive(forestsMass);
                err = false;
            } catch (InputMismatchException e) {
                log.log ( Level.INFO , "Select the right number: " );
                inputReader.nextLine ( );
            } catch (NoPositiveNumberException e) {
                log.log ( Level.INFO , e.getMessage ( ) );
                inputReader.nextLine ( );
            }
        } while (err);
        return forestsMass;
    }

    public double getForeshotsPercent(InputReader inputReader) {
        log.log ( Level.INFO , "enter the foreshots percent" );
        boolean err = true;
        double foreshotsPercent = 0;
        do {
            try {
                foreshotsPercent = inputReader.nextDouble ( );
                isPercentForRange ( foreshotsPercent );
                err = false;
            } catch (InputMismatchException e) {
                log.log ( Level.INFO , "Select the right number: " );
                inputReader.nextLine ( );
            } catch (NoBetweenPercents e) {
                log.log ( Level.INFO , e.getMessage ( ) );
                inputReader.nextLine ( );
            }
        } while (err);
        return foreshotsPercent;
    }
    public void isMassPositive(double enteredMass) {
        if ( enteredMass < 0 ) {
            throw new NoPositiveNumberException ( "Number must be >= 0, no number " + enteredMass );
        }
    }
    public   void isPercentForRange(double percent) {
        if ( percent < 0 || percent > 100 ) {
            throw new NoBetweenPercents ( "Choose a number between 0 - 100, no number " + percent );
        }
    }
}
