package MoonshineMethod.MethodsCalculatingYield;

import MoonshineData.DataAlcYield.RawMaterial;
import MoonshineDataRead.DataReadYield.DataReadYield;
import MoonshineDataRead.InputReader;
import MoonshineDataRead.InputReaderScanner;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ControlLoopYieldTest {
    Scanner scanner = new Scanner ( System.in );
    InputReader inputReader = new InputReaderScanner ( scanner );

    RawMaterial rawMaterial = new RawMaterial ( );
    AlcMethodYield alcMethod = new AlcMethodYield ( );
    DataReadYield dataReadYield = new DataReadYield ( );
    @Mock
    ControlLoopYield mock;
    @Test
    void alcYieldRawMaterial() {
        mock.alcYieldRawMaterial ( inputReader , dataReadYield , rawMaterial , alcMethod );
        Mockito.verify ( mock , Mockito.times ( 1 ) ).
                alcYieldRawMaterial ( inputReader , dataReadYield , rawMaterial , alcMethod );
    }
}