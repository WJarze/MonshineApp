package MoonshineMethod.MethodsCalculatingYield;

import MoonshineData.DataAlcYield.RawMaterial;
import MoonshineData.DataAlcYield.Yield;
import MoonshineDataRead.DataReadYield.DataReadYield;
import exception.NoSuchOptionException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlLoopYield {

    public void alcYieldRawMaterial(Scanner scanner , DataReadYield dataReadYield , RawMaterial rawMaterial
            , AlcMethodYield alcMethod) {
        Yield yield;
        do {
            printOptions ( );
            yield = getMoonshineData( scanner, dataReadYield);
            switch (yield) {
                case SUGAR -> {
                    rawMaterial.setSugarMass ( dataReadYield.rawMaterialMass ( scanner ) );
                    System.out.println ( alcMethod.alcYieldSugar ( rawMaterial ) );
                }
                case WHEAT -> {
                    rawMaterial.setWheatMass ( dataReadYield.rawMaterialMass ( scanner ) );
                    System.out.println ( alcMethod.alcYieldWheat ( rawMaterial ) );
                }
                case CORN -> {
                    rawMaterial.setCornMass ( dataReadYield.rawMaterialMass ( scanner ) );
                    System.out.println ( alcMethod.alcYieldCorn ( rawMaterial ) );
                }
                case POTATO -> {
                    rawMaterial.setPotatoMass ( dataReadYield.rawMaterialMass ( scanner ) );
                    System.out.println ( alcMethod.alcYieldPotato ( rawMaterial ) );
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
                System.out.println ( e.getMessage() + ", please re-enter:");
            } catch (InputMismatchException ignored) {
                System.out.println("You entered a value that is not a number, please re-enter:");
            }
        }
        return yield;
    }
    private void printOptions() {
        System.out.println ( "Choice the option: " );
        for (Yield yield : Yield.values ( )) {
            System.out.println ( yield );
        }
    }
}
