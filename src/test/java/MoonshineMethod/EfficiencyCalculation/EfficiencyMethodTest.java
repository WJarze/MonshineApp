package MoonshineMethod.EfficiencyCalculation;

import MoonshineData.DataEfficiency.DataEfficiency;
import MoonshineDataRead.DataReadEfficiency.DataReadEfficiency;
import MoonshineDataRead.InputReader;
import MoonshineDataRead.InputReaderScanner;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EfficiencyMethodTest {
    Scanner scanner = new Scanner ( System.in );
    InputReader inputReader = new InputReaderScanner ( scanner );
    DataReadEfficiency dataReadEfficiency = new DataReadEfficiency ( );
    DataEfficiency dataEfficiency = new DataEfficiency ( );
    EfficiencyCalculation efficiencyCalculation = new EfficiencyCalculation ( );

    @Test
    void summaryEfficiency() {
        EfficiencyMethod mock = Mockito.mock ( EfficiencyMethod.class );
        mock.summaryEfficiency (inputReader,dataReadEfficiency,dataEfficiency,efficiencyCalculation );
        Mockito.verify ( mock , Mockito.times ( 1 ) ).
                summaryEfficiency (inputReader,dataReadEfficiency,dataEfficiency,efficiencyCalculation );
    }
}