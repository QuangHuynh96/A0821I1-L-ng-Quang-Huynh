package _4_classAndObject.exercise.quadraticEquation;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double geta() {
        return a;
    }
    public double getb() {
        return b;
    }
    public double getc() {
        return c;
    }

    public double  getDiscriminant() {
        double delta = getb()*getb() - 4*geta()*getc();
        return delta;
    }

    public double getRoot1() {
        double r1 = ((-getb()) + Math.pow(getDiscriminant(), 0.5) )/ 2*geta() ;
        return r1;
    }

    public double getRoot2() {
        double r2 = ((-getb()) - Math.pow(getDiscriminant(), 0.5) )/ 2*geta() ;
        return r2;
    }
}
