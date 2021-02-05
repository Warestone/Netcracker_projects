package com.warestone_company.NCprojects.java.oop2;

import java.math.BigDecimal;
import java.util.InputMismatchException;

public class MyComplex {

    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex(double real, double imag) {
        setValue(real,imag);
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void setValue(double real, double imag) {
        setReal(real);
        setImag(imag);
    }

    @Override
    public String toString() {
        return '(' + real + '+' + imag + "i)";
    }

    public boolean isReal() {
        return BigDecimal.valueOf(real).compareTo(BigDecimal.ZERO) == 0;
    }

    public boolean isImaginary() {
        return BigDecimal.valueOf(imag).compareTo(BigDecimal.ZERO) == 0;
    }

    public boolean equals(double real, double imag) {
        if (Double.compare(this.real,real) == 0)
            return Double.compare(this.imag,imag) == 0;
        else return false;
    }

    public boolean equals(MyComplex complex) {
        if (this == complex) return true;
        if (complex == null ) return false;
        return equals(complex.getReal(),getImag());
    }

    private void checkInputComplex(MyComplex complex) {
        if (complex == null) throw new InputMismatchException("Input complex is null");
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real,2) + Math.pow(imag,2));
    }

    public MyComplex add(MyComplex complex) {        // operations over this instance & return .this
        checkInputComplex(complex);
        real += complex.getReal();
        imag += complex.getImag();
        return this;
    }

    public MyComplex subtract(MyComplex complex) {
        checkInputComplex(complex);
        real -= complex.getReal();
        imag -= complex.getImag();
        return this;
    }

    public MyComplex multiply(MyComplex complex) {
        checkInputComplex(complex);
        double real2 = complex.getReal();
        double imag2 = complex.getImag();
        double real1 = real;
        double imag1 = imag;
        setReal(real1 * real2 - imag1 * imag2);
        setImag(imag1 * real2 + real1 * imag2);
        return this;
    }

    public MyComplex divide(MyComplex complex) {
        checkInputComplex(complex);
        double real2 = complex.getReal();
        double imag2 = complex.getImag();
        double lower = Math.pow(real2,2) + Math.pow(imag2,2);
        real = (real * real2 + imag * imag2) / lower;
        imag = (real2 * imag - real * imag2) / lower;
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(real,-imag);
    }

    public double argument() {
        return Math.atan(real/imag)*180/Math.PI;
    }

    public MyComplex addNew(MyComplex complex) {            // clone .this instance & add/subtract clone and input complex. Returns a clone.
        checkInputComplex(complex);                         // .this instance don't change
        return cloneCurrentComplex().add(complex);
    }

    public MyComplex subtractNew(MyComplex complex) {
        checkInputComplex(complex);
        return cloneCurrentComplex().subtract(complex);
    }

    private MyComplex cloneCurrentComplex() {               // return a new instance with .this real & imagination parts
        return new MyComplex(real,imag);
    }

    @Override
    public int hashCode() {
        final int hash = 3;
        final int multiplier = 5;
        return (int) (hash * multiplier + real + imag);
    }
}
