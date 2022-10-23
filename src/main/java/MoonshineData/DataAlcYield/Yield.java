package MoonshineData.DataAlcYield;

import MoonshineData.MoonshineData;
import exception.NoSuchOptionException;


public enum Yield {
    EXIT ( 0 ),  SUGAR ( 0.577 ), WHEAT ( 0.355 ), CORN ( 0.348 ), POTATO ( 0.094 );
    private final double value;

    Yield(double value) {
        this.value = value;
    }

    public static Yield createFromInt(int yield) throws NoSuchOptionException {
        try {
            return Yield.values ( )[ yield ];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException ( "No id option " + yield );
        }
    }

    public double getValue() {
        return value;
    }
}
