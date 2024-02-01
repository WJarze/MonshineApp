package MoonshineMethod.MethodsCalculatingYield;

import MoonshineData.DataAlcYield.RawMaterial;
import MoonshineData.DataAlcYield.Yield;
import MoonshineDataRead.DataReadYield.DataReadYield;
import MoonshineDataRead.InputReader;
import exception.NoSuchOptionException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlLoopYield {
public static final Logger log = Logger.getLogger (ControlLoopYield.class.getName ( ));
    public void alcYieldRawMaterial(InputReader inputReader , DataReadYield dataReadYield , RawMaterial rawMaterial
            , AlcMethodYield alcMethod) {
        Yield yield;
        do {
            yield = getMoonshineData( inputReader , dataReadYield);
            switch (yield) {
                case SUGAR -> {
                    rawMaterial.setSugarMass ( dataReadYield.rawMaterialMass ( inputReader ) );
                    log.log ( Level.INFO , String.valueOf ( alcMethod.alcYieldSugar ( rawMaterial ) ) );
                }
                case WHEAT -> {
                    rawMaterial.setWheatMass ( dataReadYield.rawMaterialMass ( inputReader ) );
                    log.log ( Level.INFO , String.valueOf ( alcMethod.alcYieldWheat ( rawMaterial ) ) );
                }
                case CORN -> {
                    rawMaterial.setCornMass ( dataReadYield.rawMaterialMass ( inputReader ) );
                    log.log ( Level.INFO , String.valueOf ( alcMethod.alcYieldCorn ( rawMaterial ) ) );
                }
                case POTATO -> {
                    rawMaterial.setPotatoMass ( dataReadYield.rawMaterialMass ( inputReader ) );
                    log.log ( Level.INFO , String.valueOf ( alcMethod.alcYieldPotato ( rawMaterial ) ) );
                }
            }
        } while (yield != Yield.EXIT);
    }
    private Yield  getMoonshineData(InputReader inputReader , DataReadYield dataReadYield) {
        boolean yieldOk = false;
        Yield yield = null;
        while (!yieldOk) {
            try {
                yield = Yield.createFromInt(dataReadYield.getOptionYield ( inputReader ));
                yieldOk = true;
            } catch (NoSuchOptionException e) {
                log.log ( Level.INFO , e.getMessage() + ", please re-enter:");
            } catch (InputMismatchException ignored) {
                log.log ( Level.INFO ,"You entered a value that is not a number, please re-enter:");
            }
        }
        return yield;
    }

}
