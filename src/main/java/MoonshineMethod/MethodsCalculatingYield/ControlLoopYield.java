package MoonshineMethod.MethodsCalculatingYield;

import MoonshineData.DataAlcYield.RawMaterial;
import MoonshineData.DataAlcYield.Yield;
import MoonshineDataRead.DataReadYield.DataReadYield;
import exception.NoSuchOptionException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlLoopYield {
public static final Logger log = Logger.getLogger (ControlLoopYield.class.getName ( ));
    public void alcYieldRawMaterial(Scanner scanner , DataReadYield dataReadYield , RawMaterial rawMaterial
            , AlcMethodYield alcMethod) {
        Yield yield;
        do {
            yield = getMoonshineData( scanner, dataReadYield);
            switch (yield) {
                case SUGAR -> {
                    rawMaterial.setSugarMass ( dataReadYield.rawMaterialMass ( scanner ) );
                    log.log ( Level.INFO , String.valueOf ( alcMethod.alcYieldSugar ( rawMaterial ) ) );
                }
                case WHEAT -> {
                    rawMaterial.setWheatMass ( dataReadYield.rawMaterialMass ( scanner ) );
                    log.log ( Level.INFO , String.valueOf ( alcMethod.alcYieldWheat ( rawMaterial ) ) );
                }
                case CORN -> {
                    rawMaterial.setCornMass ( dataReadYield.rawMaterialMass ( scanner ) );
                    log.log ( Level.INFO , String.valueOf ( alcMethod.alcYieldCorn ( rawMaterial ) ) );
                }
                case POTATO -> {
                    rawMaterial.setPotatoMass ( dataReadYield.rawMaterialMass ( scanner ) );
                    log.log ( Level.INFO , String.valueOf ( alcMethod.alcYieldPotato ( rawMaterial ) ) );
                }
            }
        } while (yield != Yield.EXIT);
    }
    private Yield  getMoonshineData(Scanner scanner, DataReadYield dataReadYield) {
        boolean yieldOk = false;
        Yield yield = null;
        while (!yieldOk) {
            try {
                yield = Yield.createFromInt(dataReadYield.getOptionYield ( scanner ));
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
