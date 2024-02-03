package MoonshineMethod.MethodsCalculatingYield;

import MoonshineData.DataAlcYield.RawMaterial;
import MoonshineData.DataAlcYield.Yield;
import MoonshineDataRead.DataReadYield.DataReadYield;
import MoonshineDataRead.InputReader;
import MoonshineDataRead.InputReaderScanner;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ControlLoopYieldTest {

    @Mock
    ControlLoopYield mock;

    @Test
    void testGetMoonshineData() {
        // Utwórz mocki dla inputReader i dataReadYield
        InputReader inputReaderMock = mock(InputReader.class);
        DataReadYield dataReadYieldMock = mock(DataReadYield.class);

        // Skonfiguruj zachowanie mocka dataReadYieldMock
        when(dataReadYieldMock.getOptionYield(inputReaderMock)).thenReturn(1); // Mo¿esz dostosowaæ wartoœæ do swoich potrzeb

        // Utwórz obiekt klasy, której testujemy metodê
        ControlLoopYield controlLoopYield = new ControlLoopYield(); // Za³ó¿my, ¿e klasa nazywa siê YourClass

        // Wywo³aj metodê do przetestowania
        Yield result = controlLoopYield.getMoonshineData(inputReaderMock, dataReadYieldMock);

        // SprawdŸ, czy metoda zwraca oczekiwany wynik
        assertEquals(Yield.SUGAR, result); // Zast¹p SOME_OPTION odpowiedni¹ wartoœci¹ zdefiniowan¹ w Twojej klasie Yield

        // Zweryfikuj, czy metoda getOptionYield zosta³a wywo³ana na dataReadYieldMock
        verify(dataReadYieldMock, times(1)).getOptionYield(inputReaderMock);
    }
}