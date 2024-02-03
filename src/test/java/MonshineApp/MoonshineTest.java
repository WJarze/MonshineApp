package MonshineApp;

import MoonshineDataRead.InputReader;
import org.junit.jupiter.api.Test;
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

        Mockito.when(inputReader.nextLine()).thenReturn("1");

        // When
        //Then
        assertDoesNotThrow(() -> moonshine.moonshineAppMethod());

    }
}