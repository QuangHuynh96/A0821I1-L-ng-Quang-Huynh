package _7_abstractAndInterface.exercise.Shape;


public abstract class Shape2 implements Resizeable {
    protected String color;
    protected boolean filled;

    public Shape2() {
        this.color= "green";
        this.filled= true;
    }

    public Shape2(String color, boolean filled) {
        this.color= color;
        this.filled= filled;
    }

    public String getColor() {
        return this.color;
    }

    public boolean getFilled() {
        return this.filled;
    }

    public void setColor(String color) {
        this.color= color;
    }

    public void setFilled(boolean filled) {
        this.filled= filled;
    }

    public String toString() {
        if(this.filled == true) {
            return "A Shape with color of "+this.getColor()+" and filled.";
        }else {
            return "A Shape with color of "+this.getColor()+" and not filled.";
        }
    }

    public abstract double getArea();
}
