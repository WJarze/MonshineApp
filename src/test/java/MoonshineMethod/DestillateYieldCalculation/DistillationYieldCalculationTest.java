package MoonshineMethod.DestillateYieldCalculation;

import MoonshineData.DestillationData.Distillate;
import MoonshineDataRead.DataReadDestillate.DataReadDistillate;
import MoonshineDataRead.InputReader;
import MoonshineDataRead.InputReaderScanner;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DistillationYieldCalculationTest {
Scanner scanner = new Scanner ( System.in );
InputReader inputReader = new InputReaderScanner ( scanner);

    Distillate distillate = new Distillate () ;
    DataReadDistillate dataReadDistillate = new DataReadDistillate ();
    DistillationYield distillationYield = new DistillationYield ();
    @Test
    void distYieldCalculation() {
        DistillationYieldCalculation mock = Mockito.mock ( DistillationYieldCalculation.class );
        mock.distYieldCalculation (inputReader, distillate,dataReadDistillate,distillationYield);
        Mockito.verify ( mock , Mockito.times ( 1 ) ).distYieldCalculation (inputReader, distillate,dataReadDistillate,distillationYield );
    }
}