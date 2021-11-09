package _6_inheritance.exercie.point;

public class Point2D {
    private float x;
    private float y;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x= x;
        this.y= y;
    }

    public void setX( float x) {
        this.x= x;
    }

    public void setY( float y) {
        this.y= y;
    }

    public void setXY( float x, float y) {
        setX(x);
        setY(y);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float[] getXY() {
        float[] arr= {this.getX(), this.getY()} ;
        return arr;
    }

    public String toString() {
        return "("+this.x+","+this.y+")";
    }
}
