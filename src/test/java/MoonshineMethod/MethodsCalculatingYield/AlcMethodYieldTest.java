package MoonshineMethod.MethodsCalculatingYield;

import MoonshineData.DataAlcYield.AlcYieldResult;
import MoonshineData.DataAlcYield.RawMaterial;
import MoonshineData.DataAlcYield.Yield;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class AlcMethodYieldTest {


    @Test
    void testAlcYieldSugar() {
        RawMaterial rawMaterial = new RawMaterial ( );
        rawMaterial.setSugarMass ( 1 );
        AlcMethodYield alcMethodYield = new AlcMethodYield ( );

        AlcYieldResult result = alcMethodYield.alcYieldSugar ( rawMaterial );

        assertEquals ( 1 * 0.574 * 1 , result.getAlcYield ( ) , 0.01 );
    }


    @Test
    void alcYieldWheat() {
        RawMaterial rawMaterial = new RawMaterial ( );
        rawMaterial.setCornMass ( 1 );
        AlcMethodYield alcMethodYield = new AlcMethodYield ( );

        AlcYieldResult result = alcMethodYield.alcYieldCorn ( rawMaterial );

        assertEquals ( 1 * 0.346 * 1 , result.getAlcYield ( ) , 0.01 );
    }

    @Test
    void alcYieldCorn() {
        RawMaterial rawMaterial = new RawMaterial ( );
        rawMaterial.setPotatoMass ( 1 );
        AlcMethodYield alcMethodYield = new AlcMethodYield ( );

        AlcYieldResult result = alcMethodYield.alcYieldPotato ( rawMaterial );

        assertEquals ( 1 * 0.0935 * 1 , result.getAlcYield ( ) , 0.01 );
    }

    @Test
    void alcYieldPotato() {
        RawMaterial rawMaterial = new RawMaterial ( );
        rawMaterial.setWheatMass ( 1 );
        AlcMethodYield alcMethodYield = new AlcMethodYield ( );

        AlcYieldResult result = alcMethodYield.alcYieldWheat ( rawMaterial );

        assertEquals ( 1 * 0.353 * 1 , result.getAlcYield ( ) , 0.01 );
    }
}