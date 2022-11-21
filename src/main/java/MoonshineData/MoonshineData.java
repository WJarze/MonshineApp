package MoonshineData;

import exception.NoSuchOptionException;

public enum MoonshineData {
    EXIT ( 0 ), YIELD_FROM_RAW_MATERIAL ( 1 ), YIELD_FROM_DISTILLATION ( 2 ), CONCENTRATION_CONVERSION ( 3 ), TOTAL_EFFICIENCY ( 4 ), CHEMICAL_PROPERTIES ( 5 );
    private final int value;

    MoonshineData(int value) {
        this.value = value;
    }

    public static MoonshineData createFromInt(int moonshineData) throws NoSuchOptionException {
        try {
            return MoonshineData.values ( )[ moonshineData ];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException ( "No id option " + moonshineData );
        }
    }

}
