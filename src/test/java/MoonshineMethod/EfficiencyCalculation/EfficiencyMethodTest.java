package MoonshineMethod.EfficiencyCalculation;

import MoonshineData.DataEfficiency.DataEfficiency;
import MoonshineData.DataEfficiency.EfficiencyOption;
import MoonshineDataRead.DataReadEfficiency.DataReadEfficiency;
import MoonshineDataRead.InputReader;
import MoonshineDataRead.InputReaderScanner;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class EfficiencyMethodTest {
    Scanner scanner = new Scanner ( System.in );
    InputReader inputReader = new InputReaderScanner ( scanner );
    DataReadEfficiency dataReadEfficiency = new DataReadEfficiency ( );
    DataEfficiency dataEfficiency = new DataEfficiency ( );
    EfficiencyCalculation efficiencyCalculation = new EfficiencyCalculation ( );

    @Test
    void summaryEfficiency() {
        EfficiencyMethod mock = mock ( EfficiencyMethod.class );
        mock.summaryEfficiency (inputReader,dataReadEfficiency,dataEfficiency,efficiencyCalculation );
        verify ( mock , Mockito.times ( 1 ) ).
                summaryEfficiency (inputReader,dataReadEfficiency,dataEfficiency,efficiencyCalculation );
    }
    @Test
    void testGetEfficiencyAlcChoice() {
        // Utwórz mocki dla inputReader i dataReadEfficiency
        InputReader inputReaderMock = mock(InputReader.class);
        DataReadEfficiency dataReadEfficiencyMock = mock(DataReadEfficiency.class);

        // Skonfiguruj zachowanie mocka dataReadEfficiencyMock
        when(dataReadEfficiencyMock.getOptionEfficiency(inputReaderMock)).thenReturn(1); // Mo¿esz dostosowaæ wartoœæ do swoich potrzeb

        // Utwórz obiekt klasy, której testujemy metodê
        EfficiencyMethod efficiencyMethod = new EfficiencyMethod(); // Za³ó¿my, ¿e klasa nazywa siê YourClass

        // Wywo³aj metodê do przetestowania
        EfficiencyOption result = efficiencyMethod.getEfficiencyAlcChoice (inputReaderMock, dataReadEfficiencyMock);

        // SprawdŸ, czy metoda zwraca oczekiwany wynik
        assertEquals(EfficiencyOption.EFFICIENCY, result); // Zast¹p SOME_OPTION odpowiedni¹ wartoœci¹ zdefiniowan¹ w Twojej klasie EfficiencyOption

        // Zweryfikuj, czy metoda getOptionEfficiency zosta³a wywo³ana na dataReadEfficiencyMock
        verify(dataReadEfficiencyMock, times(1)).getOptionEfficiency(inputReaderMock);
    }
}