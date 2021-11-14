package _7_abstractAndInterface.exercise.Shape;

public class Square2 extends Rectangle2 implements Resizeable, Colorable {
    public Square2() {
    }

    public Square2(double side) {
        super(side, side);
    }

    public Square2(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.setWidth(this.getWidth()* percent);
        this.setLength(this.getLength()* percent);
    }

    @Override
    public String howToColor() {
        return "Color all four sides.";
    }
}
