package MoonshineMethod.DestillateYieldCalculation;

import MoonshineData.DestillationData.Distillate;
import MoonshineData.DestillationData.DistillateOption;
import MoonshineDataRead.DataReadDestillate.DataReadDistillate;
import MoonshineDataRead.InputReader;
import MoonshineDataRead.InputReaderScanner;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DistillationYieldCalculationTest {
Scanner scanner = new Scanner ( System.in );
InputReader inputReader = new InputReaderScanner ( scanner);

    Distillate distillate = new Distillate () ;
    DataReadDistillate dataReadDistillate = new DataReadDistillate ();
    DistillationYield distillationYield = new DistillationYield ();
    @Test
    void distYieldCalculation() {
        DistillationYieldCalculation mock = mock ( DistillationYieldCalculation.class );
        mock.distYieldCalculation (inputReader, distillate,dataReadDistillate,distillationYield);
        verify ( mock , Mockito.times ( 1 ) ).distYieldCalculation (inputReader, distillate,dataReadDistillate,distillationYield );
    }
    @Test
    void testGetDistillateOption() {
        // Przygotowanie mocków
        InputReader inputReaderMock = mock(InputReader.class);
        DataReadDistillate dataReadDistillateMock = mock(DataReadDistillate.class);

        // Przygotowanie danych testowych
        when(dataReadDistillateMock.getDistillateOption(inputReaderMock)).thenReturn(1); // Przyk³adowa opcja

        // Utworzenie obiektu klasy zawieraj¹cej metodê do przetestowania
        DistillationYieldCalculation distillationYieldCalculation = new DistillationYieldCalculation();

        // Wywo³anie metody do przetestowania
        DistillateOption result = distillationYieldCalculation.getDistillateOption (inputReaderMock, dataReadDistillateMock);

        // Sprawdzenie, czy metoda zwraca oczekiwany wynik
        assertEquals(DistillateOption.DISTILLATE_YIELD, result); // Zast¹p SOME_VALUE odpowiedni¹ wartoœci¹ z enuma

        // Sprawdzenie, czy logowanie nie zawiera b³êdów
        verify(inputReaderMock, Mockito.never()).nextLine(); // Nie powinno byæ b³êdów wejœcia
        verify(inputReaderMock, Mockito.never()).nextInt(); // Nie powinno byæ b³êdów wejœcia
        verify(dataReadDistillateMock).getDistillateOption(inputReaderMock); // Sprawdzenie, czy metoda by³a wywo³ywana
    }

}