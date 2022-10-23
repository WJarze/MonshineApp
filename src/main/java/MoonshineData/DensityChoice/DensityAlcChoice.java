package MoonshineData.DensityChoice;


import exception.NoSuchOptionException;

public enum DensityAlcChoice {
    EXIT ( 0 ),  DENSITY_ALCOHOL ( 1 ), DENSITY_PURE_ALCOHOL ( 2 ),;
    private final int value;

    DensityAlcChoice(int value) {
        this.value = value;
    }

    public static DensityAlcChoice createFromInt(int densityAlcChoice) throws NoSuchOptionException {
        try {
            return DensityAlcChoice.values ( )[ densityAlcChoice ];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException ( "No id option " + densityAlcChoice );
        }
    }
    public double getValue() {
        return value;
    }
}
