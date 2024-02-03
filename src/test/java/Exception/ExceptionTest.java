package Exception;

import MoonshineDataRead.DataReadConcentrationAlc.DataReadConcentrationAlc;
import MoonshineDataRead.DataReadDestillate.DataReadDistillate;
import MoonshineDataRead.InputReader;
import exception.NoBetweenPercents;
import exception.NoPositiveNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExceptionTest {

    InputReader inputReaderMock = mock ( InputReader.class );
    DataReadDistillate dataReadDistillate = new DataReadDistillate ( );

    @ParameterizedTest
    @ValueSource(doubles = {-101 , -100 , -1 , -0.001 , 101 , 150})
    void should_be_throw_NoBetweenPercents(double value) {
        // When/Then
        assertThrows ( NoBetweenPercents.class , () -> DataReadConcentrationAlc.concentrationValidator ( value ) );
        assertThrows ( NoBetweenPercents.class , () -> dataReadDistillate.isPercentForRange ( value ) );
    }

    @ParameterizedTest
    @ValueSource(doubles = {-101 , -100 , -1 , -0.001})
    void should_be_throw_NoPositiveNumberException(double value) {
        assertThrows ( NoPositiveNumberException.class , () -> dataReadDistillate.isMassPositive ( value ) );

    }


}