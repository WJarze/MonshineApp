package MonshineApp;

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
import MoonshineMethod.MoonshineMethod;
import exception.NoSuchOptionException;

import java.util.Scanner;

public class Moonshine {
    MoonshineMethod moonshine = new MoonshineMethod ( );
    Scanner scanner = new Scanner ( System.in );
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

    public MoonshineMethod moonshineAppMethod() throws NoSuchOptionException {
        moonshine.moonshineMethod ( scanner
                , dataReadDistillate
                , dataReadMoonshine
                , distillationYield
                , distillate
                , distillationYieldCalculation
                , controlLoopYield
                , rawMaterial
                , alcMethod
                , dataReadYield
                , alcCalculation
                , dataReadConcentrationAlc
                , interpolation
                , interpolationPureAlc
                , alcConcentration
                , coefficient
                , volume
                , weight
                , efficiencyMethod
                , dataReadEfficiency
                , dataEfficiency
                , efficiencyCalculation
                , densityAlc
                , optionDensity);
                return moonshine ;
    }
}
