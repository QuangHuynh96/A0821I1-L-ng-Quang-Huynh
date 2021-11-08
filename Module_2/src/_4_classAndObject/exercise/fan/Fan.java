package _4_classAndObject.exercise.fan;

public class Fan {
    //final
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    private int speed;
    private boolean on;
    private double darius;
    private String color;

    //contrustor
    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.darius = 5;
        this.color = "blue";
    }
    //geter
    /*
    public int getFAST() {
        return this.FAST;
    }
    public int getMEDIUM() {
        return this.MEDIUM;
    }
    public int getSLOW() {
        return this.SLOW;
    }*/

    public int getSpeed() {
        return this.speed;
    }
    public boolean getStatus() {
        return this.on;
    }
    public double getDarius() {
        return this.darius;
    }
    public String getColor() {
        return this.color;
    }

    //seter
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setStatus(boolean status) {
        this.on = status;
    }
    public void setDarius(double darius) {
        this.darius = darius;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
            if( this.getStatus() == true) {
                return (this.getSpeed()+", "+ this.getColor()+", "+ this.getDarius()+", fan is on.");
            }else {
                return (this.getColor()+", "+ this.getDarius()+", fan is off.");
            }
    }

}