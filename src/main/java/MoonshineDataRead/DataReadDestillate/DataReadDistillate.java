package MoonshineDataRead.DataReadDestillate;

import exception.NoBetweenPercents;
import exception.NoPositiveNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReadDistillate {
    public int getDistillateOption(Scanner scanner) {
        System.out.print ( "0 - EXIT " );
        System.out.print ( "1 - DISTILLATE YIELD " );
        try {
            return scanner.nextInt ( );
        } finally {
            scanner.nextLine ( );
        }
    }

    public double getTailsMass(Scanner scanner) {
        System.out.println ( "enter the tails mass" );
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
                System.out.println ( "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoPositiveNumberException e) {
                System.out.println ( e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return tailMass;
    }

    public double getTailsPercent(Scanner scanner) {
        System.out.println ( "enter the tails percent" );
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
                System.out.println ( "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoBetweenPercents e) {
                System.out.println ( e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return tailsPercent;
    }

    public double getHeadsMass(Scanner scanner) {
        System.out.println ( "enter the heads mass" );
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
                System.out.println ( "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoPositiveNumberException e) {
                System.out.println ( e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return HeadsMass;
    }

    public double getHeadsPercent(Scanner scanner) {
        System.out.println ( "enter the heads percent" );
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
                System.out.println ( "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoBetweenPercents e) {
                System.out.println ( e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return headsPercent;
    }

    public double getForeshotsMass(Scanner scanner) {
        System.out.println ( "enter the foreshots mass" );
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
                System.out.println ( "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoPositiveNumberException e) {
                System.out.println ( e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return forestsMass;
    }

    public double getForeshotsPercent(Scanner scanner) {
        System.out.println ( "enter the foreshots percent" );
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
                System.out.println ( "Select the right number: " );
                scanner.nextLine ( );
            } catch (NoBetweenPercents e) {
                System.out.println ( e.getMessage ( ) );
                scanner.nextLine ( );
            }
        } while (err);
        return foreshotsPercent;
    }

}
