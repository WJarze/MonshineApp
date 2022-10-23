package MoonshineData.DataConcentrationAlc;

import exception.NoSuchOptionException;

public enum ConcentrationOption {
    EXIT ( 0 ),  WEIGHT ( 1 ), VOLUME ( 2 ),;
    private final int value;
    ConcentrationOption(int value) {
        this.value = value;
    }
    public static ConcentrationOption createFromInt(int concentrationOption) throws NoSuchOptionException {
        try {
            return ConcentrationOption.values ( )[ concentrationOption ];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException ( "No id option " + concentrationOption );
        }
    }
}
