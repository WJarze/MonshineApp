package MoonshineDataRead;

import MoonshineDataRead.DataReadConcentrationAlc.DataReadConcentrationAlc;
import MoonshineDataRead.DataReadDestillate.DataReadDistillate;
import MoonshineDataRead.DataReadEfficiency.DataReadEfficiency;
import MoonshineDataRead.DataReadYield.DataReadYield;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class MoonshineDataReadTest {
    InputReader inputReaderMock = mock ( InputReader.class );

    @DisplayName("should be weight concentration")
    @Test
    void concentration() {
        DataReadConcentrationAlc io = new DataReadConcentrationAlc ( );

        double expected = 4;

        when ( io.concentration ( inputReaderMock ) ).thenReturn ( expected );

        //When
        double result = io.concentration ( inputReaderMock ) * 100;

        //Then
        assertEquals ( expected , result );
    }

    @DisplayName("should be return tail mass")
    @Test
    void getTailsMass() {
        DataReadDistillate io = new DataReadDistillate ( );

        double expected = 4;

        when ( io.getTailsMass ( inputReaderMock ) ).thenReturn ( expected );

        //When
        double result = io.getTailsMass ( inputReaderMock );

        //Then
        assertEquals ( expected , result );

    }

    @DisplayName("should be return tail percent")
    @Test
    void should_be_return_tail_percent() {
        DataReadDistillate io = new DataReadDistillate ( );
        double expected = 4;

        when ( io.getTailsPercent ( inputReaderMock ) ).thenReturn ( expected );

        //When
        double result = io.getTailsPercent ( inputReaderMock );

        //Then
        assertEquals ( expected , result );
    }
      @DisplayName ( "should be return heads mass" )
    @Test
    void getHeadsMass() {
        DataReadDistillate io = new DataReadDistillate ( );
          double expected = 4;

          when ( io.getHeadsMass ( inputReaderMock ) ).thenReturn ( expected );

          //When
          double result = io.getHeadsMass ( inputReaderMock );

          //Then
          assertEquals ( expected , result );
    }
    @DisplayName ( "should_be_return_heads_percent" )
    @Test
    void getHeadsPercent() {
        DataReadDistillate io = new DataReadDistillate ( );
        double expected = 4;

        when ( io.getHeadsPercent ( inputReaderMock ) ).thenReturn ( expected );

        //When
        double result = io.getHeadsPercent ( inputReaderMock );

        //Then
        assertEquals ( expected , result );
    }
    @DisplayName("should be return foreshots mass")
    @Test
    void getForeshotsMass() {
        DataReadDistillate io = new DataReadDistillate ( );
        double expected = 4;

        when ( io.getForeshotsMass ( inputReaderMock ) ).thenReturn ( expected );

        //When
        double result = io.getForeshotsMass ( inputReaderMock );

        //Then
        assertEquals ( expected , result );
    }
    @DisplayName ( "should be return foreshots percent" )
    @Test
    void getForeshotsPercent() {
        DataReadDistillate io = new DataReadDistillate ( );
        double expected = 4;

        when ( io.getForeshotsPercent ( inputReaderMock ) ).thenReturn ( expected );

        //When
        double result = io.getForeshotsPercent ( inputReaderMock );

        //Then
        assertEquals ( expected , result );
    }
    @DisplayName ( "should be return distillation alc yield" )
    @Test
    void readDistillationAlcYield() {
        DataReadEfficiency io = new DataReadEfficiency ( );
        double expected = 4;

        when ( io.readDistillationAlcYield ( inputReaderMock ) ).thenReturn ( expected );

        //When
        double result = io.readDistillationAlcYield ( inputReaderMock );

        //Then
        assertEquals ( expected , result );
    }
    @DisplayName ( "should be return alc raw material yield" )
    @Test
    void readAlcRawMaterialYield() {
        DataReadEfficiency io = new DataReadEfficiency ( );
        double expected = 4;

        when ( io.readAlcRawMaterialYield ( inputReaderMock ) ).thenReturn ( expected );

        //When
        double result = io.readAlcRawMaterialYield ( inputReaderMock );

        //Then
        assertEquals ( expected , result );
    }
    @DisplayName ( "should be return raw material mass" )
    @Test
    void rawMaterialMass() {
        DataReadYield io = new DataReadYield ( );
        double expected = 4;

        when ( io.rawMaterialMass ( inputReaderMock ) ).thenReturn ( expected );

        //When
        double result = io.rawMaterialMass ( inputReaderMock );

        //Then
        assertEquals ( expected , result );
    }
}
