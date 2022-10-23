package MoonshineMethod.ModelConcentrationAlc;

import MoonshineData.DataConcentrationAlc.AlcConcentration;
import MoonshineData.DataConcentrationAlc.Coefficient;

public class InterpolationFunctionPureAlc {
    protected double vectorA100(Coefficient coefficient , AlcConcentration alc) {
        double sumA = 0;
        double dA = 0;
        for (int i = 1; i < coefficient.getA ( ).length; i++) {
            sumA += coefficient.getA ( )[ i ] * Math.pow ( alc.getPureAlcWeightConcentration ( ) , i );
            dA = coefficient.getA ( )[ 0 ] + sumA;
        }
        return dA;
    }

    protected double vectorB100(Coefficient coefficient , AlcConcentration alc) {
        double sumaB = 0;
        double dB = 0;
        for (int i = 0; i < coefficient.getB ( ).length; i++) {
            sumaB += coefficient.getB ( )[ i ] * Math.pow ( (alc.getTemperature ( ) - 20) , i + 1 );
            dB = sumaB;
        }
        return dB;
    }

    protected double vectorC100(Coefficient coefficient , AlcConcentration alc) {
        double sumaC = 0;
        double dC = 0;
        for (int i = 0; i < coefficient.getC ( ).length; i++) {
            sumaC += coefficient.getC ( )[ i ] * Math.pow ( alc.getPureAlcWeightConcentration ( ) , i + 1 ) * (alc.getTemperature ( ) - 20);
            dC = sumaC;
        }
        return dC;
    }

    protected double vectorD100(Coefficient coefficient , AlcConcentration alc) {
        double sumaD = 0;
        double dD = 0;
        for (int i = 0; i < coefficient.getD ( ).length; i++) {
            sumaD += coefficient.getD ( )[ i ] * Math.pow ( alc.getPureAlcWeightConcentration ( ) , i + 1 ) * Math.pow ( (alc.getTemperature ( ) - 20) , 2 );
            dD = sumaD;
        }
        return dD;
    }

    protected double vectorE100(Coefficient coefficient , AlcConcentration alc) {
        double sumaE = 0;
        double dE = 0;
        for (int i = 0; i < coefficient.getE ( ).length; i++) {
            sumaE += coefficient.getE ( )[ i ] * Math.pow ( alc.getPureAlcWeightConcentration ( ) , i + 1 ) * Math.pow ( (alc.getTemperature ( ) - 20) , 3 );
            dE = sumaE;
        }
        return dE;
    }

    protected double vectorF100(Coefficient coefficient , AlcConcentration alc) {
        double sumaF = 0;
        double dF = 0;
        for (int i = 0; i < coefficient.getF ( ).length; i++) {
            sumaF += coefficient.getF ( )[ i ] * Math.pow ( alc.getPureAlcWeightConcentration ( ) , i + 1 ) * Math.pow ( (alc.getTemperature ( ) - 20) , 4 );
            dF = sumaF;
        }
        return dF;
    }

    protected double vectorG100(Coefficient coefficient , AlcConcentration alc) {
        double sumaG = 0;
        double dG = 0;
        for (int i = 0; i < coefficient.getG ( ).length; i++) {
            sumaG += coefficient.getG ( )[ i ] * Math.pow ( alc.getPureAlcWeightConcentration ( ) , i + 1 ) * Math.pow ( (alc.getTemperature ( ) - 20) , 5 );
            dG = sumaG;
        }
        return dG;
    }

    protected double densityPureAlc(Coefficient coefficient , AlcConcentration alc) {

        double A100 = vectorA100 ( coefficient , alc );
        double B100 = vectorB100 ( coefficient , alc );
        double C100 = vectorC100 ( coefficient , alc );
        double D100 = vectorD100 ( coefficient , alc );
        double E100 = vectorE100 ( coefficient , alc );
        double F100 = vectorF100 ( coefficient , alc );
        double G100 = vectorG100 ( coefficient , alc );
        double density = A100 + B100 + C100 + D100 + E100 + F100 + G100;
        alc.setPureAlcDensity ( density );
        return alc.getPureAlcDensity ( );
    }

}
