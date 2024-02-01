package MonshineApp;

import MoonshineDataRead.InputReader;
import MoonshineDataRead.InputReaderScanner;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

class MoonshineTest {

    @Test
    void moonshineAppMethod() {
        Moonshine mock = mock ( Moonshine.class );
        mock.moonshineAppMethod ( );
        Mockito.verify ( mock , Mockito.times ( 1 ) ).moonshineAppMethod ( );
    }
    @Test
    void should_MoonshineAppMethod() {
        // Given
        Moonshine moonshine = Mockito.spy(new Moonshine());
        Mockito.doNothing().when(moonshine).moonshineAppMethod();

        // When Then
        assertDoesNotThrow(() -> moonshine.moonshineAppMethod());

    }


    @Test
    void testMoonshineAppMethod() {
        InputReader inputReader = mock(InputReader.class);
        Moonshine moonshine = new Moonshine (inputReader);
        // Przygotowanie mocków
        Mockito.when(inputReader.nextLine()).thenReturn("someInput"); // Symulacja wejœcia u¿ytkownika

        // Testowanie, czy nie ma wyj¹tków
        assertDoesNotThrow(() -> moonshine.moonshineAppMethod());

        // Mo¿esz równie¿ dodaæ asercje sprawdzaj¹ce inne aspekty, takie jak stan obiektów, które s¹ u¿ywane w metodzie moonshineAppMethod().
    }
}