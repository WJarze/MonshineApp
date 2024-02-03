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
        // Przygotowanie mock�w
        DataReadConcentrationAlc dataReadConcentrationAlcMock = mock(DataReadConcentrationAlc.class);
        InterpolationFunctionPureAlc interpolationPureAlcMock = mock(InterpolationFunctionPureAlc.class);
        AlcConcentration alcConcentrationMock = mock(AlcConcentration.class);
        Coefficient coefficientMock = mock(Coefficient.class);
        AlcCalculation alcCalculationMock = mock(AlcCalculation.class);
        // Przygotowanie danych testowych
        when(alcCalculationMock.densityPureAlc (  interpolationPureAlcMock, alcConcentrationMock, coefficientMock))
                .thenReturn(25.5); // Przyk�adowa warto�� g�sto�ci

        // Utworzenie obiektu klasy zawieraj�cej metod� do przetestowania
        DensityAlc densityAlc = new DensityAlc ();

        // Wywo�anie metody do przetestowania
        String result = DensityAlc.msgDensityPureAlc (interpolationPureAlcMock, alcConcentrationMock, coefficientMock, alcCalculationMock);

        // Sprawdzenie, czy metoda zwraca oczekiwany wynik
        assertEquals("25,50 kg/m3\n", result);

        // Sprawdzenie, czy metoda alcCalculation.density by�a wywo�ywana z oczekiwanymi argumentami
        verify(alcCalculationMock).densityPureAlc( interpolationPureAlcMock, alcConcentrationMock, coefficientMock);

    }


    @Test
void should_return_msg(){
    // Przygotowanie mock�w
    InputReader inputReaderMock = mock(InputReader.class);
    DataReadConcentrationAlc dataReadConcentrationAlcMock = mock(DataReadConcentrationAlc.class);
    InterpolationFunction interpolationFunctionMock = mock(InterpolationFunction.class);
    AlcConcentration alcConcentrationMock = mock(AlcConcentration.class);
    Coefficient coefficientMock = mock(Coefficient.class);
    AlcCalculation alcCalculationMock = mock(AlcCalculation.class);

    // Przygotowanie danych testowych
    when(alcCalculationMock.density(inputReaderMock, dataReadConcentrationAlcMock, interpolationFunctionMock, alcConcentrationMock, coefficientMock))
            .thenReturn(25.5); // Przyk�adowa warto�� g�sto�ci

    // Utworzenie obiektu klasy zawieraj�cej metod� do przetestowania
    DensityAlc densityAlc = new DensityAlc ();

    // Wywo�anie metody do przetestowania
    String result = DensityAlc.msgDensityAlc (inputReaderMock, dataReadConcentrationAlcMock, interpolationFunctionMock, alcConcentrationMock, coefficientMock, alcCalculationMock);

    // Sprawdzenie, czy metoda zwraca oczekiwany wynik
    assertEquals("25,50 kg/m3\n", result);

    // Sprawdzenie, czy metoda alcCalculation.density by�a wywo�ywana z oczekiwanymi argumentami
    verify(alcCalculationMock).density(inputReaderMock, dataReadConcentrationAlcMock, interpolationFunctionMock, alcConcentrationMock, coefficientMock);

}

    @Test
    void should_return_densityChoice(){
        // Przygotowanie mock�w
        InputReader inputReaderMock = mock(InputReader.class);
        OptionDensity optionDensityMock = mock(OptionDensity.class);
        // Przygotowanie danych testowych
        when(optionDensityMock.getOptionDensity(inputReaderMock)).thenReturn(1); // Przyk�adowa opcja

        // Utworzenie obiektu klasy zawieraj�cej metod� do przetestowania
        DensityAlc densityAlc = new DensityAlc();

        // Wywo�anie metody do przetestowania
        DensityAlcChoice result = densityAlc.getDensityAlcChoice(inputReaderMock, optionDensityMock);

        // Sprawdzenie, czy metoda zwraca oczekiwany wynik
        assertEquals(DensityAlcChoice.DENSITY_ALCOHOL, result); // Zast�p SOME_VALUE odpowiedni� warto�ci� z enuma

        // Sprawdzenie, czy logowanie nie zawiera b��d�w
        verify(inputReaderMock, Mockito.never()).nextLine(); // Nie powinno by� b��d�w wej�cia
        verify(inputReaderMock, Mockito.never()).nextInt(); // Nie powinno by� b��d�w wej�cia
        verify(optionDensityMock).getOptionDensity(inputReaderMock); // Sprawdzenie, czy metoda by�a wywo�ywana
    }

}