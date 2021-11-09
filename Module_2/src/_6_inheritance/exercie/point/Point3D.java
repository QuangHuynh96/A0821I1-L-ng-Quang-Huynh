package _6_inheritance.exercie.point;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {
    }

    public Point3D( float z) {
        this.z= z;
    }

    public Point3D( float x, float y, float z) {
        super(x,y);
        this.z= z;
    }

    public float getZ() {
        return this.z;
    }

    public void setZ( float z) {
        this.z= z;
    }

    public void setXYZ( float x, float y, float z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public float[] getXYZ() {
        float[] arr= {getX(), getY(), getZ()};
        return arr;

    }
    @Override
    public String toString() {
        return "("+getX()+","+getY()+","+getZ()+")";
    }
}
