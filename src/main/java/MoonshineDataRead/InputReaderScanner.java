package MoonshineDataRead;

import java.util.Scanner;

public class InputReaderScanner implements InputReader{

    Scanner scanner;

    public InputReaderScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String nextLine() {
        return scanner.nextLine ( );
    }

    @Override
    public int nextInt() {
        return scanner.nextInt ();
    }

    @Override
    public double nextDouble() {
        return scanner.nextDouble ( );
    }

    @Override
    public void close() {
        scanner.close ();
    }
}
