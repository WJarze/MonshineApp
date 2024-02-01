package MoonshineMethod;

import MoonshineData.DataAlcYield.RawMaterial;
import MoonshineData.DataConcentrationAlc.AlcConcentration;
import MoonshineData.DataConcentrationAlc.Coefficient;
import MoonshineData.DataEfficiency.DataEfficiency;
import MoonshineData.DestillationData.Distillate;
import MoonshineDataRead.DataReadConcentrationAlc.DataReadConcentrationAlc;
import MoonshineDataRead.DataReadDestillate.DataReadDistillate;
import MoonshineDataRead.DataReadEfficiency.DataReadEfficiency;
import MoonshineDataRead.DataReadMoonshine;
import MoonshineDataRead.DataReadYield.DataReadYield;
import MoonshineDataRead.DensityOption.OptionDensity;
import MoonshineDataRead.InputReader;
import MoonshineDataRead.InputReaderScanner;
import MoonshineMethod.ChemicalProperties.DensityAlc;
import MoonshineMethod.DestillateYieldCalculation.DistillationYield;
import MoonshineMethod.DestillateYieldCalculation.DistillationYieldCalculation;
import MoonshineMethod.EfficiencyCalculation.EfficiencyCalculation;
import MoonshineMethod.EfficiencyCalculation.EfficiencyMethod;
import MoonshineMethod.MethodsCalculatingYield.AlcMethodYield;
import MoonshineMethod.MethodsCalculatingYield.ControlLoopYield;
import MoonshineMethod.ModelConcentrationAlc.AlcCalculation;
import MoonshineMethod.ModelConcentrationAlc.InterpolationFunction;
import MoonshineMethod.ModelConcentrationAlc.InterpolationFunctionPureAlc;
import MoonshineMethod.ModelConcentrationAlc.Volume;
import MoonshineMethod.ModelConcentrationAlc.Weight;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class MoonshineMethodTest {
    MoonshineMethod moonshine = new MoonshineMethod ( );
    Scanner scanner = new Scanner ( System.in );
    InputReader inputReader = new InputReaderScanner ( scanner );
    DataReadDistillate dataReadDistillate = new DataReadDistillate ( );
    DataReadMoonshine dataReadMoonshine = new DataReadMoonshine ( );
    DistillationYield distillationYield = new DistillationYield ( );
    Distillate distillate = new Distillate ( );
    DistillationYieldCalculation distillationYieldCalculation = new DistillationYieldCalculation ( );
    ControlLoopYield controlLoopYield = new ControlLoopYield ( );
    RawMaterial rawMaterial = new RawMaterial ( );
    AlcMethodYield alcMethod = new AlcMethodYield ( );
    DataReadYield dataReadYield = new DataReadYield ( );
    AlcCalculation alcCalculation = new AlcCalculation ( );
    DataReadConcentrationAlc dataReadConcentrationAlc = new DataReadConcentrationAlc ( );
    InterpolationFunction interpolation = new InterpolationFunction ( );
    InterpolationFunctionPureAlc interpolationPureAlc = new InterpolationFunctionPureAlc ( );
    AlcConcentration alcConcentration = new AlcConcentration ( );
    Coefficient coefficient = new Coefficient ( );
    Volume volume = new Volume ( );
    Weight weight = new Weight ( );
    EfficiencyMethod efficiencyMethod = new EfficiencyMethod ( );
    DataReadEfficiency dataReadEfficiency = new DataReadEfficiency ( );
    DataEfficiency dataEfficiency = new DataEfficiency ( );
    EfficiencyCalculation efficiencyCalculation = new EfficiencyCalculation ( );
    DensityAlc densityAlc = new DensityAlc ( );
    OptionDensity optionDensity = new OptionDensity ( );
    @Test
    void moonshineMethod() {

        MoonshineMethod mock = Mockito.mock(MoonshineMethod.class);
        mock.moonshineMethod (  inputReader
                ,  dataReadDistillate
                ,  dataReadMoonshine
                ,  distillationYield
                ,  distillate
                ,  distillationYieldCalculation
                ,  controlLoopYield
                ,  rawMaterial
                ,  alcMethod
                ,  dataReadYield
                ,  alcCalculation
                ,  dataReadConcentrationAlc
                ,  interpolation
                ,  interpolationPureAlc
                ,  alcConcentration
                ,  coefficient
                ,  volume
                ,  weight
                ,  efficiencyMethod
                ,  dataReadEfficiency
                ,  dataEfficiency
                ,  efficiencyCalculation
                ,  densityAlc
                ,  optionDensity);
        Mockito.verify(mock, Mockito.times(1)).moonshineMethod (  inputReader
                ,  dataReadDistillate
                ,  dataReadMoonshine
                ,  distillationYield
                ,  distillate
                ,  distillationYieldCalculation
                ,  controlLoopYield
                ,  rawMaterial
                ,  alcMethod
                ,  dataReadYield
                ,  alcCalculation
                ,  dataReadConcentrationAlc
                ,  interpolation
                ,  interpolationPureAlc
                ,  alcConcentration
                ,  coefficient
                ,  volume
                ,  weight
                ,  efficiencyMethod
                ,  dataReadEfficiency
                ,  dataEfficiency
                ,  efficiencyCalculation
                ,  densityAlc
                ,  optionDensity);
    }
}