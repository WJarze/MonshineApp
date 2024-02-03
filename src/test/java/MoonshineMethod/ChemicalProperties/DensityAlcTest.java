package MoonshineMethod.ChemicalProperties;

import MoonshineData.DataConcentrationAlc.AlcConcentration;
import MoonshineData.DataConcentrationAlc.Coefficient;
import MoonshineData.DensityChoice.DensityAlcChoice;
import MoonshineDataRead.DataReadConcentrationAlc.DataReadConcentrationAlc;
import MoonshineDataRead.DensityOption.OptionDensity;
import MoonshineDataRead.InputReader;
import MoonshineMethod.ModelConcentrationAlc.AlcCalculation;
import MoonshineMethod.ModelConcentrationAlc.InterpolationFunction;
import MoonshineMethod.ModelConcentrationAlc.InterpolationFunctionPureAlc;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DensityAlcTest {
    @Test
    void should_return_msgPureAlc(){
        // Przygotowanie mocków
        DataReadConcentrationAlc dataReadConcentrationAlcMock = mock(DataReadConcentrationAlc.class);
        InterpolationFunctionPureAlc interpolationPureAlcMock = mock(InterpolationFunctionPureAlc.class);
        AlcConcentration alcConcentrationMock = mock(AlcConcentration.class);
        Coefficient coefficientMock = mock(Coefficient.class);
        AlcCalculation alcCalculationMock = mock(AlcCalculation.class);
        // Przygotowanie danych testowych
        when(alcCalculationMock.densityPureAlc (  interpolationPureAlcMock, alcConcentrationMock, coefficientMock))
                .thenReturn(25.5); // Przyk³adowa wartoœæ gêstoœci

        // Utworzenie obiektu klasy zawieraj¹cej metodê do przetestowania
        DensityAlc densityAlc = new DensityAlc ();

        // Wywo³anie metody do przetestowania
        String result = DensityAlc.msgDensityPureAlc (interpolationPureAlcMock, alcConcentrationMock, coefficientMock, alcCalculationMock);

        // Sprawdzenie, czy metoda zwraca oczekiwany wynik
        assertEquals("25,50 kg/m3\n", result);

        // Sprawdzenie, czy metoda alcCalculation.density by³a wywo³ywana z oczekiwanymi argumentami
        verify(alcCalculationMock).densityPureAlc( interpolationPureAlcMock, alcConcentrationMock, coefficientMock);

    }


    @Test
void should_return_msg(){
    // Przygotowanie mocków
    InputReader inputReaderMock = mock(InputReader.class);
    DataReadConcentrationAlc dataReadConcentrationAlcMock = mock(DataReadConcentrationAlc.class);
    InterpolationFunction interpolationFunctionMock = mock(InterpolationFunction.class);
    AlcConcentration alcConcentrationMock = mock(AlcConcentration.class);
    Coefficient coefficientMock = mock(Coefficient.class);
    AlcCalculation alcCalculationMock = mock(AlcCalculation.class);

    // Przygotowanie danych testowych
    when(alcCalculationMock.density(inputReaderMock, dataReadConcentrationAlcMock, interpolationFunctionMock, alcConcentrationMock, coefficientMock))
            .thenReturn(25.5); // Przyk³adowa wartoœæ gêstoœci

    // Utworzenie obiektu klasy zawieraj¹cej metodê do przetestowania
    DensityAlc densityAlc = new DensityAlc ();

    // Wywo³anie metody do przetestowania
    String result = DensityAlc.msgDensityAlc (inputReaderMock, dataReadConcentrationAlcMock, interpolationFunctionMock, alcConcentrationMock, coefficientMock, alcCalculationMock);

    // Sprawdzenie, czy metoda zwraca oczekiwany wynik
    assertEquals("25,50 kg/m3\n", result);

    // Sprawdzenie, czy metoda alcCalculation.density by³a wywo³ywana z oczekiwanymi argumentami
    verify(alcCalculationMock).density(inputReaderMock, dataReadConcentrationAlcMock, interpolationFunctionMock, alcConcentrationMock, coefficientMock);

}

    @Test
    void should_return_densityChoice(){
        // Przygotowanie mocków
        InputReader inputReaderMock = mock(InputReader.class);
        OptionDensity optionDensityMock = mock(OptionDensity.class);
        // Przygotowanie danych testowych
        when(optionDensityMock.getOptionDensity(inputReaderMock)).thenReturn(1); // Przyk³adowa opcja

        // Utworzenie obiektu klasy zawieraj¹cej metodê do przetestowania
        DensityAlc densityAlc = new DensityAlc();

        // Wywo³anie metody do przetestowania
        DensityAlcChoice result = densityAlc.getDensityAlcChoice(inputReaderMock, optionDensityMock);

        // Sprawdzenie, czy metoda zwraca oczekiwany wynik
        assertEquals(DensityAlcChoice.DENSITY_ALCOHOL, result); // Zast¹p SOME_VALUE odpowiedni¹ wartoœci¹ z enuma

        // Sprawdzenie, czy logowanie nie zawiera b³êdów
        verify(inputReaderMock, Mockito.never()).nextLine(); // Nie powinno byæ b³êdów wejœcia
        verify(inputReaderMock, Mockito.never()).nextInt(); // Nie powinno byæ b³êdów wejœcia
        verify(optionDensityMock).getOptionDensity(inputReaderMock); // Sprawdzenie, czy metoda by³a wywo³ywana
    }

}