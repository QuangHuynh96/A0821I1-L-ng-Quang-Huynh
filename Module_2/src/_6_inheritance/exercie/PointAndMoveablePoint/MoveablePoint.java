package _6_inheritance.exercie.PointAndMoveablePoint;

public class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public  MoveablePoint() {}

    public MoveablePoint( float xSpeed, float ySpeed) {
        this.xSpeed= xSpeed;
        this.ySpeed= ySpeed;
    }

    public MoveablePoint( float x, float y, float xSpeed, float ySpeed) {
        super(x,y);
        this.xSpeed= xSpeed;
        this.ySpeed= ySpeed;
    }

    public void setXspeed( float xSpeed) {
        this.xSpeed= xSpeed;
    }

    public void setYspeed( float ySpeed) {
        this.ySpeed= ySpeed;
    }

    public float getXspeed()  {
        return this.xSpeed;
    }

    public float getYspeed() {
        return this.ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed= xSpeed;
        this.ySpeed= ySpeed;
    }

    public float[] getSpeed() {
        float[] arr= {this.getXspeed(),this.getYspeed()} ;
        return arr;
    }
@Override
    public String toString() {
        return "("+this.getX()+","+this.getY()+"),speed=("
                +this.getXspeed()+","+this.getYspeed()+")";
    }

    public MoveablePoint move() {
        this.setX(this.getX() + this.getXspeed());
        this.setY(this.getY() + this.getYspeed());
        return this;// return this == return this.toString
    }
}
