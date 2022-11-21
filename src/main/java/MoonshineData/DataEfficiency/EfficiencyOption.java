package MoonshineData.DataEfficiency;

import MoonshineData.DensityChoice.DensityAlcChoice;
import exception.NoSuchOptionException;

public enum EfficiencyOption {
    EXIT ( 0 ),  EFFICIENCY ( 1 );
    private final int value;

    EfficiencyOption(int value) {
        this.value = value;
    }

    public static EfficiencyOption createFromInt(int efficiencyOption) throws NoSuchOptionException {
        try {
            return EfficiencyOption.values ( )[ efficiencyOption ];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException ( "No id option " + efficiencyOption );
        }
    }
    public double getValue() {
        return value;
    }
}
