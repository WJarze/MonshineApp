package MoonshineMethod.ModelConcentrationAlc;


import MoonshineData.DataConcentrationAlc.AlcConcentration;
import MoonshineData.DataConcentrationAlc.Coefficient;

public class InterpolationFunction {
    protected double vectorA(Coefficient coefficient , AlcConcentration alcConcentration) {
        double sumA = 0;
        double dA = 0;
        for (int i = 1; i < coefficient.getA ( ).length; i++) {
            sumA += coefficient.getA ( )[ i ] * Math.pow ( alcConcentration.getAlcConcentration ( ) , i );
            dA = coefficient.getA ( )[ 0 ] + sumA;
        }
        return dA;
    }

    protected double vectorB(Coefficient coefficient , AlcConcentration alcConcentration) {
        double sumaB = 0;
        for (int i = 0; i < coefficient.getB ( ).length; i++) {
            sumaB += coefficient.getB ( )[ i ] * Math.pow ( (alcConcentration.getTemperature ( ) - 20) , i + 1 );
        }
        return sumaB;
    }

    protected double vectorC(Coefficient coefficient , AlcConcentration alcConcentration) {
        double sumaC = 0;
        double dC = 0;
        for (int i = 0; i < coefficient.getC ( ).length; i++) {
            sumaC += coefficient.getC ( )[ i ] * Math.pow ( alcConcentration.getAlcConcentration ( ) , i + 1 ) * (alcConcentration.getTemperature ( ) - 20);
            dC = sumaC;
        }
        return dC;
    }

    protected double vectorD(Coefficient coefficient , AlcConcentration alcConcentration) {
        double sumaD = 0;
        double dD = 0;
        for (int i = 0; i < coefficient.getD ( ).length; i++) {
            sumaD += coefficient.getD ( )[ i ] * Math.pow ( alcConcentration.getAlcConcentration ( ) , i + 1 ) * Math.pow ( (alcConcentration.getTemperature ( ) - 20) , 2 );
            dD = sumaD;
        }
        return dD;
    }

    protected double vectorE(Coefficient coefficient , AlcConcentration alcConcentration) {
        double sumaE = 0;
        double dE = 0;
        for (int i = 0; i < coefficient.getE ( ).length; i++) {
            sumaE += coefficient.getE ( )[ i ] * Math.pow ( alcConcentration.getAlcConcentration ( ) , i + 1 ) * Math.pow ( (alcConcentration.getTemperature ( ) - 20) , 3 );
            dE = sumaE;
        }
        return dE;
    }

    protected double vectorF(Coefficient coefficient , AlcConcentration alcConcentration) {
        double sumaF = 0;
        double dF = 0;
        for (int i = 0; i < coefficient.getF ( ).length; i++) {
            sumaF += coefficient.getF ( )[ i ] * Math.pow ( alcConcentration.getAlcConcentration ( ) , i + 1 ) * Math.pow ( (alcConcentration.getTemperature ( ) - 20) , 4 );
            dF = sumaF;
        }
        return dF;
    }

    protected double vectorG(Coefficient coefficient , AlcConcentration alcConcentration) {
        double sumaG = 0;
        double dG = 0;
        for (int i = 0; i < coefficient.getG ( ).length; i++) {
            sumaG += coefficient.getG ( )[ i ] * Math.pow ( alcConcentration.getAlcConcentration ( ) , i + 1 ) * Math.pow ( (alcConcentration.getTemperature ( ) - 20) , 5 );
            dG = sumaG;
        }
        return dG;
    }

    protected double density(Coefficient coefficient , AlcConcentration alcConcentration) {

        double A = vectorA ( coefficient , alcConcentration );
        double B = vectorB ( coefficient , alcConcentration );
        double C = vectorC ( coefficient , alcConcentration );
        double D = vectorD ( coefficient , alcConcentration );
        double E = vectorE ( coefficient , alcConcentration );
        double F = vectorF ( coefficient , alcConcentration );
        double G = vectorG ( coefficient , alcConcentration );
        double density = A + B + C + D + E + F + G;
        alcConcentration.setDensity ( density );
        return density;
    }
}
