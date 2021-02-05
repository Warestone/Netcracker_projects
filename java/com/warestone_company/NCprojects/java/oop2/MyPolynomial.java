package com.warestone_company.NCprojects.java.oop2;

import java.util.Arrays;
import java.util.InputMismatchException;

public class MyPolynomial {

    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        if (coeffs == null) throw new InputMismatchException();
        this.coeffs = coeffs;
    }

    public int getDegree() {
        int counter=0;
        for (double value:coeffs)
        {
            if (Double.compare(value,0.0)==0) break;
            else counter++;
        }
        return counter;
    }

    public double[] getValuesPolynomial() {
        return coeffs;
    }

    private void checkInputPolynomial(MyPolynomial polynomial) {
        if (polynomial == null) throw new InputMismatchException();
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        for(int i=getDegree();i>=0;i--)
        {
            output.append(coeffs[i]).append("x^").append(i);
            if(i!=0) output.append('+');
        }
        return output.toString();
    }

    public double evaluate(double x) {
        double result=0;
        for(int i=getDegree();i>=0;i--) result+=coeffs[i]*Math.pow(x,i);
        return result;
    }

    public MyPolynomial add(MyPolynomial polynomial) {  //      without casting to common type
        checkInputPolynomial(polynomial);
        int sizeThisPolynomial = coeffs.length;
        int address = 0, address2 = 0;
        double[] resultPolynomial = new double[sizeThisPolynomial+polynomial.getDegree()];
        double[] valuesInpPolynomial = polynomial.getValuesPolynomial();
        for (int i = 0; i < resultPolynomial.length; i++){
            if (i<sizeThisPolynomial)
            {
                resultPolynomial[i] = coeffs[address];
                address++;
            }
            else{
                resultPolynomial[i] = valuesInpPolynomial[address2];
                address2++;
            }
        }
        return new MyPolynomial(resultPolynomial);
    }

    public MyPolynomial multiply(MyPolynomial polynomial) {
        checkInputPolynomial(polynomial);
        int sizeInpPolynomial = polynomial.getDegree();
        int sizeThisPolynomial = getDegree();
        double[] resultPolynomial = new double[sizeThisPolynomial+sizeInpPolynomial];
        double[] valuesInpPolynomial = polynomial.getValuesPolynomial();
        for (int i = 0; i < sizeThisPolynomial; i++) {
            for (int s = 0; s < sizeInpPolynomial; s++) resultPolynomial[i+s] += coeffs[i] * valuesInpPolynomial[s];
        }
        return new MyPolynomial(resultPolynomial);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        final int hash = 3;
        final int multiplier = 5;
        return (hash * multiplier + Arrays.hashCode(coeffs));
    }
}
