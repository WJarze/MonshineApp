package MoonshineData.DestillationData;

import exception.NoSuchOptionException;

public enum DistillateOption {
    EXIT ( 0 ),  DISTILLATE_YIELD ( 1 );
    private final int value;

    DistillateOption(int value) {
        this.value = value;
    }

    public static DistillateOption createFromInt(int distillateOption) throws NoSuchOptionException {
        try {
            return DistillateOption.values ( )[ distillateOption ];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException ( "No id option " + distillateOption );
        }
    }
    public double getValue() {
        return value;
    }
}
