package MoonshineMethod.MethodsCalculatingYield;

import MoonshineData.DataAlcYield.AlcYieldResult;
import MoonshineData.DataAlcYield.RawMaterial;
import MoonshineData.DataAlcYield.Yield;


public class AlcMethodYield {
    AlcYieldResult alcYieldResult = new AlcYieldResult ( );

    public AlcYieldResult alcYieldSugar(RawMaterial rawMaterial) {

        double alcYield = 0.995 * Yield.SUGAR.getValue ( ) * rawMaterial.getSugarMass ( );
        alcYieldResult.setAlcYield ( alcYield );
        return alcYieldResult;
    }

    public AlcYieldResult alcYieldWheat(RawMaterial rawMaterial) {
        double alcYield = 0.995 * Yield.WHEAT.getValue ( ) * rawMaterial.getWheatMass ( );
        alcYieldResult.setAlcYield ( alcYield );
        return alcYieldResult;
    }

    public AlcYieldResult alcYieldCorn(RawMaterial rawMaterial) {
        double alcYield = 0.995 * Yield.CORN.getValue ( ) * rawMaterial.getCornMass ( );
        alcYieldResult.setAlcYield ( alcYield );
        return alcYieldResult;
    }

    public AlcYieldResult alcYieldPotato(RawMaterial rawMaterial) {
        double alcYield = 0.995 * Yield.POTATO.getValue ( ) * rawMaterial.getPotatoMass ( );
        alcYieldResult.setAlcYield ( alcYield );
        return alcYieldResult;
    }
}
